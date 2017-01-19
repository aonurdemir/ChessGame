package domain;

public class MoveState {

	public Piece _pieceAtCurrentSquare;
	public Piece _pieceAtTargetSquare;
	
	public MoveState(Piece pieceAtCurrentSquare,Piece pieceAtTargetSquare){
		_pieceAtCurrentSquare = pieceAtCurrentSquare;
		_pieceAtTargetSquare = pieceAtTargetSquare;
	}
}
