import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.Board;
import domain.GameHandler;
import domain.IGameListener;
import ruleEngine.ChessGameRuleEngineFacede;
import utils.Tuple;
import view.IBoardDrawer;
import view.RawBoardDrawer;

public class MainInstance implements IGameListener{
	
	public boolean _gameFinished;
	public void play() throws IOException{
		_gameFinished = false;
		GameHandler.getInstance().register(this);
		System.out.println("Welcome to Chess program.");
		System.out.println("Enter your moves as:");
		System.out.println("	<current location of the piece> <new location of the piece>");
		System.out.println("For example enter `a2 a4` to move piece located at a2 to a4");
		System.out.println("Enter 'q' to quit.");
		System.out.println("Choose AI option. 1 - Random, 2 - MaxScore");

		String strategy = getInput();
		
		// start game
		GameHandler.getInstance().startGame(strategy);
		IBoardDrawer drawer = new RawBoardDrawer();

		drawer.drawBoard(Board.getInstance());

		while (true) {
			// get input
			System.out.print("move for white:");

			String input = getInput();

			if (ChessGameRuleEngineFacede.getInstance().isInputValid(input)) {
				if (input.equals("q")) {
					System.out.println("Bye...");
					return;
				}
				if (input.equals("undo")) {
					GameHandler.getInstance().undoMove();
					drawer.drawBoard(Board.getInstance());
					continue;
				}
				
				if(input.equals("redo")){
					GameHandler.getInstance().redoMove();
					drawer.drawBoard(Board.getInstance());
					continue;
				}				
				
				if(input.equals("p")){
					Tuple<String, String> aiMove = GameHandler.getInstance().makeMoveWithAi();
					System.out.println("move for black: " + aiMove.currentLoc + " " + aiMove.targetLoc);
					drawer.drawBoard(Board.getInstance());		
					if(_gameFinished){
						break;
					}
					continue;
				}
				
				String currentLoc = input.split(" ")[0];
				String targetLoc = input.split(" ")[1];

				if (GameHandler.getInstance().makeMove(currentLoc, targetLoc)) {
					drawer.drawBoard(Board.getInstance());
				} else {
					System.out.println("invalid move.");
					continue;
				}
				
				if(_gameFinished){
					break;
				}
				
				Tuple<String, String> aiMove = GameHandler.getInstance().makeMoveWithAi();
				System.out.println("move for black: " + aiMove.currentLoc + " " + aiMove.targetLoc);
				drawer.drawBoard(Board.getInstance());		
				if(_gameFinished){
					break;
				}
				
								

			} else {
				System.out.println("invalid input.");
			}

		}
		
		System.out.println("Game has ended");
		
	}
	
	private String getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return s;
	}
	@Override
	public void onGameFinished() {
		_gameFinished = true;
		
	}
	
	private void moveAi(){
		
		
	}
}
