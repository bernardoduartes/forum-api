package br.com.forum.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.repository.TopicoRepository;

@RestController
@RequestMapping("topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@GetMapping
	public List<TopicoDto> lista() {
		return TopicoDto.converter(topicoRepository.findAll());
	}
	
	@GetMapping("{nomeCurso}")
	public List<TopicoDto> bucarPorNome(@PathVariable final String nomeCurso) {
		return TopicoDto.converter(topicoRepository.findByCursoNome(nomeCurso));
	}
}