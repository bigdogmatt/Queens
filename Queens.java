public class Queens 
{
	
	//A method that prints the chess board to the console including the queens and thier locations
	public static void printBoard(char[][] board) 
	{
		for(int i = 0; i < board.length; i++)
		{		
			for(int j = 0; j < board[i].length; j++)
			{
				System.out.print("----");
			}
			
			System.out.println("-");
			
			for(int j = 0; j < board[i].length; j++)
			{
				System.out.print("| " + board[i][j] + " ");			
			}
			System.out.println("|");
		}
		for(int i = 0; i < board.length; i++)
		{
			System.out.print("----");
		}
		System.out.print("-");
	}
	
	// A method that takes the locations of two queens and returns true if they can attack eachother and false if not
	public static boolean canAttack(int row1, int column1, int row2, int column2 ) 
	{
		// Two queens can attack eachother if they are in the same column, row, or diagonal
		if(row1 == row2 || column1 == column2 || Math.abs(row1 - row2) == Math.abs(column1 - column2))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		char[][] board = new char[8][8]; //create a new board
		
		// Randomly determine the row and column of the first queen
		int row1 = (int)(Math.random() * 8);
		int column1 = (int)(Math.random() * 8);	
		int row2;
		int column2;
		
		// Randomly determine the row and column of the second queen as long as they are not the same as the first
		do {
			row2 = (int)(Math.random() * 8);
			column2 = (int)(Math.random() * 8);
		} while( row2 == row1 && column2 == column1 );
		
		// Fill the board with empty spaces
		for( int i = 0; i < board.length; ++i )
			for( int j = 0; j < board[i].length; ++j )
				board[i][j] = ' ';
		
		// Add the queens
		board[row1][column1] = 'Q';
		board[row2][column2] = 'Q';
		
		printBoard(board);
		System.out.println();
		
		if( canAttack(row1, column1, row2, column2) )
			System.out.println("The queens can attack each other!");
		else
			System.out.println("The queens can't attack each other!");	
	}
}