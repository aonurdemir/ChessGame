package domain.pieces;

import java.util.List;

import domain.Piece;
import domain.enums.Color;
import domain.enums.PieceName;
import utils.Tuple;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color, PieceName.Queen);
	}

	@Override
	public boolean isValidMove(char currenti, char currentj, char targeti, char targetj, boolean isTargetOccupied) {
		if (Math.abs(currenti - targeti) == Math.abs(currentj - targetj)) {
			return true;
		} else {
			if (currenti == targeti)
				return true;
			else if (currentj == targetj)
				return true;
		}
		return false;
	}

	

}
