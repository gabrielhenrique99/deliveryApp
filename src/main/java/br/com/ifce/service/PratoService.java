package br.com.ifce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifce.model.Prato;
import br.com.ifce.repository.PratoRepository;

import br.com.ifce.util.AulaFileUtils;


@Service
public class PratoService {
	
	@Autowired
	private PratoRepository pratoRepo;
	
	public void cadastrarJogo(Prato prato, MultipartFile imagem) {
		pratoRepo.save(prato);
		
		String caminho = "images/" + prato.getNome() + ".png";
		
		AulaFileUtils.salvarImagem(caminho, imagem);
	}
	
	
	
	public List<Prato> listarPratos(){
		return pratoRepo.findAll();
	}
	
	public void excluirPrato(Long codigo) {
		pratoRepo.deleteById(codigo);
	}
	
	public Optional<Prato> buscarPorId(Long Codigo) {
		return pratoRepo.findById(Codigo);
	}

}
