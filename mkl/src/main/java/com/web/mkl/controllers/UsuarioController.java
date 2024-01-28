package com.web.mkl.controllers;

import com.web.mkl.models.Credencial;
import com.web.mkl.records.CrearCredencial;
import com.web.mkl.repositoris.CredencialRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private CredencialRepository credencialRepository;
    @PostMapping("/registrarUsuario")
    public void registrarUsuario(@Valid @RequestBody CrearCredencial datos){
        credencialRepository.save(new Credencial(datos));
    }
}
