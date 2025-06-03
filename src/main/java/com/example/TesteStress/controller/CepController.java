package com.example.TesteStress.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{cep}")
    public ResponseEntity<String> buscarCep(@PathVariable String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao consultar CEP");
        }
    }
}
