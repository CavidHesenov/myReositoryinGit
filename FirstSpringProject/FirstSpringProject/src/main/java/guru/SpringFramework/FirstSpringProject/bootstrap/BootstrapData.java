package guru.SpringFramework.FirstSpringProject.bootstrap;

import guru.SpringFramework.FirstSpringProject.domain.Author;
import guru.SpringFramework.FirstSpringProject.domain.Book;
import guru.SpringFramework.FirstSpringProject.domain.Publisher;
import guru.SpringFramework.FirstSpringProject.repositories.AuthorRepository;
import guru.SpringFramework.FirstSpringProject.repositories.BookRepository;
import guru.SpringFramework.FirstSpringProject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Cavid");
        publisher.setCity("Goranboy");
        publisher.setState("Azerbaijan");

        publisherRepository.save(publisher);


        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Drive Design","asad");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        System.out.println("Number of books ="+ bookRepository.count());

        System.out.println("Publisher number of books ="+publisher.getBooks().size());
    }
}
