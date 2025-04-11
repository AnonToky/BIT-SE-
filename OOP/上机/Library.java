import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> findBook(String name) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().equals(name)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<String> getAllBooks() {
        List<String> infoList = new ArrayList<>();
        for (Book book : books) {
            String status = book.isBorrowed() ? "未还" : "可借";
            infoList.add(String.format("%s，%s著，%.0f元，%s",
                    book.getName(), book.getAuthor(), book.getPrice(), status));
        }
        return infoList;
    }
}