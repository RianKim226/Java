import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OmokFrame extends JPanel {

	private int size = 13;
	private OmokModel model;
	private int width = 420;

	

	public OmokFrame(OmokModel om) {
		model = om;
	}
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillRect(0, 0, width, width);
		g.setColor(Color.darkGray);
		g.fillRect(width, 0, 180, width);
		g.setColor(Color.black);
		for(int i = 1; i < 14; i++) {
			g.drawLine(i * 30, 30, i * 30, 390);
			g.drawLine(30, i * 30, 390, i * 30);
		}
		
		WhoPlay(g);
		
		DrawBoard(g);
		
		WhosWin(g);
		
	}
	
	// 누가 이겼는지 출력하기. 
	
	private void WhosWin(Graphics g) { 
				if(model.GameResult() == 1){
					g.setColor(Color.red);
					g.drawString("흑돌이 이겼습니다!", 460, 200);
				}
				
				else if (model.GameResult() == -1){
					g.setColor(Color.red);
					g.drawString("백돌이 이겼습니다!", 460, 200);
				}
	}
	
	// 보드 위에 돌 그리기
	
	private void DrawBoard(Graphics g) {
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j ++) {
				if (model.WhichStone(i, j) == 1) {
					g.setColor(Color.black);
					g.drawOval(30 + (j * 30) - 15, 30 + (i * 30) - 15, 30, 30);
					g.fillOval(30 + (j * 30) - 15, 30 + (i * 30) - 15, 30, 30);
				}
				else if (model.WhichStone(i, j) == -1) {
					g.setColor(Color.black);
					g.drawOval(30 + (j * 30) - 15, 30 + (i * 30) - 15, 30, 30);
					g.setColor(Color.white);
					g.fillOval(30 + (j * 30) - 15, 30 + (i * 30) - 15, 30, 30);
				}
			}
	}
	
	// 누구 차례인지 출력하기. 
	
	private void WhoPlay(Graphics g) {
		g.setColor(Color.white);
		if (model.whosTurn()) 
			g.drawString("흑돌의 차례 입니다.", 460, 100);
		else
			g.drawString("백돌의 차례 입니다.", 460, 100);
	}
}


