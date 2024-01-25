package com.doufsp.jogossp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doufsp.jogossp.entitie.JogosEntitie;
import com.doufsp.jogossp.repository.JogosRepository;

import jakarta.transaction.Transactional;

@Service
public class JogosService {

	@Autowired
	private JogosRepository jogosRepository;

	public List<JogosEntitie> listJogos() {
		return jogosRepository.findAll();
	}

	public Optional<JogosEntitie> getJogosId(Long id) {
		return jogosRepository.findById(id);
	}

	public JogosEntitie insertJogos(JogosEntitie jogosEntitie) {
		return jogosRepository.save(jogosEntitie);

	}

	@Transactional
	public JogosEntitie atualizaJogo(Long id, JogosEntitie jogosEntitie) {

		JogosEntitie entity = jogosRepository.getReferenceById(id);
		updateJogo(entity, jogosEntitie);
		return jogosRepository.save(entity);
	}

	public void deletarPartida(Long id) {

		jogosRepository.deleteById(id);
	}

	public void deletarAll() {
		jogosRepository.deleteAll();
	}

	private void updateJogo(JogosEntitie entity, JogosEntitie jogosEntitie) {
		entity.setCampeonato(jogosEntitie.getCampeonato());
		entity.setCasaFora(jogosEntitie.getCasaFora());
		entity.setPlacarAdv(jogosEntitie.getPlacarAdv());
		entity.setPlacarSp(jogosEntitie.getPlacarSp());
		entity.setTimes(jogosEntitie.getTimes());
		entity.setVitoriaDerrotaEmpate(jogosEntitie.getVitoriaDerrotaEmpate());
	}

}
