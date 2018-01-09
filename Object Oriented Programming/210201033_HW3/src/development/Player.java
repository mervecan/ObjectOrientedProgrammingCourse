package development;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Player {
	
	private Cell currentCell;
	private Row currentRow;
	
	public Player(Row currentRow,Cell currentCell) {
		setCurrentCell(currentCell);
		setCurrentRow(currentRow);
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	public Row getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
	
	
	
	
	
}
