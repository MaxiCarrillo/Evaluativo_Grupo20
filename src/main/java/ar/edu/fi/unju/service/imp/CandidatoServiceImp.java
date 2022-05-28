package ar.edu.fi.unju.service.imp;

import java.util.Optional;

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
		for (Candidato candi : listaCandidato.getCandidatos()) {
			if(candi.getCodigo() == candidato.getCodigo()) {
				candi.setNombre(candidato.getNombre());
				candi.setGeneroMusical(candidato.getGeneroMusical());
				candi.setDescripcion(candidato.getDescripcion());
			}
		}
		
		
	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub
		Optional <Candidato> candidato = listaCandidato.getCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		listaCandidato.getCandidatos().remove(candidato.get());
	}

	@Override
	public Candidato buscarCanditato(int codigo) {
		Optional <Candidato> candidato = listaCandidato.getCandidatos().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		return candidato.get();
	}
	
	@Override
	public void obtenerPorcentaje() {
		
		int totalVotos = 0;
		for (Candidato candi : listaCandidato.getCandidatos()) {
			totalVotos = candi.getCantidadVotos()+totalVotos;
		}
		
		listaCandidato.setTotalVotos(totalVotos);
		
		if(totalVotos>0) {
			for (Candidato candi : listaCandidato.getCandidatos()) {
				candi.setPorcentaje((candi.getCantidadVotos()*100)/listaCandidato.getTotalVotos());
			}
		}else {
			for (Candidato candi : listaCandidato.getCandidatos()) {
				candi.setPorcentaje(100);
			}
		}
	}
	
	public boolean existeCandidato(Candidato candidato) {
		boolean resultado=false;
		for (Candidato can : listaCandidato.getCandidatos()) {
			if(can.getCodigo()==candidato.getCodigo()) {
				resultado=true;
			}
		}
		return resultado;
	}
}
