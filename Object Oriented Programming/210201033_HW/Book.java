import java.util.ArrayList;

public class Book {
   private String title;
   private String ISBN;
   private Genre type;//genre type
   private int publishingYear;
   private String publisher;
   private double price;
   private ArrayList<String> authorsList =new ArrayList<String>();
   public Book(String title,String ISBN,Genre type,int publishingYear,String publisher,double price,ArrayList<String> authorsList){
	   this.title=title;
	   this.ISBN=ISBN;
	   this.type=type;
	   this.publishingYear=publishingYear;
	   this.publisher=publisher;
	   this.price=price;
	   this.authorsList=authorsList;
   }
   public Book(){
	   
   }

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public Genre getType() {
	return type;
}

public ArrayList<String> getAuthorsList() {
	return authorsList;
}
public void setAuthorsList(ArrayList<String> authorsList) {
	this.authorsList = authorsList;
}
public void setType(Genre type) {
	this.type = type;
}
public int getPublishingYear() {
	return publishingYear;
}
public void setPublishingYear(int publishingYear) {
	this.publishingYear = publishingYear;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
   
}
