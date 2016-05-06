package br.com.techne.cadastro.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.techne.cadastro.dao.PessoaDao;
import br.com.techne.cadastro.model.Pessoa;
@ApplicationScoped
public class PessoaService {
	@Inject
	PessoaDao pessoaDao;

	public Pessoa salvar(Pessoa pessoa) {
		pessoaDao.save(pessoa);
		if (pessoa.getId() != null) {
			return pessoaDao.get(pessoa.getId());
		}
		return null;
	}

	public Pessoa editar(Pessoa pessoa) {
		if (pessoaDao.get(pessoa.getId()) != null) {
			pessoaDao.edit(pessoa);
			return pessoa;
		}
		return null;
	}

	public void excluir(Pessoa pessoa) {
		if (pessoaDao.get(pessoa.getId()) != null) {
			pessoaDao.delete(pessoa);
		}
	}

	public List<Pessoa> listar() {
		return pessoaDao.list();
	}
	
	public Pessoa show(Long id){
		return pessoaDao.get(id);
	}
}
