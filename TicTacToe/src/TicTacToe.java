import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe 
{
	static ArrayList<Integer> playersPositions = new ArrayList<Integer> (); 
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer> (); 

	public static void main(String[] args) 
	{
		//creating the game board:
		char[][] gameBoard = {  {' ', '|', ' ', '|', ' '}, 
								{'-', '+', '-', '+', '-'}, 
								{' ', '|', ' ', '|', ' '}, 
								{'-', '+', '-', '+', '-'}, 
								{' ', '|', ' ', '|', ' '}  };
		

		printGameBoard(gameBoard);


		
		while(true) 
		{
			//Getting input from the use. 
			Scanner input = new Scanner(System.in); 
			
			System.out.println("Enter your placement (1-9)");
			int playerPos = input.nextInt(); 
					
			while(playersPositions.contains(playerPos) || cpuPositions.contains(playersPositions))
			{
				System.out.println("Position taken! Enter a correct position!");
				playerPos = input.nextInt(); 
			}
			
			placePiece(gameBoard, playerPos, "player"); 
	
			Random rand = new Random(); 
			int cpuPos = rand.nextInt(9) + 1; 
			System.out.println(" ");
			
			while(playersPositions.contains(cpuPos) || cpuPositions.contains(cpuPos))
			{
				//System.out.println("Position taken! Enter a correct position!");
				cpuPos = input.nextInt(9) +1; 
			}
			
			placePiece(gameBoard, cpuPos, "cpu"); 

			printGameBoard(gameBoard);
			
			String result = checkWinner(); 
			//System.out.println(result);
			
			if(result.length() > 0)
			{
				System.out.println(result);
				break; 
			}
		}
		
	}
	
	public static void printGameBoard(char[][] gameBoard)
	{
		//Print the board
		for(char[] row: gameBoard)
		{
			for(char c: row)
			{
				System.out.print(c);
			}
			System.out.println();
		}	
	}
	
	public static void placePiece(char[][] gameBoard, int pos, String User)
	{
		char symbol = ' '; 
		
		if(User.equals("player")) 
		{
			playersPositions.add(pos); 
			symbol = 'X'; 
		}
		else if(User.equals("cpu"))
		{
			cpuPositions.add(pos); 
			symbol = 'O';
		}

		
		//changing the symbol, changing one of the space characters to an X or an O
		//example ==> if the position is 1, change the 2D array to an X.
		//example ==> if the placement is 2, change this placement to an O
		switch(pos)
		{
		case 1: gameBoard[0][0] = symbol; break; 
		case 2: gameBoard[0][2] = symbol; break; //In 2D array it starts with a row
		case 3: gameBoard[0][4] = symbol; break; 
		case 4: gameBoard[2][0] = symbol; break; 
		case 5: gameBoard[2][2] = symbol; break; 
		case 6: gameBoard[2][4] = symbol; break; 
		case 7: gameBoard[4][0] = symbol; break; 
		case 8: gameBoard[4][4] = symbol; break; 
		case 9: gameBoard[4][4] = symbol; break; 

		}
		
		//printGameBoard(gameBoard);	
	}
	
	public static String checkWinner()
	{
		//win conditions
		List topRow = Arrays.asList(1,2,3); 
		List midRow = Arrays.asList(4,5,6); 
		List botRow = Arrays.asList(7,8,9); 
		List leftCol = Arrays.asList(1,4,7); 
		List midCol = Arrays.asList(2,5,8); 
		List rightCol = Arrays.asList(3,6,9); 
		List cross1 = Arrays.asList(1,5,9); 
		List cross2 = Arrays.asList(7,5,3); 
		
		List<List> winning = new ArrayList<List>(); 
		winning.add(topRow); 
		winning.add(midRow); 
		winning.add(botRow); 
		winning.add(leftCol); 
		winning.add(midCol); 
		winning.add(rightCol); 
		winning.add(cross1); 
		winning.add(cross2); 
		
		for(List l: winning)
		{
			if(playersPositions.containsAll(l)) return "Congratulations you won";
			else if (cpuPositions.contains(l)) return "CPU wins. You lose"; 
			else if(playersPositions.size() + cpuPositions.size() == 9) return "CAT";
		}
		

		
		return ""; 
	}
	

}
