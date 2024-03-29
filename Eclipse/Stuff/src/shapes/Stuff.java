package shapes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Stuff extends JPanel {

	JFrame frame;

	public Stuff(JFrame frame) {
		super(new BorderLayout());
		this.frame = frame;
		JPanel pane1 = createShapesPicker();
		Border padding = BorderFactory.createEmptyBorder(20, 20, 5, 20);
		pane1.setBorder(padding);;

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Shape Area Calculator", null, pane1, "Shapes");
		add(tabbedPane, BorderLayout.CENTER);
	}

	private static JPanel createShapesPicker() {
		final int numButtons = 5;
		JRadioButton[] radioButtons = new JRadioButton[numButtons];
		final ButtonGroup group = new ButtonGroup();

		final JButton pickIt = new JButton("Pick It!");

		final Circle circle1 = new Circle();
		final Rectangle rect1 = new Rectangle();
		final Triangle tri1 = new Triangle();
		final Triangle2 tri2 = new Triangle2();

		final String triangleCommand = "triangle";
		final String rectangleCommand = "rectangle";
		final String circleCommand = "circle";
		final String heronCommand = "heron";
		final String quitCommand = "quit";

		final JTextField radius = new JTextField(10);
		final JTextField length = new JTextField(10);
		final JTextField height1 = new JTextField(10);
		final JTextField base = new JTextField(10);
		final JTextField height2 = new JTextField(10);
		final JTextField side1 = new JTextField(10);
		final JTextField side2 = new JTextField(10);
		final JTextField side3 = new JTextField(10);

		final JPanel cirPanel = new JPanel();
		final JPanel rectPanel = new JPanel();
		final JPanel triPanel = new JPanel();
		final JPanel tri2Panel = new JPanel();

		cirPanel.add(new JLabel("Radius: "));
		cirPanel.add(radius);

		rectPanel.add(new JLabel("Length: "));
		rectPanel.add(length);
		rectPanel.add(Box.createHorizontalStrut(15));
		rectPanel.add(new JLabel("Height: "));
		rectPanel.add(height1);

		triPanel.add(new JLabel("Base: "));
		triPanel.add(base);
		triPanel.add(Box.createHorizontalStrut(15));
		triPanel.add(new JLabel("Height: "));
		triPanel.add(height2);

		tri2Panel.add(new JLabel("Side 1: "));
		tri2Panel.add(side1);
		tri2Panel.add(Box.createHorizontalStrut(15));
		tri2Panel.add(new JLabel("Side 2: "));
		tri2Panel.add(side2);
		tri2Panel.add(Box.createHorizontalStrut(15));
		tri2Panel.add(new JLabel("Side 3: "));
		tri2Panel.add(side3);

		radioButtons[0] = new JRadioButton("Triangle");
		radioButtons[0].setActionCommand(triangleCommand);

		radioButtons[1] = new JRadioButton("Rectangle");
		radioButtons[1].setActionCommand(rectangleCommand);

		radioButtons[2] = new JRadioButton("Circle");
		radioButtons[2].setActionCommand(circleCommand);

		radioButtons[3] = new JRadioButton("Triangle (Heron's Formula");
		radioButtons[3].setActionCommand(heronCommand);

		radioButtons[4] = new JRadioButton("Quit (Press twice to quit)");
		radioButtons[4].setActionCommand(quitCommand);

		for (int i = 0; i < numButtons; i++) {
			group.add(radioButtons[i]);
		}

		radioButtons[0].setSelected(true);

		pickIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = group.getSelection().getActionCommand();

				if (command == triangleCommand) {
					int triInput = JOptionPane
							.showConfirmDialog(
									null,
									triPanel,
									"Please enter enter a base and height for your triangle.",
									JOptionPane.OK_CANCEL_OPTION);
					if (triInput == JOptionPane.OK_OPTION) {
						tri1.setBase(Double.parseDouble(base.getText()));
						tri1.setHeight(Double.parseDouble(height2.getText()));

						JOptionPane.showMessageDialog(
								null,
								"Base = " + tri1.getBase() + "\nHeight = "
										+ tri1.getHeight() + "\nArea = "
										+ tri1.getArea(), "Triangle",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else if (command == heronCommand) {
					int triInput = JOptionPane
							.showConfirmDialog(
									null,
									tri2Panel,
									"Please enter enter three side lengths for your triangle.",
									JOptionPane.OK_CANCEL_OPTION);
					if (triInput == JOptionPane.OK_OPTION) {
						tri2.setSide1(Double.parseDouble(side1.getText()));
						tri2.setSide2(Double.parseDouble(side2.getText()));
						tri2.setSide3(Double.parseDouble(side3.getText()));

						JOptionPane.showMessageDialog(
								null,
								"Side 1 = " + tri2.getSide1() + "\nSide 2 = "
										+ tri2.getSide2() + "\nSide 3 = "
										+ tri2.getSide3() + "\nArea = "
										+ tri2.getHeron(), "Triangle",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else if (command == circleCommand) {
					int cirInput = JOptionPane.showConfirmDialog(null,
							cirPanel,
							"Please enter enter a radius for your circle.",
							JOptionPane.OK_CANCEL_OPTION);
					if (cirInput == JOptionPane.OK_OPTION) {
						circle1.setRadius(Double.parseDouble(radius.getText()));

						JOptionPane.showMessageDialog(null,
								"Radius = " + circle1.getRadius() + "\nArea = "
										+ circle1.getArea(), "Circle",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else if (command == rectangleCommand) {
					int rectInput = JOptionPane
							.showConfirmDialog(
									null,
									rectPanel,
									"Please enter enter a length and height for your rectangle.",
									JOptionPane.OK_CANCEL_OPTION);
					if (rectInput == JOptionPane.OK_OPTION) {
						rect1.setLength(Double.parseDouble(length.getText()));
						rect1.setHeight(Double.parseDouble(height1.getText()));

						JOptionPane.showMessageDialog(null,
								"Length = " + rect1.getLength() + "\nHeight = "
										+ rect1.getHeight() + "\nArea = "
										+ rect1.getArea(), "Rectangle",
								JOptionPane.PLAIN_MESSAGE);
					}

				} else if (command == quitCommand) {
					pickIt.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == pickIt) {
								if (JOptionPane.showConfirmDialog(null,
										"Are you sure you would like to quit?",
										"Quit?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

									System.exit(0);
								}
							}
						}
					});
				}
			}

		});
		return createPane("Shapes", radioButtons, pickIt);
	}
	private static JPanel createPane(String description,
			JRadioButton[] radioButtons, JButton showButton) {

		int numChoices = radioButtons.length;
		JPanel box = new JPanel();
		JLabel label = new JLabel(description);

		box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
		box.add(label);

		for (int i = 0; i < numChoices; i++) {
			box.add(radioButtons[i]);
		}

		JPanel pane = new JPanel(new BorderLayout());
		pane.add(box, BorderLayout.PAGE_START);
		pane.add(showButton, BorderLayout.PAGE_END);
		return pane;
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		Stuff newContentPane = new Stuff(frame);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Random panelMessage = new Random();
		int random;
		int choice1 = JOptionPane.showConfirmDialog(null,
				"Would you like to calculate the area of a shape?", "Shapes",
				JOptionPane.YES_NO_OPTION);

		if (choice1 == JOptionPane.YES_OPTION) {

			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});
		} else {
			random = panelMessage.nextInt(10);
			switch (random) {
				case 0 :
					JOptionPane.showMessageDialog(null,
							"...for a thousand years!",
							"You have been banished to the Moon...",
							JOptionPane.WARNING_MESSAGE);
					break;
				case 1 :
					JOptionPane.showMessageDialog(null,
							"You got sent to the sun...", "Wat.",
							JOptionPane.WARNING_MESSAGE);
					break;
				case 2 :
					JOptionPane.showMessageDialog(null,
							"...and you were eaten.",
							"You run into a zombie...",
							JOptionPane.WARNING_MESSAGE);
					break;
				case 3 :
					JOptionPane
							.showMessageDialog(null, "...by a creeper.",
									"You were blown up...",
									JOptionPane.WARNING_MESSAGE);
					break;
				case 4 :
					JOptionPane
							.showMessageDialog(null, "...in lava.",
									"You tried to swim...",
									JOptionPane.WARNING_MESSAGE);
					break;
				case 5 :
					JOptionPane.showMessageDialog(null, "You don't even lift.",
							"Bro,", JOptionPane.WARNING_MESSAGE);
					break;
				case 6 :
					JOptionPane.showMessageDialog(null, "...even hoist?",
							"Doth thou...", JOptionPane.WARNING_MESSAGE);
					break;
				case 7 :
					JOptionPane.showMessageDialog(null, "...person...stahp!",
							"Person...wat r u doin...",
							JOptionPane.WARNING_MESSAGE);
					break;
				case 8 :
					JOptionPane.showMessageDialog(null, "...Bob Philman!",
							"Happy Birthday...", JOptionPane.WARNING_MESSAGE);
					break;
				case 9 :
					JOptionPane.showMessageDialog(null,
							"...the kids, they listen to the rap..."
									+ "\n...which gives them "
									+ "the brain damage.", "You see...",
							JOptionPane.WARNING_MESSAGE);
					break;
			}
		}

	}

}
