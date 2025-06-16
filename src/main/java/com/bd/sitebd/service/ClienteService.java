package com.bd.sitebd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.sitebd.model.Cliente;
import com.bd.sitebd.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void inserir(Cliente cli) {
        clienteRepository.save(cli);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void removerPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
