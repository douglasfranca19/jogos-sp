package com.doufsp.jogossp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doufsp.jogossp.dto.JogosDto;
import com.doufsp.jogossp.entitie.JogosEntitie;
import com.doufsp.jogossp.service.JogosService;

@RestController
@RequestMapping(value = "/jogossp")
public class JogosController {

	@Autowired
	private JogosService jogosService;

	@GetMapping(value = "/todos")
	public List<JogosEntitie> getJogos() {
		return jogosService.listJogos();

	}
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Optional<JogosEntitie>> getJogosId(@PathVariable Long id) {
		return ResponseEntity.ok().body(jogosService.getJogosId(id));

	}

	@PostMapping(value = "/insere")
	public JogosEntitie setJogos(@RequestBody JogosDto jogosDto) {

		JogosEntitie jogosEntitie = new JogosEntitie();

		jogosEntitie.setTimes(jogosDto.getTimes());
		jogosEntitie.setCampeonato(jogosDto.getCampeonato());
		jogosEntitie.setCasaFora(jogosDto.getCasaFora());
		jogosEntitie.setPlacarAdv(jogosDto.getPlacarAdv());
		jogosEntitie.setPlacarSp(jogosDto.getPlacarSp());
		jogosEntitie.setVitoriaDerrotaEmpate(jogosDto.getVitoriaDerrotaEmpate());

		return jogosService.insertJogos(jogosEntitie);

	}

	@DeleteMapping(value = "/deletar/{id}")
	public void deletarPartida(@PathVariable Long id) {
		jogosService.deletarPartida(id);
	}

	@DeleteMapping(value = "/deletar/all")
	public void deletarAll() {
		jogosService.deletarAll();
	}

}
