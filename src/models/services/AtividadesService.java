package models.services;

import java.util.ArrayList;
import java.util.List;

import models.entities.Atividades;

public class AtividadesService {
	
	public List<Atividades> findAll(){

		List<Atividades> list = new ArrayList<>();
		
		list.add(new Atividades(1,"..","05","Norb","CPFL",345.12,true,false));
		list.add(new Atividades(2,"pg","05","Thiago","CPFL",545.54,true,false));
		list.add(new Atividades(3,"db","05","Mada","AnaCosta",125.87,true,false));
		list.add(new Atividades(4,"ag","10","Thiago","IPTU",988.54,false,false));
		list.add(new Atividades(5,"na","01","Norb","Unimed",478.52,false,true));
		list.add(new Atividades(6,"pg","20","Norb","Condominio",777.66,true,true));
		list.add(new Atividades(7,"db","25","Thiago","OAB",555.44,true,true));
		list.add(new Atividades(8,"ag","02","Norb","Claro",444.33,true,false));		
		return list;
	}
}
