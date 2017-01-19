package domain.pieces;

import java.util.List;

import domain.Piece;
import domain.enums.Color;
import domain.enums.PieceName;
import utils.Tuple;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color, PieceName.Knight);
	}

	@Override
	public boolean isValidMove(char currenti, char currentj, char targeti, char targetj, boolean isTargetOccupied) {
		int forward = (_color == Color.White ? 1 : -1);
		int backward =  (_color == Color.White ? -1 : 1);
		int right = 1;
		int left =  -1;

		if (targeti == currenti + 2 * forward || targeti == currenti - 2 * backward) {
			if (targetj == currentj + left || targetj == currentj + right) {
				return true;
			}
		} else if (targeti == currenti + forward || targeti == currenti - backward) {
			if (targetj == currentj + 2 * left || targetj == currentj + 2 * right) {
				return true;
			}
		}
		return false;
	}


}
