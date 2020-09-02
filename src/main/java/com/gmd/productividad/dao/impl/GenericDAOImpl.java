package com.gmd.productividad.dao.impl;

import java.util.List;

import com.gmd.productividad.dao.GenericDAO;
import com.gmd.productividad.dao.mappers.GenericMapper;
import com.gmd.productividad.domain.Identifiable;

abstract class GenericDAOImpl<T extends Identifiable, M extends GenericMapper<T>> implements GenericDAO<T, Long> {

	protected abstract M getMapper();

	@Override
	public Long create(T object) {
		getMapper().insert(object);
		return object.getId();
	}

	@Override
	public T read(Long id) {
		return getMapper().selectById(id);
	}

	@Override
	public void update(T object) {
		getMapper().update(object);
	}

	@Override
	public void delete(Long key) {
		getMapper().delete(key);
	}

	public List<T> readAll() {
		return getMapper().selectAll();
	}

}
