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
        Book ddd = new Book("Domain Driven Desing","1234fsd");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJD = new Book("blabla", "fdfse1212");

        rod.getBooks().add(noEJD);
        noEJD.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJD);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher prueba1 = new Publisher();
        prueba1.setName("Penguin");
        prueba1.setAddress("CalleAndalucia");
        prueba1.setCity("Malaga");
        prueba1.setState("España");
        prueba1.setZip("29631");

        publisherRepository.save(prueba1);

        Publisher prueba2 = new Publisher();
        prueba2.setName("Eco");
        prueba2.setZip("84325");

        publisherRepository.save(prueba2);

        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
