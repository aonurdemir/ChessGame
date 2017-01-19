import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.Board;
import domain.GameHandler;
import domain.IGameListener;
import ruleEngine.ChessGameRuleEngineFacede;
import strategies.IPlayStrategy;
import utils.Tuple;
import view.IBoardDrawer;
import view.RawBoardDrawer;

public class Main {

	
	
	public static void main(String[] args) throws IOException {
		new MainInstance().play();
	}

	

	

}
