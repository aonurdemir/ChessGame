package domain;

import domain.enums.Color;
import strategies.IPlayStrategy;
import utils.Tuple;

public class AiPlayer extends Player{
	
	private IPlayStrategy _playStrategy;
	
	public AiPlayer(Color color,IPlayStrategy playStrategy) {
		super(color);
		_playStrategy = playStrategy;	
	}	
	
	public Tuple<String, String> getMove() {
		
		return _playStrategy.getMove(Board.getInstance(), _color);
	}
	
	
	
	

}
