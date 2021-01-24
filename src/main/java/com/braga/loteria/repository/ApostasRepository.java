package com.braga.loteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.braga.loteria.model.Aposta;

@Repository
public interface ApostasRepository extends JpaRepository<Aposta, Long>{
	
}
