package com.example.SkillExperiement6;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class LibraryController {
	@GetMapping("/welcome")
	public String show() { 
		return "Welcome to the Spring Controller";
	}
	@GetMapping("/count")
	public int totalBooks() {
		return 100;
	}
	@GetMapping("/Price")
	public double bookPrice() {
		return 2000.d;
	}
	
	String bookNames[]= {"Java","Python","React","JavaScript"};
	@GetMapping("/books")
	public List<String> bookTitles() {
		return Arrays.asList(bookNames);
	}
	
	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable int id) {
		return "The Book Details are"+ id;
	}
	
	@GetMapping("/search")
	public String display(@RequestParam String title) {
		return "This title is"+ title;
	}
	@GetMapping("/author/{name}")
	public String displayAuthor(@PathVariable String name) {
		return "The author name is:" + name;
	}
	//9.create a method to /addbook using @postmapping that accepts a book object from the request body and adds it to an in-memory list.
	List<Book> bookList=new ArrayList<>();
	
	@PostMapping("/addbook")
	public void addBook(@RequestBody Book b) {
		bookList.add(b);
	}
	
	//10 create a method to /viewbooks using @GetMapping that returns all added book objects
	@GetMapping("/viewbooks")
	public List<Book> showbooks() {
		return bookList;
	}
	
}
