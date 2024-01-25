package com.doufsp.jogossp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doufsp.jogossp.entitie.Jogos;

@RestController
@RequestMapping(value = "/jogossp")
public class JogosResource {

	@GetMapping(value = "/todos")
	public ResponseEntity<Jogos> getJogos() {
		Jogos jogosSp = new Jogos("São Paulo x Mirassol", 1, 1, "Fora", "Campeonato Paulista");
		return ResponseEntity.ok().body(jogosSp);
		
	
	}
}
