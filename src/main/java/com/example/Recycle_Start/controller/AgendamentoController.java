package com.example.Recycle_Start.controller;

import com.example.Recycle_Start.model.Agendamento;
import com.example.Recycle_Start.model.Empresa;
import com.example.Recycle_Start.model.Usuario;
import com.example.Recycle_Start.service.AgendamentoService;
import com.example.Recycle_Start.service.EmpresaService;
import com.example.Recycle_Start.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AgendamentoController {


    @Autowired
     private AgendamentoService agendamentoService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping ("/agendamento")
    public String getAgendament(Agendamento agendamento) {
        /*model.addAttribute("Empresa", this.empresaService.empresaCnpj(cnpj));*/

        return "condominio-agendamento";
    }

    // para salvar um agendamento
    @PostMapping("/salvarAgendamento")
    public String novoAgendamento(Agendamento agendamento) {
        agendamentoService.salvarAgendamento(agendamento);
        return "redirect:/usuario";
    }

    //para mostsra as em presa e ir para a agendamento
    @GetMapping("/AgendamentoUsuario")
    public String EmpresaUsuario(Model model){
        model.addAttribute("empresa", this.empresaService.mostraEmpresas());
        return "agendamento-condominio";
    }

    // para mostra o agendamento dentro da enpresa
    @GetMapping("/agendamentoEnpresa")
    public String agendamentoEnpresa(Model model){
        model.addAttribute("agendamento" , this.agendamentoService.mostraAgendamanto());
        return "agendamentoEnpresa";
    }


//  mostra agenadamanto
    @GetMapping("/Agendamantos")
    public  String MostraAgenda(Model model){
        List<Agendamento> agendamento = agendamentoService.mostraAgendamanto();
        model.addAttribute("agendamento", agendamento);
        return "administrador-agendamento";
    }

    @GetMapping("/deletarAgendamento/{id_agendamento}")
    public String deletarAgendamento( @PathVariable("id_agendamento") Integer id_agendamento, Agendamento agendamento) {
        agendamentoService.excluirAgendamanto(id_agendamento);
        return "redirect:/Agendamantos";
    }
}
