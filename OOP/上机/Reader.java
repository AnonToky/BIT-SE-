public class Reader {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println(name + "借了《" + book.getName() + "》");
        } else {
            System.out.println("《" + book.getName() + "》已被借出,无法再借");
        }
    }

    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println(name + "归还了《" + book.getName() + "》");
        } else {
            System.out.println("错误，《" + book.getName() + "》未被借出");
        }
    }
}
