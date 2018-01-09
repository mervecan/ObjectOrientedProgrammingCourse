package BusinessLayer;

import java.io.IOException;

import javax.swing.JOptionPane;

import DataAccessLayer.DataAccessLayer;
import PresentationLayer.Information;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class APP {

	public static void main(String[] args) throws IOException {
		
		DataAccessLayer dal= new DataAccessLayer();
		dal.readFile();
		//launch app
		 try
		  {
		  Information frame=new Information();
		 
		  frame.setVisible(true);
		  }
		  catch(Exception e)
		  {
			  JOptionPane.showMessageDialog(null, e.getMessage());
			  }
		  }
	
	}


