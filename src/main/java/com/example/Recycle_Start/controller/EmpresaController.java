package com.example.Recycle_Start.controller;

import com.example.Recycle_Start.model.Empresa;
import com.example.Recycle_Start.repositoris.Util;
import com.example.Recycle_Start.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;



    // para o administrador a empresa !!

/*@GetMapping("/empresa")
public String MostraEmpresa(Empresa empresa){
    return "empresa.principal";
}*/

    @GetMapping("/cadastroEmpresa")
    public String cadastroEmpresa(Empresa empresa){
        return "registro-empresa";
    }

    @GetMapping("/login-empresa")
    public String MostraLoginEmpresa(Empresa empresa){
        return "login-empresa";
    }

    @GetMapping("/Empresa")
    public String principalEmpresa(Empresa empresa){
        return "empresa.principal";
    }



    // PARA SALVAR A EMPRESA
    @PostMapping("/salvaEmpresa")
    public String novaEmprea(@ModelAttribute("empresa") Empresa empresa){
empresa.setSenha(Util.md5(empresa.getSenha()));
empresaService.salvarEmpresa(empresa);
return "redirect:/login-empresa";
    }




    // para mostrar empresa ADD
    @GetMapping ("/empresas")
    public String mostraEmpresa(Model model) {
        List<Empresa> empresa = empresaService.mostraEmpresas();
        model.addAttribute("empresa", empresa);
        return "mais-empresa";
    }


    // para deletar empresa
    @GetMapping("/deletar")
    private String deletarEmpresa(@PathVariable("idEmpresa") String cnpj, Model model) {
        empresaService.excluirEmpresa(cnpj);
        return "index";
    }

    @GetMapping ("/editarEmpresa")
    public String editarLoja( String cnpj, Model model) {
        model.addAttribute("empresa", empresaService.empresaCnpj(cnpj));
        return "config-empresa";
    }



}
