package ar.edu.fi.unju.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.fi.unju.lista.ListaCandidato;
import ar.edu.fi.unju.model.Candidato;
import ar.edu.fi.unju.service.ICandidatoService;

@Service("CandidatoServiceImpList")
public class CandidatoServiceImp implements ICandidatoService {
	
	@Autowired
	private ListaCandidato listaCandidato;

	@Override
	public Candidato getCandidato() {
		return new Candidato();
	}

	@Override
	public ListaCandidato getListaCandidato() {
		return listaCandidato;
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		return listaCandidato.getCandidatos().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Candidato buscarCanditato(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
