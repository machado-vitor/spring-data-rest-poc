package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        if (bookRepository.count() == 0) {
            Book book1 = new Book();
            book1.setTitle("Effective Java");
            book1.setAuthor("Joshua Bloch");
            bookRepository.save(book1);

            Book book2 = new Book();
            book2.setTitle("Spring in Action");
            book2.setAuthor("Craig Walls");
            bookRepository.save(book2);

            Book book3 = new Book();
            book3.setTitle("Clean Code");
            book3.setAuthor("Robert C. Martin");
            bookRepository.save(book3);
        }
    }
}
