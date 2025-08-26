package com.fatec.sjc.pastelFatec2.service;

import com.fatec.sjc.pastelFatec2.dto.PastelDTO;
import com.fatec.sjc.pastelFatec2.model.Pastel;
import com.fatec.sjc.pastelFatec2.repository.PastelariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastelService {

    @Autowired
    private PastelariaRepository repository;


    public List<PastelDTO> obterTodosOsPastel() {
        return repository.findAll().stream()
                .map(p -> new PastelDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getCategoria()))
                .toList();
    }


    public void cadastrarPastel(PastelDTO novoPastel) {
        Pastel pastel = new Pastel();
        pastel.setNome(novoPastel.nome());
        pastel.setDescricao(novoPastel.descricao());
        pastel.setPreco(novoPastel.preco());
        pastel.setCategoria(novoPastel.categoria());
        repository.save(pastel);
    }

    public PastelDTO obterPorId(Long id) {
        return repository.findById(id)
                .map(p -> new PastelDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getCategoria()))
                .orElse(null);
    }

    public boolean deletarPastel(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    public PastelDTO atualizarPastel(Long id, PastelDTO pastelAtualizado) {
        return repository.findById(id).map(pastel -> {
            pastel.setNome(pastelAtualizado.nome());
            pastel.setDescricao(pastelAtualizado.descricao());
            pastel.setPreco(pastelAtualizado.preco());
            pastel.setCategoria(pastelAtualizado.categoria());
            repository.save(pastel);
            return new PastelDTO(pastel.getId(), pastel.getNome(), pastel.getDescricao(), pastel.getPreco(), pastel.getCategoria());
        }).orElse(null);
    }

}
