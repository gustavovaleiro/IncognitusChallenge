package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public abstract class Pessoa {
	
	private String nome;
	private String email;
	private String setor;
	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private LocalDate dataUltimaFerias;
	private boolean ferias;

	private double salarioBase;
	 

	public Pessoa(String nome, String email, String setor, LocalDate dataAdmissao, LocalDate dataDemissao,
			LocalDate dataUltimaFerias, boolean ferias, double salarioBase) {
		super();
		this.nome = nome;
		this.email = email;
		this.setor = setor;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.dataUltimaFerias = dataUltimaFerias;
		this.ferias = ferias;
		this.salarioBase = salarioBase;
	}

	public Pessoa() {}
	
	
	public boolean requisitaFerias(LocalDate dataInicio) {
		//IF dataInicio < dataAdmissao estoura um erro
		
		Period period = Period.between(this.dataAdmissao, dataInicio);
		boolean mesesEntreAdmissaoPedido = period.toTotalMonths() >= 11;
		boolean mesesEntreUltimaFeriasPedido = true;
		
		if(Optional.ofNullable(this.dataUltimaFerias).isPresent()) {
			period  = Period.between(this.dataUltimaFerias, dataInicio);
			mesesEntreUltimaFeriasPedido = period.toTotalMonths() >= 4;
		}
		
		
		if(mesesEntreAdmissaoPedido && mesesEntreUltimaFeriasPedido) {
			this.dataUltimaFerias = dataInicio;
			this.ferias = true;
			return true;
		}
		
		this.ferias = false;
		return false;
	}
	
	public LocalDate getDataUltimaFerias() {
		return dataUltimaFerias;
	}

	public boolean isFerias() {
		return ferias;
	}
	

	

	public String contraCheque() {
		return "Nome: " + this.nome + "; Setor: " + this.setor + "; Salario Base: " + this.salarioBase;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
		

}
