package models.dao;

import java.util.List;

import models.entities.Bancos;

public interface BancosDao {

	void insert(Bancos obj);
	void update(Bancos obj);
	void deleteById(Integer id);
	Bancos findById(Integer id);
	List<Bancos> findAll();
}
