package domain.pieces;

import java.util.ArrayList;
import java.util.List;

import domain.Piece;
import domain.enums.Color;
import domain.enums.PieceName;
import utils.Move;
import utils.Tuple;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color, PieceName.Pawn);
	}

	@Override
	public boolean isValidMove(char currenti, char currentj, char targeti, char targetj, boolean isTargetOccupied) {
		int forward = (_color == Color.White ? 1 : -1);
		int dx = 1;
		char base = _color == Color.White ? '2' : '7';

		if (!isTargetOccupied) {
			if (currentj == targetj) {
				if (currenti == base) {
					if (currenti + forward == targeti || currenti + forward + forward == targeti) {
						return true;
					}
				} else if (currenti + forward == targeti) {
					return true;
				}
			}
		} else {
			if (currenti + forward == targeti) {
				if (currentj + dx == targetj || currentj - dx == targetj) {
					return true;
				}
			}
		}

		return false;

	}

	

	

}
