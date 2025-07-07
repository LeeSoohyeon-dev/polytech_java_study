package com.survivalcoding;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class BookTest {

    private Book book1;
    private Book book2;
    private Book book3;
    private Date date1;
    private Date date2;

    @BeforeEach
    void setUp() {
        date1 = new Date(2024, 1, 1);
        date2 = new Date(2023, 1, 1);
        book1 = new Book("Book", date1, "comment1");
        book2 = new Book("Book", new Date(2024, 1, 1), "comment2");
        book3 = new Book("Book2", date2, "comment3");
    }


    @Test
    void testEquals() {
        assertTrue(book1.equals(book2));
        assertFalse(book1.equals(book3));
        assertFalse(book1.equals(null));
        assertTrue(book1.equals(book1));
    }

    @Test
    void testHashCode() {
        assertEquals(book1.hashCode(), book2.hashCode());
        assertNotEquals(book1.hashCode(), book3.hashCode());
    }

    @Test
    void testSetBehavior() {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        assertEquals(1, bookSet.size());
    }

    @Test
    void testSorting() {
        List<Book> books = Arrays.asList(book3, book1);
        Collections.sort(books);
        assertEquals("Book", books.get(0).getTitle());
    }

    @Test
    void testClone() {
        Book cloned = book1.clone();
        assertNotSame(book1, cloned);
        assertEquals(book1, cloned);

        cloned.getPublishDate().setYear(2025);
        assertNotEquals(book1.getPublishDate().getYear(), cloned.getPublishDate().getYear());
    }
}