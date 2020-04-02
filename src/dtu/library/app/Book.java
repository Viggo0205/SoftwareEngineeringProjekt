package dtu.library.app;

/**
 * This class represents a book with title, author, and signature, where signature
 * is a unique key used by the librarian to identify the book. Very often it is 
 * composed of the first letters of the authors plus the year the book was published.
 * @author Hubert
 *
 */
public class Book {
    public String title;
    public String author;
    public String signature;

    public Book(String title, String author, String signature) {
        this.title = title;
        this.author = author;
        this.signature = signature;
    }


    public Object getTitle(){
        return title;
    }
    public Object getSignature(){
        return signature;
    }
    public Object getAuthor() {
    return author;
    }
}
