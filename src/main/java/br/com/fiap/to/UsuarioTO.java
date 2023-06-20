package br.com.fiap.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioTO {
	
	@NotNull(message = "O código não pode ser nulo.")
	private int codUsuario;
	@NotNull(message = "O nome não pode ser nulo.")
	private String nome;
	@NotNull(message = "A senha não pode ser nula.")
	private String senha;
	@Email(message = "O e-mail deve ser válido.")
	private String email;
	@NotNull(message = "O endereço não pode ser nulo.")
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	
	public UsuarioTO() {
    	
    }
	public UsuarioTO(int codUsuario, String nome, String senha, String email, String cep) {
    	super();
    	this.codUsuario = codUsuario;
    	this.nome = nome;
    	this.senha = senha;
    	this.email = email;
    	this.cep = cep;
	}
    public UsuarioTO(int codUsuario, String nome, String senha, String email, String cep, String rua, String bairro, String cidade,String uf ) {
    	super();
    	this.codUsuario = codUsuario;
    	this.nome = nome;
    	this.senha = senha;
    	this.email = email;
    	this.cep = cep;
    	this.rua = rua;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.uf = uf;	
    }
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

}


	