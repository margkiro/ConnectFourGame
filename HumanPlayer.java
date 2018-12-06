public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	private static Board myBoard;
	private int playerID;
	private int row;
	private int col;
	private int column;
	
	
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col){
		this.playerID = playerID;
		this.row = row;
		this.col = col;
		myBoard = new Board(row,col);
	}
	
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {

		myBoard.play(3-playerID,c);

	}
	
	//returns column of where to play a token
	public int playToken(){
		column = IO.readInt();
		while(column<0 || column >= col || myBoard.play(playerID, column) == false){
			System.out.println("Enter a valid number or it is full:");
			column = IO.readInt();
		}

		/*while(){
			System.out.println("Column full, please enter another value:");
			column = IO.readInt();
		}
		/*while(myBoard.getToken(0,column) != ' '){
		///while(myBoard.getToken(0,column) == myBoard.getPlayerOne() || myBoard.getToken(0,column) == myBoard.getPlayerTwo()){
			System.out.println("Column full, please enter another value:");
			column = IO.readInt();
		}
		*/

		return column;
	}
	
	//get this player's id
	public int getPlayerID(){
		return playerID;
	}
	
	//resets the state of the player in preparation for a new game
	public void reset(){
		myBoard = new Board(row, col);
	}


	
}