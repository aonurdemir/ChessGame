package strategies;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import domain.Board;
import domain.GameHandler;
import domain.Piece;
import domain.enums.Color;
import ruleEngine.ChessGameRuleEngineFacede;
import utils.Move;
import utils.Tuple;

public class RandomPlayStrategy implements IPlayStrategy {	
	

	@Override
	public Tuple<String, String> getMove(Board board, Color playerColor) {	
		List<Move> moves = board.getPossibleMoves(playerColor);
		int rand = ThreadLocalRandom.current().nextInt(0,moves.size());
		Move move = moves.get(rand);
		
		if (move != null) {
			return new Tuple<String, String>("" + move._currentj + move._currenti, "" + move._targetj + move._targeti);
		}
		return null;
//		while (true) {
//			String move = generateInput();
//			
//			if (ChessGameRuleEngineFacede.getInstance().isInputValid(move)) {
//				// input="h2 h4";
//				String currentLoc = move.split(" ")[0];
//				String targetLoc = move.split(" ")[1];
//				
//				return new Tuple<String, String>(currentLoc, targetLoc);
//			}
//		}
	}
	
	private static String generateInput() {
		String input = "";
		char i = (char) ThreadLocalRandom.current().nextInt('1', '8' + 1);
		char j = (char) ThreadLocalRandom.current().nextInt('a', 'h' + 1);
		input = input + j + i + " ";

		i = (char) ThreadLocalRandom.current().nextInt('1', '8' + 1);
		j = (char) ThreadLocalRandom.current().nextInt('a', 'h' + 1);

		input = input + j + i;
		return input;

	}	

}
