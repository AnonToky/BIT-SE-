import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Library myLittleLibrary = new Library();
        myLittleLibrary.addBook(new Book("Java程序设计", "张三", 45, false));
        myLittleLibrary.addBook(new Book("Java核心设计", "李四", 50, false));
        myLittleLibrary.addBook(new Book("Java程序设计", "王五", 38, true));

        System.out.println("当前馆藏图书：");
        myLittleLibrary.getAllBooks().forEach(System.out::println);

        Reader oneBeautifulGirl = new Reader("oneBeautifulGirl");

        List<Book> javaBooks = myLittleLibrary.findBook("Java程序设计");
        Book targetBook = javaBooks.stream()
                .filter(book -> "张三".equals(book.getAuthor()))
                .findFirst().orElse(null);

        // 借书
        if (targetBook != null) {
            oneBeautifulGirl.borrowBook(targetBook);
        }
        System.out.println("\n借书后馆藏状态：");
        myLittleLibrary.getAllBooks().forEach(System.out::println);

        // 还书
        if (targetBook != null) {
            oneBeautifulGirl.returnBook(targetBook);
        }
        System.out.println("\n还书后馆藏状态：");
        myLittleLibrary.getAllBooks().forEach(System.out::println);
    }
}