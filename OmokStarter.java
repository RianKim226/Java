
public class OmokStarter {


	public static void main(String[] args) {
	
		OmokModel model = new OmokModel();
		OmokFrame frame = new OmokFrame(model);
		new GetMouse(model, frame);
		new RunGame(model);

	}
}

