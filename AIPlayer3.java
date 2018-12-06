public class AIPlayer3 implements Player{
//do not change the line above	
	
	//Define your fields here
	private Board gameB;
	private int ID;
	private int numRow;
	private int numCol;
	private int r = 0;
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer3(int playerID, int row, int col){
		gameB = new Board(row,col);
		numRow = row;
		numCol = col;
		ID = playerID;
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		gameB.play(3-ID,c);
	}
	
	//returns column of where to play a token
	public int playToken(){
		for(int row = 0; row<numRow; row++){
			int count = 0;
			for(int column = 1; column<numCol; column++){
				if(gameB.play(ID, column) == false){
					break;
				}
				if(gameB.getToken(row,column) != ' ' && gameB.getToken(row,column)==gameB.getToken(row,column-1)){
					return column+1;
				}
				if(gameB.getToken(0,column+1) != ' '){
					return column;		
			    }		
			    if(gameB.getToken(0,column) != ' '){
					return column-1;		
			    }	
			    
			}
		}
		return (int) Math.random();
	}
	
	public int getPlayerID(){
		return ID;
	}
	
	public void reset(){
		gameB = new Board();
	}


}