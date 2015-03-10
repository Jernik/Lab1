package sierpinski;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This is the main class for the Sierpinski triangle example.
 *
 * @author Curt Clifton.
 */
public class Main {

	private static final Dimension SIZE = new Dimension(600, 600);

	/**
	 * Starts the program.
	 *
	 * @param args Command-line arguments, ignored here
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(SIZE);
		frame.setTitle("Sierpinski Triangle");
		
		frame.add(new SierpinskiRenderer());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
