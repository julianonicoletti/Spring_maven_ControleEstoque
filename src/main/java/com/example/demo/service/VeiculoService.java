package com.example.demo.service;

import com.example.demo.model.Veiculo;

import java.util.List;

public interface VeiculoService <T extends Veiculo>{
   List<T> listar();

   T criar(T t);

   T atualizar(T t, Long id);
   boolean deletar(Long id);

   List<T> listarPorPreco();

   String retornaIpva(Long id);

   List<T> aplicarBlackFriday();
}
