package model;

public enum CargoEnum {
	COMUM(0),
	SUPERVISOR(8),
	GERENTE(12);
	
	
	private CargoEnum(double porcentagemBonificao) {
		this.porcentagemBonificao = porcentagemBonificao;
	}
	
	private double porcentagemBonificao;

	public double getPorcentagemBonificao() {
		return porcentagemBonificao;
	}
}
