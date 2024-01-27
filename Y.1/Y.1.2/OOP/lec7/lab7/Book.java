public abstract class Book extends Library{
    protected String isbn;
    protected String title;
    protected String author;
    protected String publisher;
    protected int year;
    protected int numberOfPages;
    private int currentPageNumber;

    Book(){}
    
    public Book(String isbn, String title, String author, String pub, int yr, int numPages){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = pub;
        this.year = yr;
        this.numberOfPages = numPages;
    }

    public void turnPageForward(){
        if(this.currentPageNumber < 100){
            currentPageNumber++;
        }
    }

    public void turnPageBackward(){
        if(currentPageNumber > 0){
            currentPageNumber--;
        }
    }

    public int nowAtPage(){
        return this.currentPageNumber;
    }

    public String getTitle(){
        return this.title;
    }
}