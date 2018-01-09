package development;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class App {

	public static void main(String[] args) {
		Game game = new Game();
		game.createGrid();
		Player player = new Player(game.createGrid().getRows().get(0),game.createGrid().getRows().get(0).getCells().get(0));
		
		
	}
	
}
