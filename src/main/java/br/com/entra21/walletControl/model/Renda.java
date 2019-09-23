package br.com.entra21.walletControl.model;

import java.sql.Date;


public class Renda {

	private long ID;

	private String DESCRICAO_RENDA;   

	private double VALOR_RENDA;

	private Date DATA_RENDA; 

	

	public long getId() {
		return ID;
	}

	public void setId(long ID) {
		this.ID = ID;
	}

	public String getDESCRICAO_RENDA() {
		return DESCRICAO_RENDA;
	}

	public void setDESCRICAO_RENDA(String DESCRICAO_RENDA) {
		this.DESCRICAO_RENDA = DESCRICAO_RENDA;
	}

	public double getVALOR_RENDA() {
		return VALOR_RENDA;
	}

	public void setVALOR_RENDA(double VALOR_RENDA) {
		this.VALOR_RENDA = VALOR_RENDA;
	}


	public Date getDATA_RENDA() {
		return DATA_RENDA;
	}

	public void setDATA_RENDA(Date date) {
		DATA_RENDA = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DATA_RENDA == null) ? 0 : DATA_RENDA.hashCode());
		result = prime * result + ((DESCRICAO_RENDA == null) ? 0 : DESCRICAO_RENDA.hashCode());
		result = prime * result + (int) (ID ^ (ID >>> 32));
		long temp;
		temp = Double.doubleToLongBits(VALOR_RENDA);
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
		if (DATA_RENDA == null) {
			if (other.DATA_RENDA != null)
				return false;
		} else if (!DATA_RENDA.equals(other.DATA_RENDA))
			return false;
		if (DESCRICAO_RENDA == null) {
			if (other.DESCRICAO_RENDA != null)
				return false;
		} else if (!DESCRICAO_RENDA.equals(other.DESCRICAO_RENDA))
			return false;
		if (ID != other.ID)
			return false;
		if (Double.doubleToLongBits(VALOR_RENDA) != Double.doubleToLongBits(other.VALOR_RENDA))
			return false;
		return true;
	}


}
