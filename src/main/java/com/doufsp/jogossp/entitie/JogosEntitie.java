package com.doufsp.jogossp.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogos_sp")
public class JogosEntitie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "times", nullable = false, length = 500)
	private String times;
	
	@Column(name = "placar_sp", nullable = false, length = 500)
	private Integer placarSp;
	
	@Column(name = "placar_adversa", nullable = false, length = 500)
	private Integer placarAdv;
	
	@Column(name = "casa_fora", nullable = false, length = 500)
	private String casaFora;
	
	@Column(name = "campeonato", nullable = false, length = 500)
	private String campeonato;
	
	@Column(name = "vitoria_derrota_empate", nullable = false, length = 500)
	private String vitoriaDerrotaEmpate;

	public JogosEntitie() {
	}

	public String getTimes() {
		return times;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Integer getPlacarSp() {
		return placarSp;
	}

	public void setPlacarSp(Integer placarSp) {
		this.placarSp = placarSp;
	}

	public Integer getPlacarAdv() {
		return placarAdv;
	}

	public void setPlacarAdv(Integer placarAdv) {
		this.placarAdv = placarAdv;
	}

	public String getCasaFora() {
		return casaFora;
	}

	public void setCasaFora(String casaFora) {
		this.casaFora = casaFora;
	}

	public String getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}

	public String getVitoriaDerrotaEmpate() {
		return vitoriaDerrotaEmpate;
	}

	public void setVitoriaDerrotaEmpate(String vitoriaDerrotaEmpate) {
		this.vitoriaDerrotaEmpate = vitoriaDerrotaEmpate;
	}

}
