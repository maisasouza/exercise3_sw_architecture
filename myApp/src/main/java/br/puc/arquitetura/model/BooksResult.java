package br.puc.arquitetura.model;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class BooksResult extends ResourceSupport {
	private List<Book> resultSearch;
	private Integer countResult;

	public Integer getCountResult() {
		return countResult;
	}

	public void setCountResult(Integer countResult) {
		this.countResult = countResult;
	}

	public List<Book> getResultSearch() {
		return resultSearch;
	}

	public void setResultSearch(List<Book> resultSearch) {
		this.resultSearch = resultSearch;
	}
}
