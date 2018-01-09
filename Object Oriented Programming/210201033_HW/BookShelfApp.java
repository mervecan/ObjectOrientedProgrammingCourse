import java.io.FileNotFoundException;

public class BookShelfApp {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DataAccessLayer dal = new DataAccessLayer();
		AuthorList al = new AuthorList();
		dal.readAuthors(al.getAuthorList());
        BookShelf bl = new BookShelf();
		bl.sendAuthorList(al.getAuthorList());
		dal.readBooks(bl.getBookList());
		BookShelfMenu menu=new BookShelfMenu();
		menu.setBookShelf(bl);
		menu.BookShelfMethods();
		
	}

}
