package ru.netology.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Book book1 = new Book(1, "Book1", 200, "Author1");
    Book book2 = new Book(2, "Book2", 700, "Author2");
    Book book3 = new Book(3, "Book3", 500, "Author3");
    Smartphone smartphone1 = new Smartphone(4, "Smartphone4", 10_000, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(5, "Smartphone5", 20_000, "Manufacturer2");
    Smartphone smartphone3 = new Smartphone(6, "Smartphone6", 30_000, "Manufacturer3");


    @Test
    void shouldAddProducts() {
        repository.save(book1);
        manager.add(book2);
        repository.save(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchBy() {
        manager.add(book1);
        manager.add(smartphone2);
        manager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = manager.searchBy("Book");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotSearchProduct() {
        manager.add(book2);
        manager.add(smartphone3);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("T shirt");

        assertArrayEquals(expected, actual);
    }
}

