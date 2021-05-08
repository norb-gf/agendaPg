package models.services;

import java.util.List;

import models.dao.BancosDao;
import models.dao.DaoFactory;
import models.entities.Bancos;

public class BancosService {

	private BancosDao dao = DaoFactory.createBancosDao();
	
	public List<Bancos> findAll(){
		return dao.findAll();
	}

	public void saveOrUpdate(Bancos obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}


}
