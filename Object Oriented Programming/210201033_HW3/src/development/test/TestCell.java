package development.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import development.Cell;
import development.CellComponents;

public class TestCell {
	
	protected Cell cellGetterComponents;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		cellGetterComponents = new Cell(CellComponents.WALL, 
									CellComponents.EXIT, 
									CellComponents.APERTURE, 
									CellComponents.WALL);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetters() {
		// left right up down
		
		assertEquals(CellComponents.WALL, cellGetterComponents.getLeft());
		assertEquals(CellComponents.EXIT, cellGetterComponents.getRight());
		assertEquals(CellComponents.APERTURE, cellGetterComponents.getUp());
		assertEquals(CellComponents.WALL, cellGetterComponents.getDown());
		
	}
	
	@Test
	public void testToString() {

		assertEquals("Cell [left=" + cellGetterComponents.getLeft() + ", right=" + cellGetterComponents.getRight() + ", up=" + cellGetterComponents.getUp() + ", down=" + cellGetterComponents.getDown() + "]", cellGetterComponents.toString());
		
	}
	
	@Test
	public void testSetters() {

		Cell cellSetterComponents = new Cell(CellComponents.WALL, 
											CellComponents.EXIT, 
											CellComponents.APERTURE, 
											CellComponents.WALL);
		
		cellSetterComponents.setLeft(CellComponents.APERTURE);
		cellSetterComponents.setRight(CellComponents.APERTURE);
		cellSetterComponents.setUp(CellComponents.WALL);
		cellSetterComponents.setDown(CellComponents.EXIT);
		
		assertEquals(CellComponents.APERTURE, cellSetterComponents.getLeft());
		assertEquals(CellComponents.APERTURE, cellSetterComponents.getRight());
		assertEquals(CellComponents.WALL, cellSetterComponents.getUp());
		assertEquals(CellComponents.EXIT, cellSetterComponents.getDown());
		
		cellSetterComponents.setLeft(null);
		cellSetterComponents.setRight(null);
		cellSetterComponents.setUp(null);
		cellSetterComponents.setDown(null);
		
		assertEquals(CellComponents.WALL, cellSetterComponents.getLeft());
		assertEquals(CellComponents.WALL, cellSetterComponents.getRight());
		assertEquals(CellComponents.WALL, cellSetterComponents.getUp());
		assertEquals(CellComponents.WALL, cellSetterComponents.getDown());
		
		
		
		
	}
	

}
