package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }
    
}
