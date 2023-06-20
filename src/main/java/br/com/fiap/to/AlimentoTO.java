package br.com.fiap.to;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlimentoTO {
	
	@NotNull(message = "O código não pode ser nulo.")
	private int codAlimento;
	@NotNull(message = "O nome não pode ser nulo.")
	private String nomeAlimento;
	@NotNull(message = "O tipo não pode ser nulo.")
	private String tipoAlimento;
	@NotNull(message = "A quantidade não pode ser nula.")
	private int qntdSementeAlimento;
	
	public AlimentoTO() {
		
	}
	public AlimentoTO(int codAlimento, String nomeAlimento, String tipoAlimento, int qntdSementeAlimento) {
    	super();
    	this.codAlimento = codAlimento;
    	this.nomeAlimento = nomeAlimento;
    	this.tipoAlimento = tipoAlimento;
    	this.qntdSementeAlimento = qntdSementeAlimento;
    }
	public int getCodAlimento() {
		return codAlimento;
	}
	public void setCodAlimento(int codAlimento) {
		this.codAlimento = codAlimento;
	}
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
	public String getTipoAlimento() {
		return tipoAlimento;
	}
	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	public int getQntdSementeAlimento() {
		return qntdSementeAlimento;
	}
	public void setQntdSementeAlimento(int qntdSementeAlimento) {
		this.qntdSementeAlimento = qntdSementeAlimento;
	}
	
	

}
