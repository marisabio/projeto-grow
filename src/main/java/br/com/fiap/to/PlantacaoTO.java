package br.com.fiap.to;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlantacaoTO {
	
	@NotNull(message = "O código não pode ser nulo.")
	private int codPlantacao;
	@NotNull(message = "O código não pode ser nulo.")
	private int codUsuario;
	@NotNull(message = "O código não pode ser nulo.")
	private int codAlimento;
	@NotNull(message = "O código não pode ser nulo.")
	private int codHorta;
	@NotNull(message = "A fileira não pode ser nulo.")
	private int fileira;
	@NotNull(message = "A posição não pode ser nula.")
	private int posicao;
	@NotNull(message = "A quantidade não pode ser nula.")
	private int qntdPlantada;
	
	public PlantacaoTO() {
		
	}
	public PlantacaoTO(int codPlantacao, int codUsuario, int codAlimento, int codHorta, int fileira, int posicao, int qntdPlantada) {
		this.codPlantacao = codPlantacao;
		this.codUsuario = codUsuario;
		this.codAlimento = codAlimento;
		this.codHorta = codHorta;
		this.fileira = fileira;
		this.posicao = posicao;
		this.qntdPlantada = qntdPlantada;
	}
	public int getCodPlantacao() {
		return codPlantacao;
	}
	public void setCodPlantacao(int codPlantacao) {
		this.codPlantacao = codPlantacao;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public int getCodAlimento() {
		return codAlimento;
	}
	public void setCodAlimento(int codAlimento) {
		this.codAlimento = codAlimento;
	}
	public int getCodHorta() {
		return codHorta;
	}
	public void setCodHorta(int codHorta) {
		this.codHorta = codHorta;
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
