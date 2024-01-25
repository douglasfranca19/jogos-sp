package com.doufsp.jogossp.entitie;

import java.io.Serializable;
import java.util.Objects;

public class Jogos implements Serializable {

	private static final long serialVersionUID = 1L;

	private String times;
	private Integer placarSp;
	private Integer placarAdv;
	private String casaFora;
	private String campeonato;

	public Jogos() {

	}

	public Jogos(String times, Integer placarSp, Integer placarAdv, String casaFora, String campeonato) {
		super();
		this.times = times;
		this.placarSp = placarSp;
		this.placarAdv = placarAdv;
		this.casaFora = casaFora;
		this.campeonato = campeonato;
	}

	public String getTimes() {
		return times;
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

	@Override
	public int hashCode() {
		return Objects.hash(campeonato, casaFora, placarAdv, placarSp, times);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogos other = (Jogos) obj;
		return Objects.equals(campeonato, other.campeonato) && Objects.equals(casaFora, other.casaFora)
				&& Objects.equals(placarAdv, other.placarAdv) && Objects.equals(placarSp, other.placarSp)
				&& Objects.equals(times, other.times);
	}

}
