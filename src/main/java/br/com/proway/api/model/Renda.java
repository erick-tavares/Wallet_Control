package br.com.proway.api.model;

public class Renda {

	private long ID;

	private String DESCRICAO_RENDA;   

	private String VALOR_RENDA; 

	

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

	public String getVALOR_RENDA() {
		return VALOR_RENDA;
	}

	public void setVALOR_RENDA(String VALOR_RENDA) {
		this.VALOR_RENDA = VALOR_RENDA;
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
