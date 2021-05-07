package models.services;

import java.util.ArrayList;
import java.util.List;

import models.entities.Atividades;

public class AtividadesService {
	
	public List<Atividades> findAll(){

		List<Atividades> list = new ArrayList<>();
		
//		list.add(new Atividades(1,"..","05","Norb","CPFL",345.12,true,false));
//		list.add(new Atividades(2,"pg","06","Thiago","IPTU",545.54,false,true));
		return list;
	}
}
