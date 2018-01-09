package development.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import development.Cell;
import development.Player;
import development.Row;

public class TestPlayer {

	protected static Player player;
	
	private Cell currentCell;
	private Row currentRow;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestGrid.setUpBeforeClass();
		player = new Player(TestGrid.grid.getRows().get(2), 
							TestGrid.grid.getRows().get(2).getCells().get(2));
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		currentRow = TestGrid.grid.getRows().get(2);
		currentCell = TestGrid.grid.getRows().get(2).getCells().get(2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrentRow() {
		assertEquals(currentRow, player.getCurrentRow());		
	}
	
	@Test
	public void testGetCurrentCell() {		
		assertEquals(currentCell, player.getCurrentCell());
	}
	
	@Test
	public void testToString() {
		assertEquals("Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]", player.toString());
	}


}
