package br.com.criandoapi.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class UsuarioController {
	
	@Autowired //Faz uma injeção automática dos métodos não implementados da Interface (ao invés de fazer UsuarioController implements IUsuario)
	private IUsuario dao;
	
	@GetMapping
	public List<Usuario> listaUsuarios () {
		return (List<Usuario>) dao.findAll();
	}

	@PostMapping
	public Usuario criarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuarioNovo;
	}

	@PutMapping
	public Usuario atualizarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioAlterado = dao.save(usuario);
		return usuarioAlterado;
	}

	@DeleteMapping("/{id}")
	public Optional<Usuario> deleteUsuario (@PathVariable Integer id) {
		Optional<Usuario> usuarioDeletado = dao.findById(id);
		dao.deleteById(id);
		return usuarioDeletado;
	}

	
	
	
}
