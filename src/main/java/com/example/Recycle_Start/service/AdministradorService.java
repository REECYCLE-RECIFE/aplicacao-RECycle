package com.example.Recycle_Start.service;

import com.example.Recycle_Start.repositoris.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
}
