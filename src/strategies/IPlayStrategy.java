package strategies;

import domain.Board;
import domain.enums.Color;
import utils.Tuple;

public interface IPlayStrategy {
	
	public Tuple<String, String> getMove(Board board, Color playerColor);

}
