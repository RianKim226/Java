import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OmokModel {
	
	private int[][] board;
	private int size = 13;
	private boolean turns = true;
	private int result;
	
	public OmokModel() {
		
		board = new int[size][size];
		
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				board[i][j] = 0;
	}
	
	// 플레이어의 순서 바꾸기 
	public void changeTurn() {
		turns = !turns;
	}
	
	// 누구 차례인지 리턴하기. 
	// 흑돌 - true
	// 백돌 - false
	public boolean whosTurn() {
		return turns;
	}
	
	// 보드 값 바꾸기.
	// board[x][y] = a;
	public void changeBoard(int x, int y, int a) {
		
		board[x][y] = a;

	}
	
	// 보드의 값이 비어있는지 확인.
	// 비어있다면 true 리턴
	// 값이 있다면 false 리턴
	public boolean CheckBoard(int x, int y) {
		if (board[x][y] == 0)
			return true;
		else
			return false;
	}
	
	// 흑돌이면 1 리턴, 백돌이면 -1 리턴.
	public int WhichStone(int x, int y) {
		int check = 0;
		
		if (board[x][y] == 1)
			check = 1;
		else if (board[x][y] == -1)
			check = -1;
		return check;
	}
	
	// 보드 값 전체 리턴하기. 
	public int[][] GetBoard(){
		return board;
	}
	
	// 게임 룰  
	// 돌 5개가 이어지면 게임 결과 값 리턴.
	// 만약 흑돌이 이기면 1 리턴, 백돌이 이기면 -1 리턴. 
	public int GameResult() {
		
		
		
		// 가로 

	      for (int i = 0; i < size; i++) {
	         for (int j = 0; j < size - 4; j++) {
	            if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i][j + 2] == 1
	                  && board[i][j + 3]== 1 && board[i][j + 4]== 1) {
	               result = 1;

	            }
	            if (board[i][j] == -1 && board[i][j + 1] == -1 && board[i][j + 2] == -1
	                  && board[i][j + 3] == -1 && board[i][j + 4] == -1) {
	               result = -1;
	            }
	         }
	      }

	      // 세로

	      for (int i = 0; i < size - 4; i++) {
	         for (int j = 0; j < size; j++) {
	            if (board[i][j] == 1 && board[i + 1][j] == 1 && board[i + 2][j] == 1
	                  && board[i + 3][j] == 1 && board[i + 4][j] == 1) {
	               result = 1;

	            }
	            if (board[i][j] == -1 && board[i + 1][j] == -1 && board[i + 2][j] == -1
	                  && board [i + 3][j] == -1 && board[i + 4][j] == -1) {
	               result = -1;
	            }
	         }
	      }

	      // 오른쪽으로 내려가는 대각선

	      for (int i = 0; i < size - 4; i++) {
	         for (int j = 0; j < size - 4; j++) {
	            if (board[i][j] == 1 && board[i + 1][j + 1] == 1 && board[i + 2][j + 2] == 1
	                  && board[i + 3][j + 3] == 1 && board [i + 4][j + 4] == 1) {
	               result = 1;

	            }
	            if (board[i][j] == -1 && board[i + 1][j + 1] == -1 && board[i + 2][j + 2] == -1
	                  && board[i + 3][j + 3] == -1 && board[i + 4][j + 4] == -1) {
	            	result = -1;
	            }
	         }
	      }

	      // 오른쪽으로 올라가는 대각선 

	      for (int i = size - 1; i > 4 ; i--) {
	         for (int j = 0; j < size - 4; j++) {
	            if (board[i][j] == 1 && board[i - 1][j + 1] == 1 && board[i - 2][j + 2] == 1
	                  && board[i - 3][j + 3] == 1 && board[i - 4][j + 4] == 1) {
	               result = 1;
	            }
	            if (board[i][j] == -1 && board[i - 1][j + 1] == -1 && board[i - 2][j + 2] == -1
	                  && board[i - 3][j + 3] == -1 && board[i - 4][j + 4] == -1) {
	            	result = -1;
	            }
	         }
	      }
	      return result;
	   }
	
}

	