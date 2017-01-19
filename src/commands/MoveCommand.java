package commands;

import domain.Board;
import domain.MoveState;
import domain.Player;

public class MoveCommand implements IGameCommand {

	Player _player;
	char _currenti;
	char _currentj;
	char _targeti;
	char _targetj;
	MoveState _lastMoveState;
	
	public MoveCommand(Player player,char currenti,char currentj,char targeti,char targetj){
		_player = player;
		_currenti = currenti;
		_currentj = currentj;
		_targeti = targeti;
		_targetj = targetj;
		
	}
	@Override
	public boolean execute() {		
		boolean isSuccess = _player.makeMove(_currenti, _currentj, _targeti, _targetj);
		if(isSuccess){
			_lastMoveState = Board.getInstance().getLastMoveState();
		}
		return isSuccess;
		
		
		
	}

	@Override
	public void undo() {
		_player.undoMove(_currenti, _currentj, _targeti, _targetj, _lastMoveState);			
	}

}
