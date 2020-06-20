import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



interface Connect4Grid {

	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();   
	
}


class Connect4Grid2DArray implements Connect4Grid {
	
	int [] [] connect4Grid = new int [6][7];
	
	public void emptyGrid() {
		
		int i = 0;
		while(i < connect4Grid.length-1)
		{
			int count = 0;
			while(count < connect4Grid[i].length-1)
			{
				connect4Grid[count][1] = 0;
				count++;
			}
			i++;
		}
		
	}
	
	public String toString() {
		
		return Arrays.deepToString(connect4Grid).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
	}
	
	public boolean isValidColumn(int column) {
		
		if(column < 0 && column > 6)
			return false;
		else if(connect4Grid[0][column] != 0)
			return false;
		else
			return true;
			
		
		
	}
	
	public boolean isColumnFull(int column) {
		
		if(connect4Grid[0][column] != 0)
			return true;
		else
			return false;
		
	}
	
	public void dropPiece(ConnectPlayer player, int column) {
		
		int team = player.getTeam();
		int i = connect4Grid[0].length-2;
		
		if(isValidColumn(column))
		{
			if(connect4Grid[i][column]==0)
				connect4Grid[i][column] = team;
			else if(connect4Grid[i-1][column]==0)
				connect4Grid[i-1][column]=team;
			else if(connect4Grid[i-2][column]==0)
				connect4Grid[i-2][column]=team;
			else if(connect4Grid[i-3][column]==0)
				connect4Grid[i-3][column]=team;
			else if(connect4Grid[i-4][column]==0)
				connect4Grid[i-4][column]=team;
			else if(connect4Grid[i-5][column]==0)
				connect4Grid[i-5][column]=team;
		
			
		}
		
	}
	
	public boolean didLastPieceConnect4() {
		
		int y = 0;
		
		while(y<6)
		{
			int x = 0;
			while(x<connect4Grid[0].length-3)
			{
				if(connect4Grid[y][x]==connect4Grid[y][x+1] && connect4Grid[y][x+1]==connect4Grid[y][x+2] && connect4Grid[y][x+2]==connect4Grid[y][x+3] && connect4Grid[y][x]!=0)
					return true;
				x++;
			}
			y++;
		}

		int x = 0;
		
		while(x<connect4Grid[0].length)
		{
			y = 0;
			while(y<connect4Grid.length-3)
			{
				if(connect4Grid[y][x]==connect4Grid[y+1][x] && connect4Grid[y+1][x]==connect4Grid[y+2][x] && connect4Grid[y+2][x]==connect4Grid[y+3][x] && connect4Grid[y][x]!=0)
					return true;
				y++;
			}
			x++;
		}
		
		x = 0;
		
		while(x<connect4Grid[0].length-3)
		{
			y = 0;
			while(y<connect4Grid.length-3)
			{
				if(connect4Grid[y][x]==connect4Grid[y+1][x+1] && connect4Grid[y+1][x+1]==connect4Grid[y+2][x+2] && connect4Grid[y+2][x+2]==connect4Grid[y+3][x+3] && connect4Grid[y][x]!=0)
					return true;
				y++;
			}
			x++;
		}
		
		x = 0;
		
		while(x<connect4Grid[0].length-3)
		{
			y = 3;
			while(y<connect4Grid.length)
			{
				if(connect4Grid[y][x]==connect4Grid[y-1][x+1] && connect4Grid[y-1][x+1]==connect4Grid[y-2][x+2] && connect4Grid[y-2][x+2]==connect4Grid[y-3][x+3] && connect4Grid[y][x]!=0)
					return true;
				y++;
			}
			x++;
		}
		
		return false;
		

	}

	public boolean isGridFull() {
		
		int x = 0;
		int y= 0;
		
		while(x<connect4Grid.length-1)
		{
			while(y<connect4Grid[1].length-1)
			{
				if(connect4Grid[x][y] == 0)
					return false;
				y++;
			}
			
			x++;
		}
		return true;
		
	}

}
	


abstract class ConnectPlayer{
	
	public abstract int getTeam();
	
}




class C4HumanPlayer extends ConnectPlayer{
	
	int team;
	
	C4HumanPlayer(int position)
	{
		team = position;
	}
	
	public int getTeam() {
		
		
		return team;
	}
	
