package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.enums.Color;
import domain.enums.PieceName;
import utils.Move;

public class Board {

	private static Board _instance;
	private Map<Character, Map<Character, Square>> _squares;
	private List<Square> _squareList;
	private MoveState _lastMoveState;

	public static synchronized Board getInstance() {
		if (_instance == null) {
			_instance = new Board();
		}
		return _instance;
	}

	private Board() {
	}

	public void init() {
		createSquares();
	}

	public List<Move> getPossibleMoves(Color playerColor) {
		List<Move> moves = new ArrayList<>();

		for (int i = 0; i < _squareList.size(); i++) {
			Square currentSquare = _squareList.get(i);
			for (int j = 0; j < _squareList.size(); j++) {
				Square targetSquare = _squareList.get(j);
				if (isValidMove(currentSquare.geti(), currentSquare.getj(), targetSquare.geti(), targetSquare.getj(),
						playerColor)) {
					Move move = new Move(currentSquare.geti(),currentSquare.getj(),targetSquare.geti(), targetSquare.getj(),
							getScore(targetSquare.getPieceName()));
					moves.add(move);
				}
			}
		}

		return moves;

	}

	public boolean makeMove(char currenti, char currentj, char targeti, char targetj, Color playerColor) {
		if (!isValidMove(currenti, currentj, targeti, targetj, playerColor)) {
			return false;
		} else {
			Square currentSquare = _squares.get(currenti).get(currentj);
			Square targetSquare = _squares.get(targeti).get(targetj);
			
			_lastMoveState = new MoveState(currentSquare.getPiece(), targetSquare.getPiece());
			
			PieceName targetPieceName = targetSquare.getPieceName();
			currentSquare.movePiece(targetSquare);
			
			if(targetPieceName== PieceName.King){
				GameHandler.getInstance().endGame();
			}
			
			return true;
		}
	}
	
	public void undoMove(char currenti, char currentj, char targeti, char targetj,MoveState lastMoveState){
		Square currentSquare = _squares.get(currenti).get(currentj);
		Square targetSquare = _squares.get(targeti).get(targetj);	
		
		currentSquare.putPiece(lastMoveState._pieceAtCurrentSquare);
		targetSquare.putPiece(lastMoveState._pieceAtTargetSquare);	
		
	}

	public MoveState getLastMoveState(){
		return _lastMoveState;
	}
	public Color getSquareColor(char i, char j) {
		return _squares.get(i).get(j).getColor();
	}

	public Color getPieceColor(char i, char j) {
		return _squares.get(i).get(j).getPieceColor();
	}

	public PieceName getPieceName(char i, char j) {
		return _squares.get(i).get(j).getPieceName();
	}

	private boolean isValidMove(char currenti, char currentj, char targeti, char targetj, Color playerColor) {
		if (currenti == targeti && currentj == targetj) {
			return false;
		} else if (!isInsideBoard(currenti, currentj, targeti, targetj)) {
			return false;
		} else {
			Square currentSquare = _squares.get(currenti).get(currentj);
			Square targetSquare = _squares.get(targeti).get(targetj);
			if (currentSquare.getPieceColor() != playerColor) {
				return false;
			}
			if (currentSquare.getPieceColor() != targetSquare.getPieceColor()) {
				return currentSquare.isValidMove(targetSquare);
			}
			return false;
		}
	}

	private boolean isInsideBoard(char currenti, char currentj, char targeti, char targetj) {

		return currenti >= '1' && currenti <= '8' && targeti >= '1' && targeti >= '1' && currentj >= 'a'
				&& currentj <= 'h' && targetj >= 'a' && targetj <= 'h';
	}

	private int getScore(PieceName pieceName) {
		if(pieceName == null){
			return 0;
		}
		switch (pieceName) {
		case Bishop:
			return 3;
		case King:
			return 200;
		case Knight:
			return 3;
		case Pawn:
			return 1;
		case Queen:
			return 9;
		case Rook:
			return 5;
		}
		return 0;

	}

	private void createSquares() {
		_squares = new HashMap<>();
		_squareList = new ArrayList<>();

		for (char i = '1'; i <= '8'; i++) {
			Map<Character, Square> map = new HashMap<>();

			for (char j = 'a'; j <= 'h'; j++) {
				Square square = new Square(i, j);
				map.put(j, square);
				_squareList.add(square);
			}

			_squares.put(i, map);

		}
	}

}
