package domain.pieces;

import java.util.List;

import domain.Piece;
import domain.enums.Color;
import domain.enums.PieceName;
import utils.Tuple;

public class King extends Piece {

	public King(Color color) {
		super(color, PieceName.King);
	}

	@Override
	public boolean isValidMove(char currenti, char currentj, char targeti, char targetj, boolean isTargetOccupied) {
		int forward =  (_color == Color.White ? 1 : -1);
		int backward =  (_color == Color.White ? -1 : 1);
		int right = 1;
		int left =  -1;

		if (targeti == currenti + backward || targeti == currenti + forward || targeti == currenti) {
			if (targetj == currentj + left || targetj == currentj + right || targetj == currentj) {
				return true;
			}
		}
		return false;

	}



}
