import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunGame extends JFrame{
	
	private Container c;
	private OmokModel model;
	private int width = 420;
	
	public RunGame(OmokModel om) {
		
		model = om;
		
		setTitle("OMOK");
		setSize(width + 180, width + 22);
		
		
		c = getContentPane();
		c.setLayout(null);
		
		OmokFrame frame = new OmokFrame(model);
		setContentPane(frame);
		
		GetMouse mouse = new GetMouse(model, frame);
		addMouseListener(mouse);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
