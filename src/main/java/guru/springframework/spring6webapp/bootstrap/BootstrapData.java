package guru.springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  @Override
  public void run(String... args) throws Exception {
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evans");

    Book ddd = new Book();
    ddd.setTitle("Domain Drive Design");
    ddd.setIsbn("123456");

    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    Author rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johnson");

    Book noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("54236546754");

    Author rodSaved = authorRepository.save(rod);
    Book noEJBSaved = bookRepository.save(noEJB);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);
    dddSaved.getAuthors().add(ericSaved);
    noEJBSaved.getAuthors().add(rodSaved);

    Publisher publisher = new Publisher();
    publisher.setPublisherName("My Publisher");
    publisher.setAddress("123 Main");
    Publisher savedPublisher = publisherRepository.save(publisher);

    dddSaved.setPublisher(savedPublisher);
    noEJBSaved.setPublisher(savedPublisher);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEJBSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());

    System.out.println("Publisher Count: " + publisherRepository.count());
  }

}
