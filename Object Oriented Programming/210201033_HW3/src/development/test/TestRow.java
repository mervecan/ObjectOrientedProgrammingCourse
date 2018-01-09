package development.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import development.Cell;
import development.CellComponents;
import development.Row;

public class TestRow {
	
	private Cell cell0;
	private Cell cell1;
	private Cell cell2;
	
	private Row row;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		cell0 = new Cell(CellComponents.EXIT, CellComponents.APERTURE,
				CellComponents.WALL, CellComponents.APERTURE);
		
		cell1 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);
		
		cell2 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.WALL, CellComponents.APERTURE);
		
		ArrayList<Cell> cells = new ArrayList<>();
		
		cells.add(cell0);
		cells.add(cell1);
		cells.add(cell2);
		
		row = new Row(cells);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCellsSize() {
		
		assertEquals(3, row.getCells().size());
	}
	
	@Test
	public void testGetCells() {
		
		assertEquals(cell0, row.getCells().get(0));
		assertEquals(cell1, row.getCells().get(1));
		assertEquals(cell2, row.getCells().get(2));
	}
	
	@Test
	public void testSetCells() {
		
		Cell cell3 = new Cell(CellComponents.WALL, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell4 = new Cell(CellComponents.WALL, CellComponents.APERTURE,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		Cell cell5 = new Cell(CellComponents.APERTURE, CellComponents.WALL,
				CellComponents.APERTURE, CellComponents.APERTURE);
		
		ArrayList<Cell> cellList = new ArrayList<>();
		cellList.add(cell3);
		cellList.add(cell4);
		cellList.add(cell5);
		row.setCells(cellList);
		
		assertEquals(cellList, row.getCells());
	
		row.setCells(null);
		assertEquals("Given cells cannot be null!", null, row.getCells());
		
	}
	
	@Test
	public void testToString() {
		
		assertEquals("Row [cells=["
							+ "Cell [left=EXIT, right=APERTURE, up=WALL, down=APERTURE], "
							+ "Cell [left=APERTURE, right=WALL, up=WALL, down=APERTURE], "
							+ "Cell [left=WALL, right=WALL, up=WALL, down=APERTURE]]]", row.toString());
	}
	
}
