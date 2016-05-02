package br.com.techne.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.techne.cadastro.model.Pessoa;
import br.com.techne.cadastro.service.PessoaService;

@Path("/cadastro/pessoa")
public class PessoaController {
	@EJB
	private PessoaService pessoaService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public List<Pessoa> listar(){
		ArrayList<Pessoa> arrayList = new ArrayList<Pessoa>();
		arrayList.add(new Pessoa());
		arrayList.add(new Pessoa());
		arrayList.add(new Pessoa());
		
		return arrayList;//pessoaService.listar();
	}
}
