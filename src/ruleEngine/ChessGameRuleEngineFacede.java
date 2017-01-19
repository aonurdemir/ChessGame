package ruleEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChessGameRuleEngineFacede {
	
	private static ChessGameRuleEngineFacede _instance;
	
	private ChessGameRuleEngineFacede(){
		
	}
	
	public static ChessGameRuleEngineFacede getInstance(){
		if(_instance == null){
			_instance = new ChessGameRuleEngineFacede();
		}
		return _instance;		
	}
	
	public boolean isInputValid(String input){
		String pattern = "[a-h][1-8] [a-h][1-8]|q|undo|redo|p";
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(input);
		return m.find();
	}	

}
