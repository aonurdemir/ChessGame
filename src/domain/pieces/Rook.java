package domain.pieces;

import java.util.List;

import domain.Piece;
import domain.enums.Color;
import domain.enums.PieceName;
import utils.Tuple;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color, PieceName.Rook);
	}

	@Override
	public boolean isValidMove(char currenti, char currentj, char targeti, char targetj, boolean isTargetOccupied) {
		if (currenti == targeti)
			return true;
		else if (currentj == targetj)
			return true;
		else
			return false;
	}

	

}
