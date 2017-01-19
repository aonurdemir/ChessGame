package utils;

public class Move {

	public char _currenti;
	public char _currentj;
	public char _targeti;
	public char _targetj;

	public int _score;

	public Move(char currenti, char currentj,char targeti, char targetj, int score) {
		_currenti = currenti;
		_currentj = currentj;
		_targeti = targeti;
		_targetj = targetj;
		_score = score;	
	}
	
	public int getScore(){
		return _score;
	}
}
