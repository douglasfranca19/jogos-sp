package com.doufsp.jogossp.exceptions;

public class IdNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/*public IdNotFound(String mensagem) {
		super(mensagem);
	}*/
	
	public IdNotFound (Object id) {
		super ("Id não encontrado: " + id);
	}

}
