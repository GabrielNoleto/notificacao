package com.NoletoTech.notificacao.controller;

import com.NoletoTech.notificacao.business.EmailService;
import com.NoletoTech.notificacao.business.dto.TarefasDTO;
import jakarta.websocket.server.ServerEndpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping public ResponseEntity<Void> enviarEmail(@RequestBody TarefasDTO dto){
        emailService.enviaEmail(dto);
        return ResponseEntity.ok().build();

    }
}
