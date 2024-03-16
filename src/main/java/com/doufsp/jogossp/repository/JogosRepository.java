package com.doufsp.jogossp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doufsp.jogossp.entitie.Jogos_sp;

public interface JogosRepository extends JpaRepository<Jogos_sp, Long> {

	@Query(value = "SELECT * FROM jogos_sp  WHERE vitoria_derrota_empate = ?1", nativeQuery = true)
	List<Jogos_sp> buscaTipoResultado(String tipoResultado);

	@Query(value = "SELECT * FROM jogos_sp  WHERE campeonato = ?1", nativeQuery = true)
	List<Jogos_sp> buscaTipoCampeonato(String tipoCampeonato);
	
	@Query(value = "SELECT * FROM jogos_sp  WHERE casa_fora = ?1", nativeQuery = true)
	List<Jogos_sp> buscaTipoCampo(String tipoCampo);
	
	@Query(value = "SELECT * FROM jogos_sp  WHERE times like %?1%", nativeQuery = true)
	List<Jogos_sp> buscaTipoAdversario(String tipoAdv);

}
