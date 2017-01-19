package domain;

import domain.enums.Color;
import domain.pieces.Bishop;
import domain.pieces.King;
import domain.pieces.Knight;
import domain.pieces.Pawn;
import domain.pieces.Queen;
import domain.pieces.Rook;

public class PieceFactory {

	private static PieceFactory _instance;

	public static synchronized PieceFactory getInstance() {
		if (_instance == null) {
			_instance = new PieceFactory();
		}
		return _instance;
	}

	private PieceFactory() {
	}
	
	public Piece getPawn(Color color) {
		return new Pawn(color);
	}

	public Piece getRook(Color color) {
		return new Rook(color);
	}

	public Piece getKnight(Color color) {
		return new Knight(color);
	}

	public Piece getBishop(Color color) {
		return new Bishop(color);
	}

	public Piece getQueen(Color color) {
		return new Queen(color);
	}

	public Piece getKing(Color color) {
		return new King(color);
	}

}
