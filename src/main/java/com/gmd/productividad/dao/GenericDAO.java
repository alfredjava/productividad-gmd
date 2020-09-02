package com.gmd.productividad.dao;

import java.io.Serializable;
import java.util.List;

import com.gmd.productividad.domain.Identifiable;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GenericDAO<T extends Identifiable, PK extends Serializable> {

	@Transactional
	PK create(T object);

	T read(PK id);

	@Transactional
	void update(T object);

	@Transactional
	void delete(PK key);

	List<T> readAll();
}
