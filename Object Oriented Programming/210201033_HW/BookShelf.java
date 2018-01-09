import java.util.ArrayList;
import java.util.Scanner;

public class BookShelf {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Author> authorxList;

	public BookShelf() {

	}

	public void sendAuthorList(ArrayList<Author> authorxList) {
		this.authorxList = authorxList;
	}
	public ArrayList<Book> getBookList() {
		return bookList;
	      }
    public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	public void addBook() {
		
		int i = bookList.size();
		bookList.add(new Book());
		Scanner input = new Scanner(System.in);
		System.out.println("enter a book title");
		bookList.get(i).setTitle(input.nextLine());
		System.out.println("enter a ISBN");
		bookList.get(i).setISBN(input.nextLine());
		System.out.println("enter a book type");
		String typeBook=input.nextLine();
		String str1=typeBook.toUpperCase();
		bookList.get(i).setType(Genre.valueOf(str1));
		System.out.println("enter a publishing year");
		bookList.get(i).setPublishingYear(input.nextInt());
		System.out.println("enter a publisher");
		bookList.get(i).setPublisher(input.nextLine());
		input.nextLine();
		System.out.println("enter a price");
		bookList.get(i).setPrice(Double.valueOf(input.nextLine()));
		String in;
		do{
			int z=0;
		    System.out.println("enter a author name");
			in = input.nextLine();
			boolean isContain=false;
			bookList.get(i).getAuthorsList().add(in);
		for(int j=0;j<authorxList.size();j++){
			if(authorxList.get(j).getName().equals(in)){
				isContain =true;
				break;
			}
		}
		if(!(isContain)){
			authorxList.add(new Author());
			authorxList.get(z).setName(in);
			System.out.println("Enter an author birth year");
			authorxList.get(z).setBirthYear(input.nextInt());
			System.out.println("Enter an author birth place");
			authorxList.get(z).setBirthPlace(input.nextLine());
			input.nextLine();
			String str;
			do{
				System.out.println("Enter an book");
				str=input.nextLine();
				if(str.equals("exit")){
					break;
				}
				else{
					authorxList.get(z).getBookNameList().add(str);
				}
				
			}while(!(str.equals("exit")));
			z++;
			}
		System.out.println("if there is no other author name, write 'exit'");
		in=input.nextLine();
			} while(!(in.equals("exit")));
		System.out.println(bookList.size());
		System.out.println(authorxList.size());
       i++;
		
		}
	  public void removeBook(){
	  System.out.println("Enter the ISBN number");
	  @SuppressWarnings("resource")
	  Scanner sc = new Scanner(System.in);
	  String input = sc.nextLine();
	  for(int i=0;i<bookList.size();i++){
	      if(bookList.get(i).getISBN().equals(input));
		bookList.remove(i);
		authorxList.remove(i);
	     break;
	}
	System.out.println(bookList.size());
	System.out.println(authorxList.size());
	}
	public void searchGenre(){
		System.out.println("Please enter the genre type");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String str1 = input.toUpperCase();
		for(int i=0;i<bookList.size();i++){
			if(bookList.get(i).getType().equals(Genre.valueOf(str1))){
				System.out.println(bookList.get(i).getTitle());
			}	
			}
	}
	public void searchYear(){
		System.out.println("Enter the year");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(int i=0;i<bookList.size();i++){
			if(bookList.get(i).getPublishingYear()== Integer.valueOf(input)){
				System.out.println(bookList.get(i).getTitle());
				}
			}
	}
	public void searchAuthor(){
		System.out.println("Please enter the author");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(int i=0;i<bookList.size();i++){
			if(bookList.get(i).getAuthorsList().contains(input)){
				System.out.println(bookList.get(i).getTitle());
				}
			}
	}
	
	public void searchPrice(){
		System.out.println("Enter the price");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(int i=0;i<bookList.size();i++){
			if(bookList.get(i).getPrice()== Double.valueOf(input)){
				System.out.println(bookList.get(i).getTitle());
				}
			}
	}
	
	 public void calculateTotalPrice(){
		 double sum=0;
		 for(int i=0;i<bookList.size();i++){
			sum=sum+ bookList.get(i).getPrice();
			 
		 }
		 System.out.println(sum);
	 }
	
}