package com.doufsp.jogossp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doufsp.jogossp.entitie.Jogos_sp;
import com.doufsp.jogossp.exceptions.IdNotFound;
import com.doufsp.jogossp.repository.JogosRepository;

import jakarta.transaction.Transactional;

@Service
public class JogosService {

	@Autowired
	private JogosRepository jogosRepository;

	public List<Jogos_sp> listJogos() {
		return jogosRepository.findAll();
	}

	public Optional<Jogos_sp> getJogosId(Long id) {

		Optional<Jogos_sp> jogosId = jogosRepository.findById(id);

		if (jogosId.isEmpty()) {
			throw new IdNotFound("Id " + id + " não encontrado na base de dados");
		}

		return jogosId;

	}

	public Jogos_sp insertJogos(Jogos_sp jogosEntitie) {
		return jogosRepository.save(jogosEntitie);

	}

	@Transactional
	public Jogos_sp atualizaJogo(Long id, Jogos_sp jogosEntitie) {

		Jogos_sp entity = jogosRepository.getReferenceById(id);
		updateJogo(entity, jogosEntitie);
		return jogosRepository.save(entity);
	}

	public void deletarPartida(Long id) {

		if (!jogosRepository.existsById(id)) {
			throw new IdNotFound("Id " + id + " não encontrado na base de dados");
		}

		jogosRepository.deleteById(id);

	}

	public void deletarAll() {
		jogosRepository.deleteAll();
	}

	private void updateJogo(Jogos_sp entity, Jogos_sp jogosEntitie) {
		entity.setCampeonato(jogosEntitie.getCampeonato());
		entity.setCasaFora(jogosEntitie.getCasaFora());
		entity.setPlacarAdv(jogosEntitie.getPlacarAdv());
		entity.setPlacarSp(jogosEntitie.getPlacarSp());
		entity.setTimes(jogosEntitie.getTimes());
		entity.setVitoriaDerrotaEmpate(jogosEntitie.getVitoriaDerrotaEmpate());
	}

	public List<Jogos_sp> buscaTipoResultado(String tipoResultado) {

		List<Jogos_sp> buscaResult = jogosRepository.buscaTipoResultado(tipoResultado);

		if (buscaResult.isEmpty()) {
			throw new IdNotFound("Dados não encontrados na base de dados");
		}

		return buscaResult;
	}

	public List<Jogos_sp> buscaTipoCampeonato(String tipoCampeonato) {

		List<Jogos_sp> buscaCamp = jogosRepository.buscaTipoCampeonato(tipoCampeonato);

		if (buscaCamp.isEmpty()) {
			throw new IdNotFound("Dados não encontrados na base de dados");
		}

		return buscaCamp;
	}

	public List<Jogos_sp> buscaTipoCampo(String tipoCampo) {

		List<Jogos_sp> buscaCamp = jogosRepository.buscaTipoCampo(tipoCampo);

		if (buscaCamp.isEmpty()) {
			throw new IdNotFound("Dados não encontrados na base de dados");
		}

		return buscaCamp;
	}

	public List<Jogos_sp> buscaTipoAdversario(String tipoAdv) {

		List<Jogos_sp> buscaCamp = jogosRepository.buscaTipoAdversario(tipoAdv);

		if (buscaCamp.isEmpty()) {
			throw new IdNotFound("Dados não encontrados na base de dados");
		}

		return buscaCamp;
	}

}
