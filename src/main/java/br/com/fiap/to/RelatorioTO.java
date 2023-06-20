package br.com.fiap.to;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RelatorioTO {
	
	@NotNull(message = "O código não pode ser nulo.")
	private String nome;
	@NotNull(message = "O código não pode ser nulo.")
	private String nomeHorta;
	@NotNull(message = "O código não pode ser nulo.")
	private String nomeAlimento;
	@NotNull(message = "A fileira não pode ser nulo.")
	private int fileira;
	@NotNull(message = "A posição não pode ser nula.")
	private int posicao;
	@NotNull(message = "A quantidade não pode ser nula.")
	private int qntdPlantada;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeHorta() {
		return nomeHorta;
	}
	public void setNomeHorta(String nomeHorta) {
		this.nomeHorta = nomeHorta;
	}
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
	public int getFileira() {
		return fileira;
	}
	public void setFileira(int fileira) {
		this.fileira = fileira;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getQntdPlantada() {
		return qntdPlantada;
	}
	public void setQntdPlantada(int qntdPlantada) {
		this.qntdPlantada = qntdPlantada;
	}

}
