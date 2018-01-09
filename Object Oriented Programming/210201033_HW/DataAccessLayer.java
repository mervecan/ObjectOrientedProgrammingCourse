
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataAccessLayer {

	public void readAuthors(ArrayList<Author> authorList) throws FileNotFoundException {
		//Author a= new Author();
		try {
			StringTokenizer tokenizer;
			File file = new File("authors.dat");
			Scanner inFile = new Scanner(file);
			String line;
			int i =authorList.size() ;
			while ( inFile.hasNextLine()) {
				line = inFile.nextLine();
				tokenizer = new StringTokenizer(line, ",");
				authorList.add(new Author());
				authorList.get(i).setName(tokenizer.nextToken());
			    authorList.get(i).setBirthYear(Integer.valueOf(tokenizer.nextToken()));
				authorList.get(i).setBirthPlace(tokenizer.nextToken());
				
				while (tokenizer.hasMoreTokens()) {
					authorList.get(i).getBookNameList().add(tokenizer.nextToken());
					
				}
				System.out.print(authorList.get(i).getName());
				System.out.print(authorList.get(i).getBirthYear());
				System.out.print(authorList.get(i).getBirthPlace());
				System.out.print(authorList.get(i).getBookNameList());
				System.out.println();
			
				i++;
				
			}
			inFile.close();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

	}
	
	public void readBooks(ArrayList<Book> bookList) throws FileNotFoundException{
		StringTokenizer token;
		try {
		File file = new File("books.dat");
		Scanner inFile = new Scanner(file);
		String line;
		int i = bookList.size();
		String str;
		while (inFile.hasNextLine()) {
			line = inFile.nextLine();
			token = new StringTokenizer(line, ",");
			bookList.add(new Book());
			bookList.get(i).setTitle(token.nextToken());
			bookList.get(i).setISBN(token.nextToken());
			str = token.nextToken();
			bookList.get(i).setType(Genre.valueOf(str.toUpperCase()));
			bookList.get(i).setPublishingYear(Integer.valueOf(token.nextToken()));
			bookList.get(i).setPublisher(token.nextToken());
			bookList.get(i).setPrice(Double.valueOf(token.nextToken()));
			while (token.hasMoreTokens()) {
				bookList.get(i).getAuthorsList().add(token.nextToken());
				}
			System.out.print(bookList.get(i).getTitle());
			System.out.print(bookList.get(i).getISBN());
			System.out.print(bookList.get(i).getType());
			System.out.print(bookList.get(i).getPublishingYear());
			System.out.print(bookList.get(i).getPublisher());
			System.out.print(bookList.get(i).getPrice());
			System.out.print(bookList.get(i).getAuthorsList());
			System.out.println();
			i++;
		}
		inFile.close();
	} catch (InputMismatchException e) {
		e.printStackTrace();
	}

}}
