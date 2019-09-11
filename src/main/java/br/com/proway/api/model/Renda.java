package br.com.proway.api.model;

import java.time.LocalDate;

public class Renda {

	private long ID;

	private String DESCRICAO_RENDA;   

	private double VALOR_RENDA;

	private LocalDate DATA_RENDA = LocalDate.of(0,0,0);; 

	

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
	public double getDATA_RENDA() {
		return VALOR_RENDA;
	}

	public void setDATA_RENDA(LocalDate DATA_RENDA) {
		this.DATA_RENDA = DATA_RENDA;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
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
		if (ID != other.ID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Renda [ID=" + ID + ", DESCRICAO_RENDA=" + DESCRICAO_RENDA + ", VALOR_RENDA=" + VALOR_RENDA + "]";
	}
}
