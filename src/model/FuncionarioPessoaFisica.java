package model;

import java.time.LocalDate;

public class FuncionarioPessoaFisica extends Pessoa{
		
	private String cpf;
	private String nit;
	private CargoEnum cargo;
	private double bonificacao;


	
	public FuncionarioPessoaFisica(String nome, String email, String setor, LocalDate dataAdmissao,
			LocalDate dataDemissao, LocalDate dataUltimaFerias, boolean ferias, double salarioBase, String cpf,
			String nit, CargoEnum cargo) {
		super(nome, email, setor, dataAdmissao, dataDemissao, dataUltimaFerias, ferias, salarioBase);
		this.cpf = cpf;
		this.nit = nit;
		this.cargo = cargo;
		calculaBonificacao();
	}



	public FuncionarioPessoaFisica() {
		
	}
	@Override
	public String contraCheque() {
		return "Nome: " + this.getNome() + "; Setor: " + this.getSetor() 
							+ "; Salario Base: " + this.getSalarioBase() + "; Bonificação: " + this.bonificacao 
							+ "; Salario Total: " +this.getSalarioTotal();
	}
	
	public double getSalarioTotal() {
		return this.getSalarioBase() + this.bonificacao;
	}
	@Override
	public void setSalarioBase(double salarioBase) {
		super.setSalarioBase(salarioBase);
		this.calculaBonificacao();
	}
	
	public CargoEnum getCargo() {
		return cargo;
	}


	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
		this.calculaBonificacao();
	}

	

	public double getBonificacao() {
		return bonificacao;
	}


	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	

	private void calculaBonificacao() {
		this.bonificacao = (this.cargo.getPorcentagemBonificao()/100)*this.getSalarioBase();
	}
	
	
	
	
	
}
