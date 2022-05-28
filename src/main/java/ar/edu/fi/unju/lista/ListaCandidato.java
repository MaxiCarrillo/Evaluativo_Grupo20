package ar.edu.fi.unju.lista;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.fi.unju.model.Candidato;

@Component
public class ListaCandidato {

	private ArrayList<Candidato> candidatos;
	private int totalVotos;
	
	public ListaCandidato() {
		// TODO Auto-generated constructor stub
		candidatos = new ArrayList<Candidato>();
		candidatos.add(new Candidato(0, "Ninguno", "Ninguno", "Ninguno", 0, 0));
		totalVotos = 0;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public int getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
	}
}
