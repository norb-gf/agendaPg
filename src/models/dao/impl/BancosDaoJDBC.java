package models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import models.dao.BancosDao;
import models.entities.Bancos;

public class BancosDaoJDBC implements BancosDao {

	private Connection conn;
	
	public BancosDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Bancos findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tb_bancos WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Bancos obj = new Bancos();
				obj.setId(rs.getInt("id"));
				obj.setTipo(rs.getString("tipo"));
				obj.setCod(rs.getString("cod"));
				obj.setNome(rs.getString("nome"));
				obj.setAg(rs.getString("ag"));
				obj.setTitular(rs.getString("titular"));
				obj.setStatus(rs.getString("status"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Bancos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM tb_bancos ORDER BY cod");
			rs = st.executeQuery();

			List<Bancos> list = new ArrayList<>();

			while (rs.next()) {
				Bancos obj = new Bancos();
				obj.setId(rs.getInt("id"));
				obj.setTipo(rs.getString("tipo"));
				obj.setCod(rs.getString("cod"));
				obj.setNome(rs.getString("nome"));
				obj.setAg(rs.getString("ag"));
				obj.setTitular(rs.getString("titular"));
				obj.setStatus(rs.getString("status"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Bancos obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO tb_bancos " +
				"(Tipo, Cod, Nome, Ag, Titular, Status) " +
				"VALUES " +
				"(?,?,?,?,?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getTipo());
			st.setString(2, obj.getCod());
			st.setString(3, obj.getNome());
			st.setString(4, obj.getAg());
			st.setString(5, obj.getTitular());
			st.setString(6, obj.getStatus());			
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Bancos obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE tb_bancos " +
				"SET (Tipo, Cod, Nome, Ag, Titular, Status) " +
				"VALUES (?,?,?,?,?,?)" +		
				"WHERE Id = ?");

			st.setString(1, obj.getTipo());
			st.setString(2, obj.getCod());
			st.setString(3, obj.getNome());
			st.setString(4, obj.getAg());
			st.setString(5, obj.getTitular());
			st.setString(6, obj.getStatus());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM tb_bancos WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
}
