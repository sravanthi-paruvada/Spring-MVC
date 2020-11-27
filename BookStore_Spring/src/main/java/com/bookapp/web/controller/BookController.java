package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/")
	public String home() {
		return "redirect:/allbooks";
	}

	@GetMapping("allbooks")
	public ModelAndView allBooks(ModelAndView mv) {
		mv.setViewName("allbooks");
		mv.addObject("books", bookService.getAllBooks());
		return mv;
	}

	
	@GetMapping("addbook")
	public String addBookGet(ModelMap map) {
		Book book = new Book();
		map.addAttribute("book", book);
		return "addbook";
	}

		@PostMapping("addbook")
	public String addBookPost(@ModelAttribute(name = "book") Book book) {

		int id = book.getId();
		if (id == 0)
			bookService.addBook(book);
		else
			bookService.updateBook(id, book);

		return "redirect:/allbooks";

	}

	
	@GetMapping("updatebook")
	public String updateBookGet(HttpServletRequest req, ModelMap map) {
		int id = Integer.parseInt(req.getParameter("id"));
		Book book = bookService.getBookById(id);
		map.addAttribute("book", book);
		return "updatebookpage";
	}

	@GetMapping("deletebook")
	public String delBook(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		bookService.deleteBook(id);
		return "redirect:/allbooks";
	}

}
