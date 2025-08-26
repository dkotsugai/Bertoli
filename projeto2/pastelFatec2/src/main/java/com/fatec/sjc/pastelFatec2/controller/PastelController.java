package com.fatec.sjc.pastelFatec2.controller;

import com.fatec.sjc.pastelFatec2.dto.PastelDTO;
import com.fatec.sjc.pastelFatec2.model.Pastel;
import com.fatec.sjc.pastelFatec2.service.PastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pastelaria")
public class PastelController {

    @Autowired
    private PastelService service;

    @GetMapping
    public String ola() {
        return "Olá, seja bem-vindo à Pastelaria da FATEC!";
    }

    @GetMapping("/pasteis")
    public List<PastelDTO> obterTodosOsPastel() {
        return service.obterTodosOsPastel();
    }

    @PostMapping(path = "/new/pastel",
    produces ="application/json",
    consumes ="application/json")
    public void cadastrarPastel(@RequestBody PastelDTO novoPastel) {
        service.cadastrarPastel(novoPastel);
    }

    @PutMapping(path = "/pastel/update/{id}")
    public ResponseEntity<PastelDTO> atualizarPastel(@PathVariable Long id, @RequestBody PastelDTO pastelAtualizado) {
        PastelDTO atualizado = service.atualizarPastel(id, pastelAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/delete/pastel/{id}")
    public ResponseEntity<Void> deletarPastel(@PathVariable Long id) {
        boolean deletado = service.deletarPastel(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}








        
