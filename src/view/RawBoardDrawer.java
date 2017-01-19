package view;

import domain.Board;
import domain.enums.Color;
import domain.enums.PieceName;

public class RawBoardDrawer implements IBoardDrawer{

	@Override
	public void drawBoard(Board board) {
		drawLetterRow();
		drawLine();                   
        
        for(char i='8'; i>='1'; i--){
        	System.out.print(""+i+" |");
        	for(char j='a'; j<='h'; j++){
        		String name;
        		PieceName pname = board.getPieceName(i,j);
        		if(pname == null){
        			name = board.getSquareColor(i, j) == Color.White ? " " : ".";
        		}
        		else{
        			name = pieceNameConverter(pname, board.getPieceColor(i, j));	
        		}
        		
        		System.out.print(" "+name+" |");
        	}
        	System.out.println(" "+i);
        	drawLine();
        }
        drawLetterRow();
	}
	private void drawLetterRow(){
		   System.out.print("  ");
	        for(char i='a'; i<='h'; i++){
	        	System.out.print("  "+i+" ");
	        }
	        System.out.println("  ");
	}
	private void drawLine(){
		 System.out.print("  ");
	        String line= "+---";
	        for(int i=0; i<8; i++){
	        	System.out.print(line);
	        }
	        System.out.println("+"); 
	}
	
	private String pieceNameConverter(PieceName pname,Color color){
	
		String name = " ";
		if(pname == PieceName.Bishop){
			name = "b";
		}
		else if(pname == PieceName.King){
			name = "k";
		}
		else if(pname == PieceName.Knight){
			name = "n";
		}
		else if(pname == PieceName.Pawn){
			name = "i";
		}
		else if(pname == PieceName.Queen){
			name = "q";
		}
		else if(pname == PieceName.Rook){
			name = "r";
		}
		return color == Color.White ? name.toUpperCase() : name;	
	}
	

}
