package br.puc.arquitetura.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book extends ResourceSupport{
	private String isbn;
	private String title;
	private String description;
	private List<String> authors;
	private List<String> keywords;
	private List<String> reviews;
	private Integer publicationYear;
	private Integer edition;
	private String editorCompany;
	private String bookDescription;
	@JsonIgnore
	private List<Book> bookRelated;
	
	public Book(String isbn, String title, String description, List<String> authors, List<String> keywords, List<String> reviews,
			String bookDescription) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.authors = authors;
		this.keywords = keywords;
		this.reviews = reviews;
		this.bookDescription = bookDescription;
		bookRelated = new ArrayList<Book>();
	}
	
	public void addRelatedBook(Book bk) {
		this.bookRelated.add(bk);
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public List<String> getReviews() {
		return reviews;
	}
	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
	public Integer getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public String getEditorCompany() {
		return editorCompany;
	}
	public void setEditorCompany(String editorCompany) {
		this.editorCompany = editorCompany;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public List<Book> getBookRelated() {
		return bookRelated;
	}
	public void setBookRelated(List<Book> bookRelated) {
		this.bookRelated = bookRelated;
	}
}
