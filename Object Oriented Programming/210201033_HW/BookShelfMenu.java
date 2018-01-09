import java.util.Scanner;

public class BookShelfMenu {
   private 	BookShelf bookShelf;
	public BookShelf getBookShelf() {
	return bookShelf;
}
public void setBookShelf(BookShelf bookShelf) {
	this.bookShelf = bookShelf;
}
	Scanner in=new Scanner(System.in);
	public void BookShelfMethods(){
	do{
		System.out.println("1.add a book");
		System.out.println("2.remove a book");
		System.out.println("3.search  by genre");
		System.out.println("4.search books by publishing year");
		System.out.println("5.search books by author name");
		System.out.println("6.search books by price");
		System.out.println("7.calculate total price");
		System.out.println("8.calculate total price by author");
		System.out.println("to finish to process please write 'exit'");
		int choice=in.nextInt();
		switch(choice){
		case 1:
			bookShelf.addBook();
			break;
		case 2: 
			bookShelf.removeBook();
		  break;
		case 3:
			bookShelf.searchGenre();
		   break;
		case 4: 
			bookShelf.searchYear();
		   break;
		case 5:
			bookShelf.searchAuthor();
		   break;
		case 6: 
			bookShelf.searchPrice();
			break;
		case 7:
			bookShelf.calculateTotalPrice();
			break;
		
			
		}
		 
		}while(true);

	}
	
}
