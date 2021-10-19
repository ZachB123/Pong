import java.awt.Dimension;
import javax.swing.JFrame;

public class PongRunner {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(816,639);
		frame.setTitle("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pong p = new Pong();
		p.setPreferredSize(new Dimension(800,600));
		frame.add(p);
		frame.setVisible(true);

	}

}
