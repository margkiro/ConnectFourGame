public class Board{

	private char [][] board;
	private char player1 = 'm';
	private char player2 = 'n';
	private int numRow;
	private int numCol;
	
	public Board(){
		board = new char [6][7];
		numRow = 6;
		numRow = 7;
		for(int i = 0; i<6; i++){
			for(int j = 0; j<7; j++){
				board[i][j]=' ';
			}
		}	
	}

	public Board(int row,int col){
		board = new char[row][col];
		numRow = row;
		numCol = col;
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				board[i][j]=' ';
			}
		}
	}

	public int getNumRows(){
		return board.length;
	}

	public int getNumCols(){
		return board[0].length;
	}

	public char getPlayerOne(){
		return player1;
	}

	public char getPlayerTwo(){
		return player2;
	}

	public void setPlayerOne(char o){
		if(o == player2){
			return;
		}
		player1 = o;
	}

	public void setPlayerTwo(char t){
		if(t == player1){
			return;
		}
		player2 = t;
	}

	public char getToken(int row, int col){
		try{
			return this.board[row][col];
		}catch(ArrayIndexOutOfBoundsException ex){
			return '\0';
		}
		/*if(row >= board.length || col >=board[0].length){
			return '\0';
		}
		if(row<0 || col<0){
			return '\0';
		}
		return board[row][col];
		*/
	}

	public boolean canPlay(){
		boolean canPlay = false;
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				if(' '==board[i][j]){
					canPlay = true;
				}
			}
		}
		return canPlay;
	}

	public boolean play(int p, int c){
		boolean play = false;
		if(c >= board[0].length){
			return false;
		}
		if(p>2){
			return false;
		}
		/*if(Board.canPlay == false){
			return false;
		}
		*/

		for(int i = board.length-1; i>=0; i--){
			//System.out.println("in");
			if(board[i][c]==' '){
				if(p==1){
					board[i][c]= player1;
					play = true;
					break;
				}
				else{
					if(p==2){
						board[i][c]= player2;
						play = true;
						break;
					}
				}
			}

		}
		return play;
	}

	public int isFinished(){
		
		int winner = this.winDiagonal();
		if(winner != -1){
			return winner;
		}
		winner = this.winCol();
		if(winner != -1){
			return winner;
		}
		winner = this.winRow();
		if(winner != -1){
			return winner;
		}
		
		/*if(winner != 1 || winner!= -1|| winner!= 2){
			winner = 0;
		}
		*/



		/*for(int i =0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				if(board[i][j] == ' '){
					boolean move = true;
				}
				else{
					move = false;
				}
			}
		}*/

		if(canPlay() == false && (winner!=1 || winner!= -1 || winner !=2)){
			winner = 0;
		}
		
		
		return winner;

	}
	
	


	public int winCol(){
		int player = -1;
		for(int column = 0; column<board[0].length; column++){
			int count = 0;
			for(int row = board.length-1; row>=0; row--){
				if(row-1<0){
					break;
				}
				if(board[row][column] != ' ' && board[row][column]==board[row-1][column]){
					count++;
				}
				else{
					count = 0;
				}
				if(count >= 3){
					if(board[row][column]==player1){
						player = 1;
					}
					else if(board[row][column]==player2){
						player = 2;
					}
				}
			}
		}
		return player;
	}

	public int winRow(){
		for(int row = 0; row<board.length; row++){
			int count = 0;
			for(int column = 1; column<board[0].length; column++){
				if(board[row][column] != ' ' && board[row][column]==board[row][column-1]){
					count++;
				}
				else{
					count = 1;
				}
				if(count >= 3){
					if(board[row][column]==player1){
						return 1;
					}
					else if(board[row][column]==player2){
						return 2;
					}
				}
			}
		}

		return -1;
	}

	public int winDiagonal(){
		int player = -1;
		for(int row = board.length-1; row >= 0; row--){
			//int count = 0;
			for(int column = 0; column<board[0].length; column++){
				//boolean ok = true;
				//char player = board[row][column];
				if((row-1)<0 || (row-2)<0|| (row-3)<0 || (column+1)>=board[0].length || (column+2)>=board[0].length || (column+3)>=board[0].length){
					break;
				}
				if(board[row][column] != ' ' && board[row][column]==board[row-1][column+1] && board[row][column]==board[row-2][column+2] && board[row][column]==board[row-3][column+3]){
					if(board[row][column]==player1){
						player = 1;
					}
					else if(board[row][column]==player2){
						player = 2;
					}
				}
				/*else{
					count = 1;
				}
				if(count>=3){
					if(board[row][column]==player1){
						player = 1;
					}
					else if(board[row][column]==player2){
						player = 2;
					}
				}*/
				
				/*for(int k = 1; k<4; k++){
					if(((row-k)>0 && (column+k)<board[0].length) && player != board[row+k][column+k] || ((row-k)<0 || (column+k)>=board[0].length)){
						ok = false;
					}
				}
				
				if(player != ' ' && ok ==true){
					if(player == player1){
						return 1;
					}else if(player==player2){
						return 2;
					}
				}
				*/
				
			}
		}

		for(int row = 0; row<board.length; row++){
			int count = 0;
			for(int column = 0; column<board[0].length; column++){
				//boolean ok = true;
				//char player = board[row][column];
				if((row+1)>=board.length|| (row+2)>=board.length|| (row+3)>=board.length || (column+1)>=board[0].length || (column+2)>=board[0].length || (column+3)>=board[0].length){
					break;
				}
				if(board[row][column] != ' ' && board[row][column]==board[row+1][column+1] && board[row][column]==board[row+2][column+2] && board[row][column]==board[row+3][column+3]){
					if(board[row][column]==player1){
						player = 1;
					}
					else if(board[row][column]==player2){
						player = 2;
					}
				}
				/*else{
					count = 1;
				}
				if(count>=3){
					if(board[row][column]==player1){
						player = 1;
					}
					else if(board[row][column]==player2){
						player = 2;
					}
				}*/
			}
		}
		return player;
	}

	public void printBoard(){
		for(int row = 0; row<board.length; row++){
			for(int column = 0; column<board[0].length; column++){
				System.out.print("| " + board[row][column] + " ");
			}
			System.out.println();
		}
	}

}