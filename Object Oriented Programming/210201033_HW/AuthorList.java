import java.util.ArrayList;

public class AuthorList {
	private ArrayList<Author> authorList;
	public AuthorList() {
		authorList = new ArrayList<Author>();
	}



	public ArrayList<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(ArrayList<Author> authorList) {
		this.authorList = authorList;
	}
}
