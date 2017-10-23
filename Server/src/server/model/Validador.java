package server.model;

public class Validador {

	public boolean senha(String senha) {
		if( senha != null ) {
			if( !senha.isEmpty() ) {
				if(senha.length() >= 5)
					return true;
			}
		}
		return false;
	} 
	
	public boolean nome(String nome) {
		if( nome != null ) {
			if( !nome.isEmpty() ) {			
					return true;
			}
		}
		return false;
	}
	
	
	public boolean email(String email) {
		if( email != null ) {
			if( !email.isEmpty() ) {
				if( email.contains("@") && email.contains(".com"))
					return true;
			}
		}
		return false;
	}
	
	
	public boolean telefone(String telefone) {
		if( telefone != null ) {
			if( !telefone.isEmpty() ) {
				if( telefone.length() == 9 )
					return true;
			}
		}
		return false;
	}
}