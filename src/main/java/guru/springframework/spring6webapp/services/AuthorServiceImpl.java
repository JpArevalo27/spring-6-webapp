package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll(){
        return authorRepository.findAll();
    }
    
}
