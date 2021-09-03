package util;

import adapter.service.ClienteService;
import builder.service.PessoaService;
import composite.service.ProdutoService;
import factory.method.service.CarroService;
import factory.method.service.MotoService;
import strategy.service.AlunoService;

public enum Service {

	PESSOA_BUILDER(new PessoaService()),
	CARRO_FACTORY_METHOD(new CarroService()),
	MOTO_FACTORY_METHOD(new MotoService()),
	PRODUTO_COMPOSITE(new ProdutoService()),
	ALUNO_STRATEGY(new AlunoService()),
	CLIENTE_ADAPTER(new ClienteService());
	
	
	private ExecuteService service;

	private Service(ExecuteService service) {
		this.service = service;
	}

	
	public ExecuteService getService() {
		return service;
	}
}
