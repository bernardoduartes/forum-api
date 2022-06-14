package br.com.forum.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.TopicoForm;
import br.com.forum.modelo.Topico;
import br.com.forum.repository.CursoRepository;
import br.com.forum.repository.TopicoRepository;

@RestController
@RequestMapping("topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDto> lista() {
		return TopicoDto.converter(topicoRepository.findAll());
	}
	
	@GetMapping("{nomeCurso}")
	public List<TopicoDto> bucarPorNome(@PathVariable final String nomeCurso) {
		return TopicoDto.converter(topicoRepository.findByCursoNome(nomeCurso));
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> criar(
		@RequestBody TopicoForm form, 
		UriComponentsBuilder uriBuilder
	){
		
		Topico topico = form.converter(cursoRepository);
		
		topicoRepository.save(topico);
		
		return ResponseEntity
				.created(uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri())
				.body(new TopicoDto(topico));
	}
}