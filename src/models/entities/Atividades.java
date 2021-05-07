package models.entities;

import java.io.Serializable;
import java.sql.Date;

public class Atividades implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String st;
	private String dia_pg;
	private String titular;
	private String descr;
	private Double valor;
	private Boolean boleto;
	private Boolean comprov_pg;
	private Date ano_mes_ref;
	private Date data_ult_atualiz; 

	private Bancos banco;
	
	public Atividades() {
		
	}

	public Atividades(Integer id, String st, String dia_pg, String titular, String descr, Double valor, Boolean boleto,
			Boolean comprov_pg, Date ano_mes_ref, Date data_ult_atualiz) {
		this.id = id;
		this.st = st;
		this.dia_pg = dia_pg;
		this.titular = titular;
		this.descr = descr;
		this.valor = valor;
		this.boleto = boleto;
		this.comprov_pg = comprov_pg;
		this.ano_mes_ref = ano_mes_ref;
		this.data_ult_atualiz = data_ult_atualiz;
	}

	public Atividades(Integer id, String st, String dia_pg, String titular, String descr, Double valor, Boolean boleto,
			Boolean comprov_pg, Date ano_mes_ref, Date data_ult_atualiz,Bancos banco) {
		this.id = id;
		this.st = st;
		this.dia_pg = dia_pg;
		this.titular = titular;
		this.descr = descr;
		this.valor = valor;
		this.boleto = boleto;
		this.comprov_pg = comprov_pg;
		this.ano_mes_ref = ano_mes_ref;
		this.data_ult_atualiz = data_ult_atualiz;
		this.banco = banco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getDia_pg() {
		return dia_pg;
	}

	public void setDia_pg(String dia_pg) {
		this.dia_pg = dia_pg;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getBoleto() {
		return boleto;
	}

	public void setBoleto(Boolean boleto) {
		this.boleto = boleto;
	}

	public Boolean getComprov_pg() {
		return comprov_pg;
	}

	public void setComprov_pg(Boolean comprov_pg) {
		this.comprov_pg = comprov_pg;
	}

	public Date getAno_mes_ref() {
		return ano_mes_ref;
	}

	public void setAno_mes_ref(Date ano_mes_ref) {
		this.ano_mes_ref = ano_mes_ref;
	}

	public Date getData_ult_atualiz() {
		return data_ult_atualiz;
	}

	public void setData_ult_atualiz(Date data_ult_atualiz) {
		this.data_ult_atualiz = data_ult_atualiz;
	}
	

	public Bancos getBanco() {
		return banco;
	}

	public void setBanco(Bancos banco) {
		this.banco = banco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano_mes_ref == null) ? 0 : ano_mes_ref.hashCode());
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((boleto == null) ? 0 : boleto.hashCode());
		result = prime * result + ((comprov_pg == null) ? 0 : comprov_pg.hashCode());
		result = prime * result + ((data_ult_atualiz == null) ? 0 : data_ult_atualiz.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((dia_pg == null) ? 0 : dia_pg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((st == null) ? 0 : st.hashCode());
		result = prime * result + ((titular == null) ? 0 : titular.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividades other = (Atividades) obj;
		if (ano_mes_ref == null) {
			if (other.ano_mes_ref != null)
				return false;
		} else if (!ano_mes_ref.equals(other.ano_mes_ref))
			return false;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
		if (boleto == null) {
			if (other.boleto != null)
				return false;
		} else if (!boleto.equals(other.boleto))
			return false;
		if (comprov_pg == null) {
			if (other.comprov_pg != null)
				return false;
		} else if (!comprov_pg.equals(other.comprov_pg))
			return false;
		if (data_ult_atualiz == null) {
			if (other.data_ult_atualiz != null)
				return false;
		} else if (!data_ult_atualiz.equals(other.data_ult_atualiz))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (dia_pg == null) {
			if (other.dia_pg != null)
				return false;
		} else if (!dia_pg.equals(other.dia_pg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (st == null) {
			if (other.st != null)
				return false;
		} else if (!st.equals(other.st))
			return false;
		if (titular == null) {
			if (other.titular != null)
				return false;
		} else if (!titular.equals(other.titular))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atividades [id=" + id + ", st=" + st + ", dia_pg=" + dia_pg + ", titular=" + titular + ", descr="
				+ descr + ", valor=" + valor + ", boleto=" + boleto + ", comprov_pg=" + comprov_pg + ", ano_mes_ref="
				+ ano_mes_ref + ", data_ult_atualiz=" + data_ult_atualiz + ", banco=" + banco + "]";
	}

}
