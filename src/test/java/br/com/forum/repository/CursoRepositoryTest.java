package br.com.forum.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.forum.modelo.Curso;

@DataJpaTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CursoRepositoryTest {

	@Autowired
	private CursoRepository epository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	void deveCarregarCursoAoBuscarPorNome() {
		final String nomeCurso = "HTML 5";
		
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		em.persist(html5);
		
		Curso curso = epository.findByNome(nomeCurso);
		
		Assert.assertNotNull(curso);
		Assert.assertEquals(curso.getNome(), nomeCurso);
	}

	@Test
	void naoDeveCarregarCursoNaoCadastrado() {
		final String nomeCurso = "COMO SE TORNAR UM JEDI";
		
		Curso curso = epository.findByNome(nomeCurso);
		
		Assert.assertNull(curso);
	}
}
