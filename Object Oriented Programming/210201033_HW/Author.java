import java.util.ArrayList;

public class Author {
   private String name;
   private int birthYear;
   private String birthPlace;
   private ArrayList<String> bookNameList=new ArrayList<String>();  //arraylist
   public Author(String name,int birthYear,String birthPlace, ArrayList<String> bookNameList){
	   this.name=name;
	   this.birthYear=birthYear;
	   this.birthPlace=birthPlace;
	   this.bookNameList=bookNameList;
			   
   }
   public Author(){
	   
   }
   
   public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getBirthYear() {
	return birthYear;
}
public void setBirthYear(int string) {
	this.birthYear = string;
}
public String getBirthPlace() {
	return birthPlace;
}
public void setBirthPlace(String birthPlace) {
	this.birthPlace = birthPlace;
}



public ArrayList<String> getBookNameList() {
	return bookNameList;
}
public void setBookNameList(ArrayList<String> bookNameList) {
	this.bookNameList = bookNameList;
}

}
