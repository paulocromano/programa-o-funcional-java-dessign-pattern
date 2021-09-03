package adapter.repository;

import java.util.List;

import adapter.model.Cliente;

public class FirebaseAdapter implements DbAdapter<Cliente> {
	
	private Firebase firebase;
	
	public FirebaseAdapter(Firebase firebase) {
		this.firebase = firebase;
	}

	@Override
	public List<Cliente> buscar() {
		return this.firebase.buscarDados();
	}

}
