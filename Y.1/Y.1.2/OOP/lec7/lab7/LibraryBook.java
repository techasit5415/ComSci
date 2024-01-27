import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryBook extends Book implements BorrowAble {
    private int id;
    private Boolean availForBorrow = true;
    private LocalDate dateBorrow;
    private PrintType printType;

    public LibraryBook(int id, String title, String author, String pub, int yr, int numPages,PrintType pt ){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = pub;
        this.year = yr;
        this.numberOfPages = numPages;
        this.printType = pt;
    }

    public boolean checkoutItem(int yy, int mm, int dd){
        if(getType() == PrintType.PRINT && isAvailable() == true){
            setBorrowTime(yy, mm, dd);
            setBookAvailableFalse();
            return true;
        }else{
            return false;
        }
    }

    public int returnItem(int yy, int mm, int dd){
        LocalDate borrowDate = LocalDate.of(yy, mm, dd); 
        long daysBetween = ChronoUnit.DAYS.between(dateBorrow, borrowDate);
        if((int)daysBetween <= 7){
            return 0;
        }else{
            return Math.abs((int)daysBetween);
        }
    }

    public void setBorrowTime(int yy, int mm, int dd){
        dateBorrow = LocalDate.of(yy, mm, dd);
    }

    public void setBookAvailableFalse(){
        availForBorrow = false;
    }

    public void setBookAvailableTrue(){
        availForBorrow = true;
    }

    public boolean isAvailable(){
        return availForBorrow;
    }

    public PrintType getType(){
        return this.printType;
    }

    @Override
    public String toString() {
        return "LibraryBook [id=" + id + ", title=" + title + ", type=" + printType   + ", avail=" + availForBorrow + "]";
    }

    
}