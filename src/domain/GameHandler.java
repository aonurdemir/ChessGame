package domain;

import java.util.Stack;

import commands.IGameCommand;
import commands.MoveCommand;
import domain.enums.Color;
import strategies.IPlayStrategy;
import strategies.MaxScoreStrategy;
import strategies.RandomPlayStrategy;
import utils.Tuple;

public class GameHandler {

	private static GameHandler _instance;
	private IGameListener _listener;
	
	private Player _humanPlayer;
	private Player _aiPlayer;
	private Player _currentPlayer;
	
	private Stack<IGameCommand> _undoCommandStack;
	private Stack<IGameCommand> _redoCommandStack;

	public static synchronized GameHandler getInstance() {
		if (_instance == null) {
			_instance = new GameHandler();
		}
		return _instance;
	}

	private GameHandler() {
		_undoCommandStack = new Stack<>();
		_redoCommandStack = new Stack<>();
		
	}
	public void register(IGameListener listener){
		_listener = listener;
	}

	public void startGame(String strategy) {
		IPlayStrategy strat = null;
		if(strategy.compareTo("1") == 0){
			strat = new RandomPlayStrategy();
		}
		else if(strategy.compareTo("2")== 0){
			strat = new MaxScoreStrategy();
		}
		
		_humanPlayer = new RealPlayer(Color.White);
		_aiPlayer = new AiPlayer(Color.Black, strat);
		_currentPlayer = _humanPlayer;
		Board.getInstance().init();
	}
	
	public void endGame(){
		_listener.onGameFinished();
	}

	public boolean makeMove(String currentLoc, String targetLoc) {
		char currenti = currentLoc.charAt(1);
		char currentj = currentLoc.charAt(0);
		char targeti = targetLoc.charAt(1);
		char targetj = targetLoc.charAt(0);

		IGameCommand moveCommand = new MoveCommand(_currentPlayer, currenti, currentj, targeti, targetj);
		boolean success = moveCommand.execute();
		if (success) {
			changeTurn();
			_undoCommandStack.push(moveCommand);
			_redoCommandStack.clear();
		}
		return success;
	}
	
	public void undoMove(){
		IGameCommand move = _undoCommandStack.pop();
		move.undo();
		_redoCommandStack.push(move);
		changeTurn();
	}
	
	public void redoMove(){
		IGameCommand move = _redoCommandStack.pop();
		move.execute();
		_undoCommandStack.push(move);
		changeTurn();
	}

	public Tuple<String, String> makeMoveWithAi() {

		Tuple<String, String> move = _aiPlayer.getMove();
		makeMove(move.currentLoc, move.targetLoc);				
		return move;

	}

	private void changeTurn() {
		if (_currentPlayer.getColor() == Color.White) {
			_currentPlayer = _aiPlayer;
		} else {
			_currentPlayer = _humanPlayer;
		}
	}

}