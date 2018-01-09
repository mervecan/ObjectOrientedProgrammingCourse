package development.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import development.Cell;
import development.CellComponents;
import development.Grid;
import development.Row;

public class TestGrid {
	
	protected static Grid grid;
	
	protected static Grid gridCreated;
	
	protected static ArrayList<Row> rowList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Cell cell00 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
				CellComponents.WALL, CellComponents.APERTURE);
		
		Cell cell01 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);
		
		Cell cell02 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);
		
		Cell cell10 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell11 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell12 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell20 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);
		
		Cell cell21 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);
		
		Cell cell22 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.WALL);
		
		
		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(0, cell00);
		cells.add(1, cell01);
		cells.add(2, cell02);
		Row row0 = new Row(cells);
		
		cells = new ArrayList<Cell>();
		cells.add(0, cell10);
		cells.add(1, cell11);
		cells.add(2, cell12);
		Row row1 = new Row(cells);
		
		cells = new ArrayList<Cell>();
		cells.add(0, cell20);
		cells.add(1, cell21);
		cells.add(2, cell22);
		Row row2 = new Row(cells);
		
		ArrayList<Row> rows = new ArrayList<Row>();
		rows.add(0, row0);
		rows.add(1, row1);
		rows.add(2, row2);
		rowList = new ArrayList<>();
		rowList = rows;
		grid = new Grid(rows);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetGrid() {
		
		assertEquals(rowList, grid.getRows());
		
	}
	
	@Test
	public void testSetGrid() {
		
		grid.setRows(null);
		assertEquals("Given rows cannot be null!", null, grid.getRows());
		
	}
	
	@Test 
	public void testToString() {
		
		assertEquals("Grid [rows=["
				+ "Row [cells=["
					+ "Cell [left=EXIT, right=APERTURE, up=WALL, down=APERTURE], "
					+ "Cell [left=APERTURE, right=WALL, up=WALL, down=APERTURE], "
					+ "Cell [left=WALL, right=WALL, up=WALL, down=APERTURE]]], "
				+ "Row [cells=["
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=APERTURE], "
					+ "Cell [left=WALL, right=APERTURE, up=APERTURE, down=APERTURE], "
					+ "Cell [left=APERTURE, right=WALL, up=APERTURE, down=APERTURE]]], "
				+ "Row [cells=["
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL], "
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL], "
					+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL]]]]]", grid.toString());
		
	}

}