	public void turn(int column, Connect4Grid grid, ConnectPlayer player) {
		
		if(grid.isValidColumn(column))
			grid.dropPiece(player, column);
		
		System.out.println(grid.toString());
		
	}
	
	public void turnWithAI(int column, Connect4Grid grid, ConnectPlayer player) {
		
		if(grid.isValidColumn(column))
			grid.dropPiece(player, column);
		
		
	}
	
}




class C4RandomAIPlayer extends ConnectPlayer {
	
	int team;
	
	C4RandomAIPlayer(int position)
	{
		team = position;
	}
	
	public int getTeam() {
		
		return team;
	}
	
	public void turn(Connect4Grid grid, ConnectPlayer player) {
		
		Random rand = new Random();
		int column = rand.nextInt(6);
		
		while(grid.isColumnFull(column))
			column = rand.nextInt(6);
		
		grid.dropPiece(player, column);
		System.out.println(grid.toString());
		
	}
	
	
	
}

public class Connect4Game {
	
	

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		boolean continue1 = true;
		System.out.println("WELCOME TO CONNECT 4 \n");
		
		while(continue1)
		{
			
			System.out.println("TYPE 'play' TO BEGIN A GAME OR 'quit' TO END");
			
			String input = scanner.next();
			
			if(input.equals("quit"))
			{
				continue1 = false;
			}
			else if(input.equals("play"))
			{
				
				Connect4Grid2DArray grid = new Connect4Grid2DArray();
				grid.emptyGrid();
				
				System.out.println("Would you like to play against: 1. An AI  2. A real player");
				
				input = scanner.next();
				
				if(input.equals("1"))
				{
					C4HumanPlayer player1 = new C4HumanPlayer(1);
					C4RandomAIPlayer AI = new C4RandomAIPlayer(2);
					

					while(!grid.didLastPieceConnect4() && !grid.isGridFull())
					{
						System.out.println("In what column would you like to place your piece?(User)");
						int column = scanner.nextInt();
						while(grid.isColumnFull(column))
						{
							System.out.println("Column is full, please choose another one");
							column = scanner.nextInt();
						}
						if(!grid.didLastPieceConnect4() && !grid.isGridFull())
							player1.turnWithAI(column, grid, player1);
					
						if(!grid.didLastPieceConnect4() && !grid.isGridFull())
							AI.turn(grid, AI);
						
					}
					
					
					
					
				}
				else if(input.equals("2"))
				{
					C4HumanPlayer player1 = new C4HumanPlayer(1);
					C4HumanPlayer player2 = new C4HumanPlayer(2);
					
					while(!grid.didLastPieceConnect4() && !grid.isGridFull())
					{
						System.out.println("In what column would you like to place your piece?(Player 1)");
						int column = scanner.nextInt();
						while(grid.isColumnFull(column))
						{
							System.out.println("Column is full, please choose another one");
							column = scanner.nextInt();
						}
						if(!grid.didLastPieceConnect4() && !grid.isGridFull())
							player1.turn(column, grid, player1);
					
						
						if(!grid.didLastPieceConnect4() && !grid.isGridFull())
						{
							System.out.println("In what column would you like to place your piece?(Player 2)");
							column = scanner.nextInt();
						}
						while(grid.isColumnFull(column))
							{
								System.out.println("Column is full, please choose another one");
								column = scanner.nextInt();
							}
						if(!grid.didLastPieceConnect4() && !grid.isGridFull())
							player2.turn(column, grid, player2);
						
					}
										
				}
				if(grid.didLastPieceConnect4())
				{
					System.out.println("Congradulations, you just won Connect4!\n");
				}
				if(grid.isGridFull())
				{
					System.out.println("The grid is full, there is no winner");
				}				
			
			}
		
		}
		
	}

}

/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. 
If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be 
ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface.
Finally a check is performed to determine a win. 
Comment:Yes, I did it all. 35/35

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment:10/10, all 7 methods have been defined

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. 
It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  
It provides as implementation of the method to check whether there is a win.
Comment:25/25. Yes it implements the interface and dies everything else

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:8/10. There is an abstract method but no non-abstract method as I saw noo use for one in the class

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:10/10, Yes it is all done

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment:10/10. It provides AI functionality

Total Marks out of 100:98

*/

