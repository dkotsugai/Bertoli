// Base da API (mesma origem do Spring Boot)
const API = '/pastelaria';

document.addEventListener('DOMContentLoaded', () => {
  const listEl = document.getElementById('pastelaria-list');
  const modalEl = document.getElementById('id01');
  const nomeInput = document.getElementById('nomePastel');
  const submitBtn = document.getElementById('submitBtn');

  submitBtn.addEventListener('click', onAdd);
  loadList();

  async function loadList() {
    try {
      const { data } = await axios.get(API);
      renderList(Array.isArray(data) ? data : []);
    } catch (err) {
      console.error('Erro ao carregar lista:', err);
      listEl.innerHTML = '<li class="list-group-item text-danger">Erro ao carregar pastéis.</li>';
    }
  }

  function renderList(items) {
    listEl.innerHTML = '';
    items.forEach(pastel => {
      const id = pastel.id;
      const nome = pastel.nome ?? '';

      const li = document.createElement('li');
      li.className = 'list-group-item d-flex align-items-center justify-content-between';

      const nameSpan = document.createElement('span');
      nameSpan.textContent = `Nome: ${nome}`;

      const controls = document.createElement('div');
      controls.className = 'd-flex align-items-center';

      const editInput = document.createElement('input');
      editInput.type = 'text';
      editInput.className = 'form-control mr-2';
      editInput.placeholder = 'Novo nome';
      editInput.style.maxWidth = '240px';

      const btnUpdate = document.createElement('button');
      btnUpdate.className = 'btn btn-primary mr-2';
      btnUpdate.textContent = 'Editar nome';
      btnUpdate.addEventListener('click', async () => {
        const novoNome = editInput.value.trim();
        if (!novoNome) return;
        try {
          const { data: atualizado } = await axios.put(`${API}/${id}`, { nome: novoNome });
          nameSpan.textContent = `Nome: ${atualizado?.nome ?? novoNome}`;
          editInput.value = '';
        } catch (err) {
          console.error('Erro ao atualizar pastel:', err);
          alert('Erro ao atualizar pastel.');
        }
      });

      const btnDelete = document.createElement('button');
      btnDelete.className = 'btn btn-danger';
      btnDelete.textContent = 'Excluir';
      btnDelete.addEventListener('click', async () => {
        if (!confirm('Deseja excluir este pastel?')) return;
        try {
          await axios.delete(`${API}/${id}`);
          li.remove();
        } catch (err) {
          console.error('Erro ao excluir pastel:', err);
          alert('Erro ao excluir pastel.');
        }
      });

      controls.appendChild(editInput);
      controls.appendChild(btnUpdate);
      controls.appendChild(btnDelete);

      li.appendChild(nameSpan);
      li.appendChild(controls);
      listEl.appendChild(li);
    });
  }

  async function onAdd() {
    const nome = nomeInput.value.trim();
    if (!nome) {
      alert('Informe o nome do pastel.');
      return;
    }
    try {
      await axios.post(API, { nome });
      nomeInput.value = '';
      if (modalEl) modalEl.style.display = 'none';
      await loadList();
    } catch (err) {
      console.error('Erro ao adicionar pastel:', err);
      alert('Erro ao adicionar pastel.');
    }
  }
});