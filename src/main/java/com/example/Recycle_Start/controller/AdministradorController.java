package com.example.Recycle_Start.controller;

import com.example.Recycle_Start.model.Administrador;
import com.example.Recycle_Start.repositoris.Util;
import com.example.Recycle_Start.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;


@Controller
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;

    @GetMapping("/CadastroAdm")
    public String CadastroAdm(Administrador administrador){
        return " cadastroadm";
    }

    @PutMapping("/SalvaUsuario")
    public String novoADM(@ModelAttribute("administrador") Administrador administrador){
         administrador.setSenha(Util.md5(administrador.getSenha()));
         administradorService.SalvaAdministrador(administrador);
         return "redirect: login";

    }

    @GetMapping("/editaAdm")
    public String editaAdm (Model model , Integer id_adm){
        model.addAttribute("administrador", administradorService.administradorId(id_adm));
          return "administrador-dados";
    }

    @PutMapping("/atualizarAdm")
    public  String AtualiazarAdm(@Valid Administrador administrador, BindingResult result){
        if (result.hasErrors()){
            System.out.println(result.getAllErrors().get(0).getDefaultMessage());
            administrador.setSenha(Util.md5(administrador.getSenha()));
            System.out.println(administrador.getId_adm());
            return "principal-adm";
        }
        else {
            System.out.println(administrador.getId_adm());
            administrador.setSenha(Util.md5(administrador.getSenha()));
           administradorService.SalvaAdministrador(administrador);
            return "principal-adm";
        }

    }
        @GetMapping("/delete/{id_adm}")
    private String deletarUsuario(@PathVariable("id_adm") Integer id_adm){
        administradorService.ExcluirAdm(id_adm);
        return "adm";
        }




    }


