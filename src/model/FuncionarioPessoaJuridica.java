package model;

import java.time.LocalDate;

public class FuncionarioPessoaJuridica extends Pessoa{

	private String cnpj;



	public FuncionarioPessoaJuridica(String nome, String email, String setor, LocalDate dataAdmissao,
			LocalDate dataDemissao, LocalDate dataUltimaFerias, boolean ferias, double salarioBase, String cnpj) {
		super(nome, email, setor, dataAdmissao, dataDemissao, dataUltimaFerias, ferias, salarioBase);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
