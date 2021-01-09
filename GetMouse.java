import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GetMouse extends MouseAdapter {
	
	private int size = 13;
	private Point mousePos;
	private OmokModel model;
	private OmokFrame frame;

	
	
	public GetMouse (OmokModel om, OmokFrame of) {
		model = om;
		frame = of;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if (model.GameResult() == 1 || model.GameResult() == -1)
			return;
		
		mousePos = e.getPoint();
		
		for(int i = 0; i < size ; i++)
			for(int j = 0; j < size ; j++) {
				
				int minXpos = 30 + (j * 30) - 13;
				int maxXpos = 30 + (j * 30) + 13;
				int minYpos = 60 + (i * 30) - 13;
				int maxYpos = 60 + (i * 30) + 13;
				
				if (minXpos <= mousePos.x && mousePos.x <= maxXpos && minYpos <= mousePos.y && mousePos.y <= maxYpos) {
					
					if(model.CheckBoard(i, j)) {
						
						if (model.whosTurn()) 
							model.changeBoard(i, j, 1);
						else
							model.changeBoard(i, j, -1);
					}
				}
			}
		model.changeTurn();
		frame.repaint();
	}
	
}
