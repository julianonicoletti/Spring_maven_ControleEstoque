package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
   @Autowired
   CarroService carroService;

   @GetMapping
    public List<Carro> listarCarros() {return carroService.listar();
    }

    @GetMapping("/listarPreco")
    public List<Carro> listarPorPreco() {
       return carroService.listarPorPreco();
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Carro carro) {
        //Carro novoCarro = carroService.criar(carro);
        if (carroService.criar(carro) == null) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Carro já cadastrado.");
        }
        return ResponseEntity.ok(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        if(carroService.atualizar(carro, id) == null) {

            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(carroService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/ipva/{id}")
    public ResponseEntity<?> retornaIpva(@PathVariable Long id){
        String ipva = carroService.retornaIpva(id);
        if (ipva == null) {
            String mensagem = "O ID informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(ipva);
        }
    }

    @GetMapping("/blackfriday")
    public List<Carro> aplicarBlackFriday() {
       return carroService.aplicarBlackFriday();
    }




}
