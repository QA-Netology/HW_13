package ru.netology.product;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Book book1 = new Book(1, "Book1", 200, "Author1");
    Book book2 = new Book(2, "Book2", 700, "Author2");
    Book book3 = new Book(3, "Book3", 500, "Author3");
    Smartphone smartphone1 = new Smartphone(4, "Smartphone4", 10_000, "Manufacturer1");
    Smartphone smartphone2 = new Smartphone(5, "Smartphone5", 20_000, "Manufacturer2");
    Smartphone smartphone3 = new Smartphone(6, "Smartphone6", 30_000, "Manufacturer3");


    @Test
    void shouldSaveProductsInRepository() {
        repository.save(book1);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.save(book1);
        repository.save(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {       //удали продукт по id
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);

        repository.removeById(2);

        Product[] expected = {book1, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}

