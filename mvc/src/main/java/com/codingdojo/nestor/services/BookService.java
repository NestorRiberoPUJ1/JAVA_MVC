package com.codingdojo.nestor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.nestor.models.Book;
import com.codingdojo.nestor.repositories.BookRepository;

@Service
public class BookService {
    // agregar el repositorio de libros como una dependencia
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // devuelve todos los libros
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // crea un libro
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // recupera un librocopy
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book newBook= new Book(id,title,desc,lang,numOfPages);
    	return bookRepository.save(newBook);
    }
    
}
