package development.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import development.CellComponents;
import development.Game;
import development.Grid;
import development.Movement;

public class TestGame {

	private Game game;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestGrid.setUpBeforeClass();
		TestPlayer.setUpBeforeClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		game = new Game(TestGrid.grid);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetGrid() {
		
		assertEquals(TestGrid.grid, game.getGrid());
		
	}
	
	@Test
	public void testPlay() {
		
		assertEquals(true, game.play(Movement.UP, TestPlayer.player));
		
		// Invalid movement
		assertEquals(false, game.play(Movement.RIGHT, TestPlayer.player));
		
		assertEquals(true, game.play(Movement.DOWN, TestPlayer.player));
		
		// Invalid movement
		assertEquals(false, game.play(Movement.DOWN, TestPlayer.player));
		
		assertEquals(true, game.play(Movement.UP, TestPlayer.player));
		assertEquals(true, game.play(Movement.LEFT, TestPlayer.player));
		assertEquals(true, game.play(Movement.RIGHT, TestPlayer.player));
		assertEquals(true, game.play(Movement.LEFT, TestPlayer.player));
		assertEquals(false, game.play(Movement.LEFT, TestPlayer.player));
		assertEquals(true, game.play(Movement.UP, TestPlayer.player));
		assertEquals(false, game.play(Movement.UP, TestPlayer.player));
		assertEquals(true, game.play(Movement.LEFT, TestPlayer.player));
		
		// Expected the agent to escape the maze
		assertEquals(true, game.play(Movement.LEFT, TestPlayer.player));
		
		
	}
	
	@Test
	public void testSetGrid() {
		game.setGrid(null);
		assertEquals("Given grid cannot be null!", null, game.getGrid());
	}
	
	@Test
	public void testToString() {
		
		assertEquals("Game [grid="
						+ "Grid [rows=["
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
								+ "Cell [left=WALL, right=WALL, up=APERTURE, down=WALL]]]]]]", game.toString());
		
	}
	
	@Test
	public void testCreateGrid() {
		
		int gridSize = game.createGrid().getRows().size();
		

		for(int i=0; i<gridSize; i++) {
			for(int j=0; j<gridSize; j++) {
				
				boolean flag = false;
				
				if(game.createGrid().getRows().get(j).getCells().get(i).getDown().equals(CellComponents.APERTURE))
					flag = true;
				else if(game.createGrid().getRows().get(j).getCells().get(i).getUp().equals(CellComponents.APERTURE))
					flag = true;
				else if(game.createGrid().getRows().get(j).getCells().get(i).getLeft().equals(CellComponents.APERTURE))
					flag = true;
				else if(game.createGrid().getRows().get(j).getCells().get(i).getRight().equals(CellComponents.APERTURE))
					flag = true;
				
				assertEquals(true, flag);
			}
		}
		
		boolean checkExit = false;
		
		for(int i=0; i<gridSize; i++) {
			for(int j=0; j<gridSize; j++) {
				if(game.createGrid().getRows().get(j).getCells().get(i).getDown().equals(CellComponents.EXIT))
					checkExit = true;
				else if(game.createGrid().getRows().get(j).getCells().get(i).getUp().equals(CellComponents.EXIT))
					checkExit = true;
				else if(game.createGrid().getRows().get(j).getCells().get(i).getLeft().equals(CellComponents.EXIT))
					checkExit = true;
				else if(game.createGrid().getRows().get(j).getCells().get(i).getRight().equals(CellComponents.EXIT))
					checkExit = true;
			}
		}
		
		assertEquals(true, checkExit);
		

	}

}
