public class ConnectFour{
	
	
	public static void main(String[] args){
		
		//Create new board object
		Board test = new Board();
		CFGUI board = new CFGUI(test,ChipColor.RED,ChipColor.GREEN);


		//Set player tokens for player 1 and player 2
		//test.setPlayerOne('*');
		//test.setPlayerTwo('o');
		//Create Player objects

		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		
		Player p1 = new HumanPlayer(1,6,7);
		Player p2 = new HumanPlayer(2,6,7); //comment this line when testing AIPlayer
		
		//Player p2 = new AIPlayer(2,6,7); //uncomment this line when testing AIPlayer
		
		
		//Print your empty board
		
		test.printBoard();
		
		while(test.isFinished() == -1){
		//WHILE the board is still playable
		//	get a column to play from player 1
			int col = p1.playToken();
			p2.lastMove(col);
		//	play that token on the board
			System.out.println(test.play(1,col));
		//  print the board
			test.printBoard();
			board.redraw();
		//		has anyone won yet?
			int win = test.isFinished();
			if(win != -1){
				board.gameOver(win);
				board.close();
			}
			//System.out.println("winner: " + test.isFinished());
			//if(test.isFinished() != -1){
				//break;
			//}
		 	/*if(test.isFinished() == 1 || test.isFinished() == 2){
				System.out.println("true, winner is: " + test.isFinished());
				//p1.reset();
			}else{
				System.out.println("false");
			}*/
		// do the above for player 2
			System.out.println("\n");

			int col2 = p2.playToken();
			System.out.println(col2);
			p1.lastMove(col2);

			System.out.println(test.play(2,col2));
			board.redraw();
				win = test.isFinished();
			if(win != -1){
				board.gameOver(win);
				board.close();
			}
			test.printBoard();
			/*if(test.isFinished() == 1 || test.isFinished() == 2){
			System.out.println("true, winner is: " + test.isFinished());
				//p2.reset();
			}else{
			System.out.println("false");
			}*/
		}
		
		// Get the status code from the board (isFinished())
		
		// Print out the results of the game
		
		
	}
	
}