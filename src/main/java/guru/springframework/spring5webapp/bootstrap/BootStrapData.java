package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Author rod = new Author("Rod","Johnson");
        Book ddd = new Book("Domain Driven Desing","1234fsd");
        Book noEJD = new Book("blabla", "fdfse1212");

        Publisher publisher1 = new Publisher();
        publisher1.setName("Penguin");
        publisher1.setAddress("CalleAndalucia");
        publisher1.setCity("Malaga");
        publisher1.setState("España");
        publisher1.setZip("29631");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Eco");
        publisher2.setZip("84325");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        rod.getBooks().add(noEJD);
        noEJD.getAuthors().add(rod);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        authorRepository.save(rod);
        bookRepository.save(noEJD);

        publisher1.getBooks().add(ddd);
        publisherRepository.save(publisher1);

        publisher1.getBooks().add(noEJD);
        publisherRepository.save(publisher1);

        publisherRepository.save(publisher2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of books of Publisher1:" + publisher1.getBooks().size());


    }
}
