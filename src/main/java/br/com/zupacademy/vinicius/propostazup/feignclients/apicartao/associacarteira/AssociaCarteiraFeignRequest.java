package br.com.zupacademy.vinicius.propostazup.feignclients.apicartao.associacarteira;

public class AssociaCarteiraFeignRequest {

	private String email;
	private String carteira;

	public AssociaCarteiraFeignRequest(String email, String carteira) {
		this.email = email;
		this.carteira = carteira;
	}

	public String getEmail() {
		return email;
	}

	public String getCarteira() {
		return carteira;
	}

}
