package br.puc.arquitetura.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.puc.arquitetura.model.Book;

public class BookDAO {

	private List<Book> bookList;
	
	public List<Book> filterByTitle(List<Book> allBooks, String title) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for(Book bk : allBooks){
			if(bk.getTitle().contains(title)){
				filteredBooks.add(bk);
			}
		}
		
		return filteredBooks;
	}
	
	public List<Book> filterByAuthor(List<Book> allBooks, String author) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for(Book bk : allBooks){
			if(bk.getAuthors().contains(author)){
				filteredBooks.add(bk);
			}
		}
		
		return filteredBooks;
	}
	
	public List<Book> filterBykeyword(List<Book> allBooks, String keyword) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for(Book bk : allBooks){
			if(bk.getKeywords().contains(keyword)){
				filteredBooks.add(bk);
			}
		}
		
		return filteredBooks;
	}
	
	public Book findByIsbn(String isbn){
		for (Book bk : getAllBooks()) {
			if(bk.getIsbn().equals(isbn))
				return bk;
		}
		
		return null;
	}
	
	public List<Book> getAllBooks(){
		bookList = new ArrayList<Book>();
		Book bk1 = new Book("ABC123", "Title of book 1", "Description of book 1",
				Arrays.asList("Stephen King", "Bernard Cornwell"), 
				Arrays.asList("horror", "battle", "drama"), 
				Arrays.asList("Good book", "Intense book", "do not intereting in this book"),	
				" This book is about life and death");
		Book bk2 = new Book("ABC456", "Title of book 2", "Description of book 2",
				Arrays.asList("Stephen King"), 
				Arrays.asList("horror", "killer"), 
				Arrays.asList("Terrifying book", "Intense book", "do not intereting in this book"),	
				" This book is just about death");
		Book bk3 = new Book("ABC789", "Another different title", "Description of book 3",
				Arrays.asList("J.R.R.Tolkien"), 
				Arrays.asList("fantasy", "battle", "drama"), 
				Arrays.asList("Good book", "Hobbit book"),	
				" This book is about a great adventure");
		
		bk1.addRelatedBook(bk2);
		bk2.addRelatedBook(bk1);
		
		bookList.add(bk1);
		bookList.add(bk2);
		bookList.add(bk3);
		
		return  bookList;
	}
}
