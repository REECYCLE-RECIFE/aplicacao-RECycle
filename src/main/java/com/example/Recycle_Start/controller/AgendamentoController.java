package com.example.Recycle_Start.controller;

import com.example.Recycle_Start.model.Agendamento;
import com.example.Recycle_Start.service.AgendamentoService;
import com.example.Recycle_Start.service.EmpresaService;
import com.example.Recycle_Start.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgendamentoController {


    @Autowired
     private AgendamentoService agendamentoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping ("/agendamento")
    public String getAgendament(Model model, String cnpj) {
        model.addAttribute("Empresa", this.empresaService.empresaCnpj(cnpj));
        return "agendamento";
    }

    // para salvar um agendamento
    @PostMapping("/salvarAgendamento")
    public String novoAgendamento(Agendamento agendamento) {
        agendamentoService.salvarAgendamento(agendamento);
        return "/usuario";
    }
}
