package org.example.municipalcomplaintssystem.controllers.publico;

import org.example.municipalcomplaintssystem.controllers.response.ErrorResponse;
import org.example.municipalcomplaintssystem.controllers.response.LoginResponse;
import org.example.municipalcomplaintssystem.db.entities.Login;
import org.example.municipalcomplaintssystem.db.entities.Usuario;
import org.example.municipalcomplaintssystem.security.JwtProvider;
import org.example.municipalcomplaintssystem.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UsuarioService service;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Object> login(@RequestBody Login body) {
        try {
            Usuario usuario = service.buscarPorEmail(body.getEmail());
            if (usuario == null) {
                return ResponseEntity.badRequest().body(new ErrorResponse("Usuário não encontrado"));
            }
            if (!usuario.getSenha().trim().equals(body.getSenha())) {
                return ResponseEntity.badRequest().body(new ErrorResponse("Senha incorreta"));
            }
            String token = JwtProvider.getToken(String.valueOf(usuario.getNivel()), String.valueOf(usuario.getId()));
            LoginResponse response = new LoginResponse(usuario.getNivel(), token);
            return ResponseEntity.ok().body(response.toJSON());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Erro ao fazer login");
        }

    }
}
