package br.com.fiap.to;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HortaTO {
	
	@NotNull(message = "O código não pode ser nulo.")
	private int codHorta;
	@NotNull(message = "O nome não pode ser nulo.")
	private String nomeHorta;
	@NotNull(message = "A capacidade não pode ser nula.")
	private int capacidadePlantio;
	
	public HortaTO() {
		
	}
	public HortaTO(int codHorta, String nomeHorta, int capacidadePlantio) {
    	super();
    	this.codHorta = codHorta;
    	this.nomeHorta = nomeHorta;
    	this.capacidadePlantio = capacidadePlantio;
    }
	public int getCodHorta() {
		return codHorta;
	}
	public void setCodHorta(int codHorta) {
		this.codHorta = codHorta;
	}
	public String getNomeHorta() {
		return nomeHorta;
	}
	public void setNomeHorta(String nomeHorta) {
		this.nomeHorta = nomeHorta;
	}
	public int getCapacidadePlantio() {
		return capacidadePlantio;
	}
	public void setCapacidadePlantio(int capacidadePlantio) {
		this.capacidadePlantio = capacidadePlantio;
	}
	
}
