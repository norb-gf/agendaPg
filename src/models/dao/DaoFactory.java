package models.dao;

import db.DB;
import models.dao.impl.BancosDaoJDBC;

public class DaoFactory {

	/*
	 * public static SellerDao createSellerDao() { return new
	 * SellerDaoJDBC(DB.getConnection()); }
	 */	
	public static BancosDao createBancosDao() {
		return new BancosDaoJDBC(DB.getConnection());
	}
}
