package prototype.library;

import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.Assert;
import org.junit.Test;


public class LibraryTestSuite {
    @Test
    public void testGetBooks() {

        Library library = new Library("Mati's Library");
        Book firstBook = new Book("Duma i uprzedzenie", "Jane Austen", "1813");
        Book secondBook = new Book("Wojna i pokój", "Lew Tołstoj", "1869");

        library.getBooks().add(firstBook);
        library.getBooks().add(secondBook);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("shallowCopy - Mati's Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("deepCopy - Mati's Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(secondBook);

        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals( deepClonedLibrary.getBooks(), library.getBooks());
    }
}
