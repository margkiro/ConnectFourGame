
public class AIPlayer2 implements Player{
//do not change the line above	
	
	//Define your fields here
	private static Board cfour;
	private Board copy;
	private int playerID;
	private int row;
	private int col;
	private int count = 0;
	private int play = 0;

	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer2(int playerID, int row, int col){
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
		//copyBoard();
		//int j = 0;
		//int win = 5;
			/*while(copy.play(playerID,j)==false || (j+1)<col){
				j++;
			}
				copy.play(playerID,j);
				int win = copy.isFinished(); 
				if(win != playerID && (j+1)<col){
					j++;
					break;
				}
				else{
					return j;
				}
				*/
		/*for(int j = 0; j<col; j++){
			while(true){
			//for(j<col){
				if(copy.play(playerID,j) ==false){
					break;
				}
				copy.play(playerID,j);
				int win = copy.isFinished(); 
				if(win != playerID){
					break;
				}
				else if(win == playerID){
					return j;
				}
			}

			//}
			
		}
		*/
		/*int j = 0;
		while(copy.play(playerID,j)==false || j<col){
			j++;
			copy.play(playerID,j);
			int win = copy.isFinished(); 
			while(win != playerID && copy.play(playerID,j)==false || j<col){
				j++;
				copy.play(playerID,j);
				//while()
				return j;
			}
		}
		*/
		/*int column = (int) (Math.random()*7);
		while(column<0 || column>=col || copy.play(playerID,column) == false){
			column = (int) (Math.random() * 7);
		}
		return column;
		*/
		/*int j = 0;
		while(copy.play(playerID,j)==false && j<col){
			j++;
			copy.play(playerID,j);
		}
		while(copy.isFinished() != playerID && j<col){
			j++;
			copy.play(playerID,j);
			while(copy.play(playerID,j)==false){
				j++;
				break;
			}
			return j;
		}
		*/
		//copy = cfour;
		copyBoard();
		int pos = -1;
		for(int i = 0; i<row; i++){
			//copy = cfour;
			copyBoard();
			for(int j = pos+1; j<col; j++){
				if(copy.getToken(0,j) != ' '){
					pos = j;
					break;
				}
				copy.play(playerID,j);
				int win = copy.isFinished(); 
				if(win != playerID){
					pos = j;
					break;
				}
				else{
					return j;
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
		//copy = cfour;
		copy = new Board(row,col);
		for(int i = row-1; i>=0; i--){
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