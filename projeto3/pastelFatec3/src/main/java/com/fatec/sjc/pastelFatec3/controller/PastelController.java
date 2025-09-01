package com.fatec.sjc.pastelFatec3.controller;

import com.fatec.sjc.pastelFatec3.dto.PastelDTO;
import com.fatec.sjc.pastelFatec3.service.PastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pastelaria")
public class PastelController {

    @Autowired
    private PastelService service;

//    @GetMapping
//    public String ola() {
//        return "Olá, seja bem-vindo à Pastelaria da FATEC!";
//    }

    @GetMapping
    public List<PastelDTO> obterTodosOsPastel() {
        return service.obterTodosOsPastel();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PastelDTO> obterPastelPorId(@PathVariable Long id) {
        PastelDTO pastel = service.obterPastelPorId(id);
        if (pastel != null) {
            return ResponseEntity.ok(pastel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void cadastrarPastel(@RequestBody PastelDTO novoPastel ) {
        service.cadastrarPastel(novoPastel);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PastelDTO> atualizarPastel(@PathVariable Long id, @RequestBody PastelDTO pastelAtualizado) {
        PastelDTO atualizado = service.atualizarPastel(id, pastelAtualizado);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarPastel(@PathVariable Long id) {
        boolean deletado = service.deletarPastel(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}








        
