package development;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Cell {
	private CellComponents up;
	private CellComponents down;
	private CellComponents right;
	private CellComponents left;
	
	
	public Cell(CellComponents left, CellComponents right ,CellComponents up, CellComponents down ) {
			setUp(up);
			setDown(down);
			setRight(right);
			setLeft(left);
	}
	
	public Cell() {
		
	}
	
	public CellComponents getUp() {
		return up;
	}
	public void setUp(CellComponents up) {
		if(up==null) {
			this.up=CellComponents.WALL;
		}else {
			this.up = up;
		}
	}
	public CellComponents getDown() {
		return down;
	}
	public void setDown(CellComponents down) {
		if(down==null) {
			this.down=CellComponents.WALL;
		}else {
		this.down = down;
		}
	}
	public CellComponents getRight() {
		return right;
	}
	public void setRight(CellComponents right) {
		if(right==null) {
			this.right=CellComponents.WALL;
		}else {
		this.right = right;
		}
	}
	public CellComponents getLeft() {
			return left;
	}
	public void setLeft(CellComponents left) {
		if(left==null) {
			this.left=CellComponents.WALL;
		}else {
		this.left = left;
		}
	}

	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}

	
	
		

}
