package com.gmd.productividad.dao.mappers;

import java.util.List;

import com.gmd.productividad.domain.Identifiable;

public interface GenericMapper<T extends Identifiable> {

	List<T> selectAll();

	T selectById(Long id);

	void update(T place);

	void delete(Long id);

	void insert(T place);
}
