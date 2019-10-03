package br.com.entra21.walletControl.model;

import java.sql.Date;

public class Renda {

	private long id;

	private String descricaoRenda;   

	private double valorRenda;

	private Date dataRenda; 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricaoRenda() {
		return descricaoRenda;
	}

	public void setDescricaoRenda(String descricaoRenda) {
		this.descricaoRenda = descricaoRenda;
	}

	public double getValorRenda() {
		return valorRenda;
	}

	public void setValorRenda(double valorRenda) {
		this.valorRenda = valorRenda;
	}

	public Date getDataRenda() {
		return dataRenda;
	}

	public void setDataRenda(Date dataRenda) {
		this.dataRenda = dataRenda;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRenda == null) ? 0 : dataRenda.hashCode());
		result = prime * result + ((descricaoRenda == null) ? 0 : descricaoRenda.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(valorRenda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Renda other = (Renda) obj;
		if (dataRenda == null) {
			if (other.dataRenda != null)
				return false;
		} else if (!dataRenda.equals(other.dataRenda))
			return false;
		if (descricaoRenda == null) {
			if (other.descricaoRenda != null)
				return false;
		} else if (!descricaoRenda.equals(other.descricaoRenda))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(valorRenda) != Double.doubleToLongBits(other.valorRenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Renda [id=" + id + ", descricaoRenda=" + descricaoRenda + ", valorRenda=" + valorRenda + ", dataRenda="
				+ dataRenda + "]";
	}





}
