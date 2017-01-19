package strategies;

import java.util.List;

import domain.Board;
import domain.enums.Color;
import utils.Move;
import utils.Tuple;

public class MaxScoreStrategy implements IPlayStrategy {

	@Override
	public Tuple<String, String> getMove(Board board, Color playerColor) {

		List<Move> moves = board.getPossibleMoves(playerColor);
		int maxScore = 0;
		Move move = null;
		for (int i = 0; i < moves.size(); i++) {
			if (moves.get(i).getScore() >= maxScore) {
				move = moves.get(i);
				maxScore = move._score;
			}
		}

		if (move != null) {
			return new Tuple<String, String>("" + move._currentj + move._currenti, "" + move._targetj + move._targeti);
		}
		return null;
		
	}

}
