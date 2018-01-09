package development;

import java.util.ArrayList;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Grid {
	
	private ArrayList<Row> rows = new ArrayList<Row>();
	
	public Grid(ArrayList<Row> rows) {
		setRows(rows);
	}

	public Grid() {
		
	}
	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}

	
	
	
	
	
}
