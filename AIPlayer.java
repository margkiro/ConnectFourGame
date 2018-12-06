
public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private Board cfour;
	private char [][] copy;
	private int playerID;
	private int row;
	private int col;
	private int count = 0;
	private int play = 0;


	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		cfour = new Board(row,col);
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		cfour.play(3-playerID,c);
	}
	
	//returns column of where to play a token
	public int playToken(){
		count++;
		play = count % 7;
		if(play == 1){
			return 3;
		}else if (play ==2){
			return 2;
		}else if (play == 3){
			return 4;
		}else if(play ==4){
			return 1;
		}else if (play == 5){
			return 5;
		}else if (play == 6){
			return 0;
		}else if( play ==0){
			return 6;
		}
			return play;
		}

	
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		cfour = new Board(row, col);
	}

	public void copyBoard(){
		copy = new char [row][col];
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				char tok = cfour.getToken(i,j);
				copy[i][j] = cfour.getToken(i,j);
			}
		}

	}

}