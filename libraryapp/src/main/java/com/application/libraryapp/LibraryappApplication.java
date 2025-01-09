package com.application.libraryapp;

import com.application.libraryapp.entity.Author;
import com.application.libraryapp.entity.Book;
import com.application.libraryapp.entity.Category;
import com.application.libraryapp.entity.Publisher;
import com.application.libraryapp.service.BooksService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryappApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryappApplication.class, args);}

	@Bean
	public CommandLineRunner initialCreate(BooksService booksService){
		return(args) ->{
			// Initial Dummy data
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			Publisher publisher1 = new Publisher("First Publisher");
			book1.addauthor(author1);
			book1.addcategory(category1);
			book1.addpublisher(publisher1);
			booksService.createBook(book1);

			Book book2 = new Book("ABC1", "Book name", "My first book");
			Author author2 = new Author("Test name2", "Test description");
			Category category2 = new Category("Science books");
			Publisher publisher2 = new Publisher("Second Publisher");
			book2.addauthor(author2);
			book2.addcategory(category2);
			book2.addpublisher(publisher2);
			booksService.createBook(book2);

			Book book3 = new Book("ABC21", "Book name", "My first book");
			Author author3 = new Author("Test name3", "Test description");
			Category category3 = new Category("Fiction books");
			Publisher publisher3 = new Publisher("Third Publisher");
			book3.addauthor(author3);
			book3.addcategory(category3);
			book3.addpublisher(publisher3);
			booksService.createBook(book3);
		};
	}

}
