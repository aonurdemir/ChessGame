package domain;

import java.util.List;

import domain.enums.Color;
import utils.Tuple;

public abstract class Player {

	protected Color _color;
	public Player(Color color){
		_color = color;
	}
	
	public Color getColor(){
		return _color;
	}	
	
	public boolean makeMove(char currenti, char currentj,char targeti,char targetj){
		
		boolean success = Board.getInstance().makeMove(currenti, currentj, targeti, targetj, _color);				
		return success;		
	}
	
	public void undoMove(char currenti, char currentj, char targeti, char targetj,MoveState lastMoveState){
		Board.getInstance().undoMove(currenti, currentj, targeti, targetj, lastMoveState);
	}
	
	public abstract Tuple<String, String> getMove();
}
