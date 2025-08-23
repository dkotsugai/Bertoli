package com.fatec.sjc.pastelFatec.controller;

import com.fatec.sjc.pastelFatec.model.Pastel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pastelaria/")
public class PastelController {
    private List<Pastel> pastels = new ArrayList<>();

        public PastelController() {
            pastels.addAll(List.of(
                    new Pastel("1", "Pastel de Queijo", "Delicioso pastel recheado com queijo derretido", 5.00, "Salgado"),
                    new Pastel("2", "Pastel de Carne", "Pastel crocante recheado com carne moída temperada", 6.00, "Salgado"),
                    new Pastel("3", "Pastel de Frango com Catupiry", "Pastel recheado com frango desfiado e catupiry cremoso", 7.00, "Salgado"),
                    new Pastel("4", "Pastel de Chocolate", "Pastel doce recheado com chocolate derretido", 5.50, "Doce"),
                    new Pastel("5", "Pastel de Banana com Canela", "Pastel doce recheado com banana e polvilhado com canela", 6.50, "Doce")
            ));
        }


        @GetMapping("/all")
        public List<Pastel> getAllPastels() {
            return pastels;
        }

        @GetMapping("/{id}")
        public ResponseEntity<Pastel> getPastelById(@PathVariable("id") String id) {
            Optional<Pastel> optionalPastel = pastels.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
            if (optionalPastel.isPresent()) {
                return ResponseEntity.ok(optionalPastel.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/add")
        public Pastel createPastel(@RequestBody Pastel pastel) {
            pastels.add(pastel);
            return pastel;
        }

        @PutMapping("/{id}")
        public ResponseEntity<Pastel> updatePastel(@PathVariable("id") String id, @RequestBody Pastel updatedPastel) {
            Optional<Pastel> optionalPastel = pastels.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
            if (optionalPastel.isPresent()) {
                Pastel existingPastel = optionalPastel.get();
                existingPastel.setNome(updatedPastel.getNome());
                existingPastel.setDescricao(updatedPastel.getDescricao());
                existingPastel.setPreco(updatedPastel.getPreco());
                existingPastel.setTipo(updatedPastel.getTipo());
                return ResponseEntity.ok(existingPastel);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePastel(@PathVariable("id") String id) {
            Optional<Pastel> optionalPastel = pastels.stream()
                    .filter(p -> p.getId().equals(id))
                    .findFirst();
            if (optionalPastel.isPresent()) {
                pastels.remove(optionalPastel.get());
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }


