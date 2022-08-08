package com.example.Recycle_Start.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
// obs não tenm tabela
@Getter @Setter
@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_agendamento;

    @Column(nullable = false, name = "nome_usuario")
    private String nome;

    @Column (nullable = false, name = "cpf_usuario")
    private String cpf;

    @Column (nullable = false , name = "quantidade_de_apartamaneto_do_usuario ")
    private int apartamento;

    @Column(nullable = false, name = "frequencia")
    private String frequecia;

    @Column(nullable = false , name = "horaDoAgendamento")
    private String horaDoAgendamento;

    @Column(nullable = false , name = "diaDoAgendamento")
    private String  diaDoAgendamento;


    @Column (nullable = false, name =  "estado_Usuario")
    @NotBlank(message = " O Campo não pode esta vazio ")
    private String estado;

    @Column (nullable = false, name =  "cidade_Usuario")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String cidade;

    @Column (nullable = false, name =  "bairro_Usuario")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String bairro;

    @Column (nullable = false, name =  "rua_Usuario")
    @NotBlank (message = " O Campo não pode esta vazio ")
    private String rua;

    @Column (nullable = false, name =  "numero_Usuario")
    @NotBlank (message = "o  campo não pode esta  vazio")
    private String numero;

    @Column (nullable = false, name =  "cep_Usuario")
    @NotBlank (message = "o  campo não pode esta  vazio")
    private String cep;




}
