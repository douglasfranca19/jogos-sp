package com.doufsp.jogossp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doufsp.jogossp.entitie.JogosEntitie;

public interface JogosRepository extends JpaRepository<JogosEntitie, Long> {

}
