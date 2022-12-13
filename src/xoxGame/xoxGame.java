package xoxGame;
import java.util.Random;
import java.util.Scanner;
public class xoxGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] board = {{' ', ' ', ' '},
						  {' ', ' ', ' '},
						  {' ', ' ', ' '}};
		printBoard(board);
		while(true) {
		playerTurn(board, scanner);
		if(oyunBitti(board)) {
			break;
		}
		printBoard(board);
		
		computerTurn(board);
		if(oyunBitti(board)) {
			break;
		}
		printBoard(board);
	}
	scanner.close();
}

	private static boolean oyunBitti(char[][] board) {
		if(rakipTaraf(board, 'X')) {
		printBoard(board);
		System.out.print("Kazandınız!");
		return true;
		}
		if(rakipTaraf(board, 'O')) {
			printBoard(board);
			System.out.print("Bilgisayar Kazandı!");
			return true;
			}
		
		for(int i=0; i< board.length; i++ ) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("Oyun berabere bitti");
		return true;
		
	}

	private static boolean rakipTaraf(char[][] board, char symbol) {
		if((board[0][0]==symbol && board[0][1]== symbol&& board[0][2]==symbol) || 
		(board[1][0]==symbol && board[1][1]== symbol&& board[1][2]==symbol)||
		(board[2][0]==symbol && board[2][1]== symbol&& board[2][2]==symbol)||
		
		(board[0][0]==symbol && board[1][0]== symbol&& board[2][0]==symbol) || 
		(board[1][0]==symbol && board[1][1]== symbol&& board[1][2]==symbol)||
		(board[2][0]==symbol && board[2][1]== symbol&& board[2][2]==symbol)||
		
		(board[0][0]==symbol && board[1][1]== symbol&& board[2][2]==symbol) || 
		(board[0][2]==symbol && board[1][1]== symbol&& board[2][0]==symbol)){
			return true;
		}
		return false;
	}
	

	private static void computerTurn(char[][] board) {
		Random rand = new Random();
		int computerMove;
		while(true) {
		computerMove = rand.nextInt(9)+1;
		if (gecerliHamle (board, computerMove)) {
			break;
		}
		}
		System.out.println("bilgisayarın seçimi: " + computerMove);
		
		placeMove(board, Integer.toString(computerMove), 'O');
	}
	
	private static boolean gecerliHamle(char[][] board, int position) {
		switch(position){
		case 1:
			if(board[0][0]== ' '){
				return true;
					}else {
				return false;
			}
		case 2:
			if(board[0][1]== ' ') {
				return true;
			}else {
				return false;
			}
		case 3:
			if(board[0][2]== ' ') {
				return true;
			}else {
				return false;
			}
		case 4:
			if(board[1][0]== ' ') {
				return true;
			}else {
				return false;
			}
		case 5:
			if(board[1][1]== ' ') {
				return true;
			}else {
				return false;
			}
		case 6:
			if(board[1][2]== ' ') {
				return true;
			}else {
				return false;
			}
		case 7:
			if(board[2][0]== ' ') {
				return true;
			}else {
				return false;
			}
		case 8:
			if(board[2][1]== ' ') {
				return true;
			}else {
				return false;
			}
		case 9:
			if(board[2][2]== ' ') {
				return true;
			}else {
				return false;
			}
		default:
				return false;
			
	}
	}

	private static void playerTurn(char[][] board, Scanner scanner) {
		String kullaniciGirisi;
		while (true) {
		System.out.println("Oynamak istediğiniz yeri seçin. (1-9)");
		kullaniciGirisi = scanner.nextLine();
		if(gecerliHamle(board, Integer.parseInt(kullaniciGirisi))) {
			break;
		}else {
			System.out.println(kullaniciGirisi+":" + "Geçerli Bir hamle değil");
		}
		}
		placeMove(board, kullaniciGirisi, 'X');
		
	}
	
	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position){
			case "1":
				board[0][0]= symbol;
				break;
			case "2":
				board[0][1]= symbol;
				break;
			case "3":
				board[0][2]= symbol;
				break;
			case "4":
				board[1][0]= symbol;
				break;
			case "5":
				board[1][1]= symbol;
				break;
			case "6":
				board[1][2]= symbol;
				break;
			case "7":
				board[2][0]= symbol;
				break;
			case "8":
				board[2][1]= symbol;
				break;
			case "9":
				board[2][2]= symbol;
				break;
			default:
				System.out.println(":(");
			
				
		}
	}

	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" +board[2][2]);
	}
}