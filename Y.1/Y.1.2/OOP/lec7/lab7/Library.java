import java.util.HashMap;

public class Library {
    private static HashMap<Integer ,Book> allBooks = new HashMap<>();
    
    static{
        allBooks.put(1, new LibraryBook(1, "Charlotte's Web", "EB White", "abc", 1952, 100, PrintType.PRINT));
        allBooks.put(2, new LibraryBook(2, "Charlotte's Web", "EB White", "abc", 1952, 100, PrintType.ECOPY));
        allBooks.put(3, new LibraryBook(3, "The BFG", "Roald Dahl", "abc", 1982, 300, PrintType.PRINT));
        allBooks.put(4, new LibraryBook(4, "The Little Prince", "Antoine de Saint-Exupéry", "abc", 1943, 200, PrintType.ECOPY));
        allBooks.put(5, new ArchiveMaterial(5, "My Mister", "not KBS", "abc", 2018, 400, Status.READY));
        allBooks.put(6, new ArchiveMaterial(6, "Sword Snow Stride", "CNTV", "abc", 2018, 500, Status.REPAIRED));
    }
    
    public void printAllItems(){
        for (Book books : allBooks.values()) {
            System.out.println(books);
        }
    }

    public Book getBookById(int i){
        return allBooks.get(i);
    }

    public boolean checkOut(Book item, int yy, int mm, int dd){
        if(item instanceof LibraryBook){
            return ((LibraryBook)item).checkoutItem(yy, mm, dd);
        }else{
            return false;
        }
    }

    public void checkIn(Book item, int yy, int mm, int dd){
        if(item instanceof LibraryBook){
            if(((LibraryBook)item).isAvailable() == true){
                System.out.println("The item has been check out");
            }else{ 
                if(((LibraryBook)item).returnItem(yy, mm, dd) == 0){
                    System.out.println("see you next time");
                }else{
                    System.out.println("Pay fine for " + (((LibraryBook)item).returnItem(yy, mm, dd) - 7) + " days");
                }
            }
        }else{
            System.out.println("This is archive not Book");
        }
    }
}