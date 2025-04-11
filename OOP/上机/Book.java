public class Book {
    private String name;
    private String author;
    private double price;
    private boolean isBorrowed;

    public Book(String name, String author, double price, boolean isBorrowed) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.isBorrowed = isBorrowed;
    }

    public String getName() { return name; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }
}
