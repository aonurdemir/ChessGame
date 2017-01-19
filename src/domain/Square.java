package domain;

import java.util.List;

import domain.enums.Color;
import domain.enums.PieceName;
import utils.Move;

public class Square {

	private char _i, _j;
	private Color _color;
	private Piece _piece;

	public Square(char i, char j) {
		_i = i;
		_j = j;
		setColor(i, j);
		initPiece(i, j);
	}		
	
		
	public void movePiece(Square targetSquare) {
	
		targetSquare.putPiece(_piece);
		_piece = null;
	}

	public void putPiece(Piece piece) {
		_piece = piece;		
	}
	
	public Piece getPiece(){		
		return _piece;
	}
	
	public boolean isValidMove(Square target){
		return _piece.isValidMove(_i, _j, target.geti(), target.getj(), target.isOccupied());
	}

	public Color getColor() {
		return _color;
	}

	public Color getPieceColor() {
		if (_piece != null)
			return _piece.getColor();
		else
			return null;
	}

	public PieceName getPieceName() {
		if (_piece != null)
			return _piece.getName();
		else
			return null;
	}

	public char geti() {
		return _i;
	}

	public char getj() {
		return _j;
	}

	private boolean isOccupied(){
		return _piece != null;
	}
	private void setColor(char i, char j) {

		char ioffset = '1';
		char joffset = 'a';
		int color = (i - ioffset + j - joffset) % 2;
		_color = color == 0 ? Color.Black : Color.White;

	}

	private void initPiece(char i, char j) {
		Color pieceColor = i < '4' ? Color.White : Color.Black;

		switch ("" + j + i) {
		case "a2":
		case "b2":
		case "c2":
		case "d2":
		case "e2":
		case "f2":
		case "g2":
		case "h2":

		case "a7":
		case "b7":
		case "c7":
		case "d7":
		case "e7":
		case "f7":
		case "g7":
		case "h7":
			_piece = PieceFactory.getInstance().getPawn(pieceColor);
			break;
		case "a1":
		case "a8":
		case "h1":
		case "h8":
			_piece = PieceFactory.getInstance().getRook(pieceColor);
			break;
		case "b1":
		case "b8":
		case "g1":
		case "g8":
			_piece = PieceFactory.getInstance().getKnight(pieceColor);
			break;
		case "c1":
		case "c8":
		case "f1":
		case "f8":
			_piece = PieceFactory.getInstance().getBishop(pieceColor);
			break;
		case "d1":
		case "d8":
			_piece = PieceFactory.getInstance().getQueen(pieceColor);
			break;
		case "e1":
		case "e8":
			_piece = PieceFactory.getInstance().getKing(pieceColor);
			break;
		}
	}

}
