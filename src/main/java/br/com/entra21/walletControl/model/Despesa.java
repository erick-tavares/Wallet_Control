package br.com.entra21.walletControl.model;

import java.sql.Date;

import br.com.entra21.walletControl.model.util.Status;

public class Despesa {

	private int parcela, idUsuario;
	
	private long id;
	
	private double valorDespesa;

	private String descDespesa, catDespesa, prioridade ;
	
	private Date dtVenc;
	
	private Status status;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getDescDespesa() {
		return descDespesa;
	}

	public void setDescDespesa(String descDespesa) {
		this.descDespesa = descDespesa;
	}

	public String getCatDespesa() {
		return catDespesa;
	}

	public void setCatDespesa(String catDespesa) {
		this.catDespesa = catDespesa;
	}


	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Date getDtVenc() {
		return dtVenc;
	}

	public void setDtVenc(Date dtVenc) {
		this.dtVenc = dtVenc;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catDespesa == null) ? 0 : catDespesa.hashCode());
		result = prime * result + ((descDespesa == null) ? 0 : descDespesa.hashCode());
		result = prime * result + ((dtVenc == null) ? 0 : dtVenc.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + idUsuario;
		result = prime * result + parcela;
		result = prime * result + ((prioridade == null) ? 0 : prioridade.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDespesa);
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
		Despesa other = (Despesa) obj;
		if (catDespesa == null) {
			if (other.catDespesa != null)
				return false;
		} else if (!catDespesa.equals(other.catDespesa))
			return false;
		if (descDespesa == null) {
			if (other.descDespesa != null)
				return false;
		} else if (!descDespesa.equals(other.descDespesa))
			return false;
		if (dtVenc == null) {
			if (other.dtVenc != null)
				return false;
		} else if (!dtVenc.equals(other.dtVenc))
			return false;
		if (id != other.id)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (parcela != other.parcela)
			return false;
		if (prioridade == null) {
			if (other.prioridade != null)
				return false;
		} else if (!prioridade.equals(other.prioridade))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(valorDespesa) != Double.doubleToLongBits(other.valorDespesa))
			return false;
		return true;
	}
	
}
