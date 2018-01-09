package development;

import java.util.concurrent.ThreadLocalRandom;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Game {

	private Grid gridOb;
	
	
	public Game() {
		setGrid(gridOb);
	}
	
	public Game(Grid gridOb) {
		setGrid(gridOb);
	}

	public Grid getGrid() {
		return gridOb;
	}

	public void setGrid(Grid gridOb) {
		this.gridOb = gridOb;
	}

	public Grid createGrid() {
		int gridSize = ThreadLocalRandom.current().nextInt(3, 8);
		
	
		System.out.println("Size:"+gridSize);
		Grid gridOb = new Grid();
		for(int i=0;i<gridSize;i++) {
			Row rowOb=new Row();
			for(int j=0;j<gridSize;j++) {
				Cell cellOb=null;
				cellOb = new Cell(CellComponents.WALL,CellComponents.APERTURE,CellComponents.WALL,CellComponents.WALL);
				rowOb.getCells().add(cellOb);
			} 	
			gridOb.getRows().add(rowOb);
		}
	
	   for(int i=0;i<gridSize;i++) {
		   gridOb.getRows().get(0).getCells().get(i).setLeft(CellComponents.APERTURE);
		   gridOb.getRows().get(i).getCells().get(gridSize-1).setUp(CellComponents.APERTURE);
		   gridOb.getRows().get(i).getCells().get(0).setRight(CellComponents.WALL);
		   gridOb.getRows().get(i).getCells().get(0).setLeft(CellComponents.APERTURE);
		  gridOb.getRows().get(gridSize-1).getCells().get(gridSize-1).setLeft(CellComponents.EXIT);
	   } 
		System.out.println(gridOb.toString());
		return gridOb;
		
	}
	
	public boolean play(Movement movement, Player player) {
		
		return true;
	}

	@Override
	public String toString() {
		return "Game [grid=" + gridOb + "]";
	}
	
	
}
