package models.entities;

import java.io.Serializable;

public class Atividades implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String st;
	private String diaPg;
	private String titular;
	private String descr;
	private Double valor;
	private Boolean boleto;
	private Boolean comprovPg;
	
	public Atividades(Integer id, String st, String diaPg, String titular, String descr, Double valor, Boolean boleto,
			Boolean comprovPg) {
		super();
		this.id = id;
		this.st = st;
		this.diaPg = diaPg;
		this.titular = titular;
		this.descr = descr;
		this.valor = valor;
		this.boleto = boleto;
		this.comprovPg = comprovPg;
	}

	public Atividades(String st, String diaPg, String titular, String descr, Double valor, Boolean boleto,
			Boolean comprovPg) {
		super();
		this.st = st;
		this.diaPg = diaPg;
		this.titular = titular;
		this.descr = descr;
		this.valor = valor;
		this.boleto = boleto;
		this.comprovPg = comprovPg;
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

	public String getDiaPg() {
		return diaPg;
	}

	public void setDiaPg(String diaPg) {
		this.diaPg = diaPg;
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

	public Boolean getComprovPg() {
		return comprovPg;
	}

	public void setComprovPg(Boolean comprovPg) {
		this.comprovPg = comprovPg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comprovPg == null) ? 0 : comprovPg.hashCode());
		result = prime * result + ((boleto == null) ? 0 : boleto.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((diaPg == null) ? 0 : diaPg.hashCode());
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
		if (comprovPg == null) {
			if (other.comprovPg != null)
				return false;
		} else if (!comprovPg.equals(other.comprovPg))
			return false;
		if (boleto == null) {
			if (other.boleto != null)
				return false;
		} else if (!boleto.equals(other.boleto))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (diaPg == null) {
			if (other.diaPg != null)
				return false;
		} else if (!diaPg.equals(other.diaPg))
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
		return "Atividades [id=" + id + ", st=" + st + ", diaPg=" + diaPg + ", titular=" + titular + ", descr=" + descr
				+ ", valor=" + valor + ", boleto=" + boleto + ", comprovPg=" + comprovPg + "]";
	}
	
	
	
}
