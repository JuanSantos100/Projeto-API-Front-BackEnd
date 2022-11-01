package br.com.criandoapi.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.DAO.IUsuario;
import br.com.criandoapi.projeto.model.Usuario;

@RequestMapping("/usuarios")
@CrossOrigin("*") /*
	Desbloqueio de portas usando localhost, pode ter problemas ao mandar 
	requisições de uma porta para outra
*/
@RestController
public class UsuarioController {
	
	@Autowired //Faz uma injeção automática dos métodos não implementados da Interface (ao invés de fazer UsuarioController implements IUsuario)
	private IUsuario dao;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios () { //Usando ResponseEntity
		List<Usuario> lista = (List<Usuario>) dao.findAll();
		return ResponseEntity.status(200).body(lista);
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return ResponseEntity.status(201).body(usuarioNovo);
	}

	@PutMapping
	public ResponseEntity<Usuario> atualizarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioAlterado = dao.save(usuario);
		return ResponseEntity.status(200).body(usuarioAlterado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario (@PathVariable Integer id) {
		dao.deleteById(id);
		return ResponseEntity.status(204).build();
	}

	
	
	
}
