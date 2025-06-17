package com.bd.sitebd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bd.sitebd.model.Cliente;
import com.bd.sitebd.service.ClienteService;

@Controller
public class CadastroController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String principal() {
        return "principal";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Cliente cli) {
        clienteService.inserir(cli);
        return "sucesso";
    }

    @GetMapping("/listagem")
    public String listagem(Model model) {
        List<Cliente> listaClientes = clienteService.buscarTodos();
        model.addAttribute("clientes", listaClientes);
        return "listagem";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizar(Model model, @PathVariable Long id) {
        Cliente cli = clienteService.buscarPorId(id);
        model.addAttribute("id", id);
        model.addAttribute("cliente", cli);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Cliente cli) {
        Cliente clienteExistente = clienteService.buscarPorId(id);
        if (clienteExistente != null) {
            cli.setId(id); 
            clienteService.inserir(cli); 
        }
        return "redirect:/listagem";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.removerPorId(id);
        return "redirect:/listagem";
    }

    @GetMapping("/acesso-negado")
        public String acessoNegado(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("erro", "Você precisa estar logado para acessar essa página!");
        return "redirect:/";
}

}
