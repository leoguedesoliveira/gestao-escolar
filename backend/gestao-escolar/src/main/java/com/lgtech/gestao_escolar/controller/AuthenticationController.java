package com.lgtech.gestao_escolar.controller;

import com.lgtech.gestao_escolar.dto.UsuarioDTO.AuthenticationDTO;
import com.lgtech.gestao_escolar.dto.UsuarioDTO.LoginResponseDTO;
import com.lgtech.gestao_escolar.entity.Usuario;
import com.lgtech.gestao_escolar.exceptions.LoginInvalidoExcepition;
import com.lgtech.gestao_escolar.infra.Security.TokenService;
import com.lgtech.gestao_escolar.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usuarioSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = authenticationManager.authenticate(usuarioSenha);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        if(auth.isAuthenticated()) {
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } else {
            throw new LoginInvalidoExcepition();
        }
    }

    /*public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if(this.usuarioRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario newUsuario = new Usuario(data.nome(), data.email(), data.senha(), data.escola(), data.unidade(), data.role());
    }*/

}
