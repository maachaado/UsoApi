package com.devti.aula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os Clientes.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public List<Cliente> listarTodos(){
		return service.listarTodos();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui Cliente do banco de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Insere um Cliente no banco de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public Cliente inserir(@RequestBody Cliente c) {
		return service.incluir(c);
	}
	
	@GetMapping("/buscacidade/{cidade}")
	@ApiOperation(value = "Busca cliente por cidade.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public List<Cliente> buscarPorCidade(@PathVariable("cidade") Cidade c) {
		return service.buscarPorCidade(c);
	}
	
	@PutMapping
	@ApiOperation(value = "Alteração de Cidade no banco de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public Cliente alterar(@RequestBody Cliente c, @RequestParam("id") int id) {
		return service.alterar(c);
	}
	 
	
	  
}
