package br.com.forum.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AutenticacaoControllerTest {

	// @WebMvcTest não inicializa as classes de autenticação. Para injetar o mockmvc então usa-se o @AutoConfigureMockMvc
	
	@Autowired
	private MockMvc mockPostman;
	
	/*
	@Autowired
	private TestEntityManager em;
	
	@Test
	void devolver400CasoDadosAutenticacaoIncorretos() throws Exception {
		URI uri = new URI("auth");
		
		Usuario usuario = new Usuario();
		usuario.setNome("Bernardo");
		usuario.setEmail("aluno@email.com");
		usuario.setSenha("$2a$10$sWBvvEKgu3IocES3tU4q2OtuWTdLW8ybOtT1Ow7prWbvn5MPThDde");
		em.persist(usuario);
		
		String json = "{\"email\":\"aluno@email.com\", \"senha\":\"123456}\"";
		
		mockPostman.perform(
			MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	*/
	
	@Test
	public void devolver400CasoDadosAutenticacaoIncorretos() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
		
		mockPostman.perform(
				MockMvcRequestBuilders
					.post(uri)
					.content(json)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
