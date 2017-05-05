package br.puc.arquitetura.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class Reviews extends ResourceSupport {
	List<String> reviews;
	
	public List<String> getReviews() {
		return reviews;
	}

	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
}
