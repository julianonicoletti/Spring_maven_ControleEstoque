package com.example.demo.controller;

import com.example.demo.model.Motocicleta;
import com.example.demo.service.MotocicletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Motocicleta")
public class MotocicletaController {

    @Autowired
    MotocicletaService motocicletaService;

    @GetMapping
    public List<Motocicleta> listarMotocicletas() {
        return motocicletaService.listar();
    }

    @GetMapping("/listarPreco")
    public List<Motocicleta> listarPorKmetragem() {
        return motocicletaService.listarPorPreco();
    }

    @PostMapping
    public Motocicleta criar(@Valid @RequestBody Motocicleta Motocicleta) {
        return motocicletaService.criar(Motocicleta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Motocicleta Motocicleta) {
        //return funcionarioService.atualizar(id, funcionario);
        if (motocicletaService.atualizar(Motocicleta, id) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
            //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Motocicleta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (motocicletaService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/ipva/{id}")
    public ResponseEntity<?> retornaIpva(@PathVariable Long id) {
        String ipva = motocicletaService.retornaIpva(id);
        if (ipva == null) {
            String mensagem = "O ID informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(ipva);
        }
    }

    @GetMapping("/blackfriday/")
    public List<Motocicleta> aplicarBlackFriday() {
        return motocicletaService.aplicarBlackFriday();
    }
}

