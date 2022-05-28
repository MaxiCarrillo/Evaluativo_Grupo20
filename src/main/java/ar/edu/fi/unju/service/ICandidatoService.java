package ar.edu.fi.unju.service;

import ar.edu.fi.unju.lista.ListaCandidato;
import ar.edu.fi.unju.model.Candidato;

public interface ICandidatoService {

	public Candidato getCandidato();
	public ListaCandidato getListaCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public Candidato buscarCanditato(int codigo);
	
}
