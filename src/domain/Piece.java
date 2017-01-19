package domain;

import java.util.List;

import domain.enums.Color;
import domain.enums.PieceName;
import utils.Move;

public abstract class Piece {
	protected Color _color;
	protected PieceName _name;	

	public Piece(Color color,PieceName name) {		
		_color = color;
		_name = name;
	}	

	public Color getColor(){
		return _color;
	}
	
	public PieceName getName(){
		return _name;
	}	

	public abstract boolean isValidMove(char currenti,char currentj,char targeti, char targetj, boolean isTargetOccupied);	
	
}
