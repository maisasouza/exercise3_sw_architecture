package br.puc.arquitetura.restControllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.puc.arquitetura.dao.BookDAO;
import br.puc.arquitetura.model.Book;
import br.puc.arquitetura.model.BooksResult;
import br.puc.arquitetura.model.Reviews;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<BooksResult> get(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author,
			@RequestParam(value = "keyword", required = false) String keyword) {

		BooksResult br = new BooksResult();

		br.setResultSearch(dao.getAllBooks());
		if (title != null && title.length() > 0) {
			br.setResultSearch(dao.filterByTitle(br.getResultSearch(), title));
		}

		if (author != null && author.length() > 0) {
			br.setResultSearch(dao.filterByAuthor(br.getResultSearch(), author));
		}

		if (keyword != null && keyword.length() > 0) {
			br.setResultSearch(dao.filterBykeyword(br.getResultSearch(), keyword));
		}
		
		br.setCountResult(br.getResultSearch().size());

		for (Book bk : br.getResultSearch()) {
			bk.add(linkTo(methodOn(BookController.class).getOneBook(bk.getIsbn())).withSelfRel());
			for (Book relatedBook : bk.getBookRelated()) {
				bk.add(linkTo(methodOn(BookController.class).getOneBook(relatedBook.getIsbn())).withRel("relatedBook"));
			}
		}

		if (br.getResultSearch() == null || br.getResultSearch().isEmpty()) {
			br.setResultSearch(new ArrayList<Book>());
			br.setCountResult(0);
			br.add(linkTo(methodOn(BookController.class).addBook()).withRel("newBook"));
		}

		return new ResponseEntity<BooksResult>(br, HttpStatus.OK);
	}

	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public HttpEntity<Book> getOneBook(@PathVariable("isbn") String isbn) {
		Book bk = dao.findByIsbn(isbn);
		
		if (bk != null) {
			for (Book relatedBook : bk.getBookRelated()) {
				bk.add(linkTo(methodOn(BookController.class).getOneBook(relatedBook.getIsbn())).withRel("relatedBook"));
			}
			
			return new ResponseEntity<Book>(bk, HttpStatus.OK);
		} else {
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/{isbn}/reviews", method = RequestMethod.GET)
	public HttpEntity<Reviews> getBookReviews(@PathVariable("isbn") String isbn) {
		Book bk = dao.findByIsbn(isbn);
		Reviews rvs = new Reviews();
		
		if (bk != null) {
			rvs.setReviews(bk.getReviews());
			rvs.add(linkTo(methodOn(BookController.class).addReview(bk.getIsbn())).withRel("newReview"));
			rvs.add(linkTo(methodOn(BookController.class).getOneBook(bk.getIsbn())).withRel("book"));
			return new ResponseEntity<Reviews>(rvs, HttpStatus.OK);
		} else {
			return new ResponseEntity<Reviews>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/newBook", method = RequestMethod.GET)
	public HttpEntity<String> addBook() {
		return new ResponseEntity<String>("Not implemented. But could be a page to fill a form and add a book",
				HttpStatus.OK);
	}

	@RequestMapping(value="{isbn}/newReview",method = RequestMethod.GET)
	public HttpEntity<String> addReview(@PathVariable("isbn") String isbn) {
		return new ResponseEntity<String>("Not implemented. But could be a page to fill a form and add a review",
				HttpStatus.OK);
	}
}
