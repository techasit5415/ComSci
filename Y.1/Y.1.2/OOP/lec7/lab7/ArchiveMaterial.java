public class ArchiveMaterial extends Book{
    private int id;
    private Status status;

    ArchiveMaterial(int id, String title, String author, String pub, int yr, int numPages, Status status){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = pub;
        this.year = yr;
        this.numberOfPages = numPages;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ArchiveMaterial [id=" + id + ", title=" + title + ", status=" + status + ", message=" + status.sayHi() + "]";
    }

    
}