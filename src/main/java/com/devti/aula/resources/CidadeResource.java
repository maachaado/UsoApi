
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
import org.springframework.web.bind.annotation.RestController;

import com.devti.aula.model.Cidade;
import com.devti.aula.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService service;

	@PostMapping
	@ApiOperation(value = "Insere uma Cidade no banco de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public Cidade inserirCidade(@RequestBody Cidade c) {
		return service.incluir(c);
	}

	@GetMapping("/lista")
	@ApiOperation(value = "Lista todas as Cidades.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public List<Cidade> listarTodas() {
		return service.listarTodas();
	}

	@PutMapping
	@ApiOperation(value = "Alteração de Cidade no banco de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public Cidade alterar(@RequestBody Cidade c) {
		return service.alterar(c);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui cidade da base de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}

	@GetMapping("/buscauf/{uf}")
	@ApiOperation(value = "Busca uma cidade por uf.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna dados."),
	@ApiResponse(code = 403, message = "Permissão negada."),		
	@ApiResponse(code = 500, message = "Foi gerada uma exceção."), })
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf) {
		return service.buscarPorUf(uf);
	}
}
