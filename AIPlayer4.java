
public class AIPlayer4 implements Player{
//do not change the line above	
	
	//Define your fields here
	private Board cfour;
	private Board copy;
	private int playerID;
	private int row;
	private int col;

	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer4(int playerID, int row, int col){
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
		copy = cfour;
		for(int i = row-1; i>0; i--){
			for(int j = 0; j<col; j++){
				if(copy.play(playerID,j) ==false){
					copy = cfour;
					break;
				}
				copy.play(playerID,j);
				int win = copy.isFinished(); 
				if(win != playerID){
					copy = cfour;
					break;
				}
				else{
					if(copy.getToken(0,j) != ' '){
						copy = cfour;
						break;
					}
					else{
					return j;
					}
				}
				
			}
		}
		return (int) Math.random();
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
		int playe;
		copy = new Board(row,col);
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				char tok = cfour.getToken(i,j);
				if(tok == cfour.getPlayerOne()){
					playe = 1;
				}else{
					playe = 2;
				}
				copy.play(playe,j);
			}
		}

	}
	
}