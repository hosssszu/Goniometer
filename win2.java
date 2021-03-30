package szog;

import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class win2 extends JFrame {

	private JTextField topField;
	private JTextField bottonField;
	private JTextField heightField;
	private JTextField displacementField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					win2 frame = new win2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setTextFieldText1(String text) {
		topField.setText(text);
	}

	public void setTextFieldText2(String text) {
		bottonField.setText(text);
	}

	public void setTextFieldText3(String text) {
		heightField.setText(text);
	}

	public void setTextFieldText4(String text) {
		displacementField.setText(text);
	}

	public void paint(Graphics g) {

		double topValue = Double.parseDouble(topField.getText());
		double bottonValue = Double.parseDouble(bottonField.getText());
		double heightValue = Double.parseDouble(heightField.getText());
		double displacementValue = Double.parseDouble(displacementField.getText());

		double scaleFactor = heightValue / bottonValue;

		if (scaleFactor > 0.7) {

			double valueTopDisplacement = topValue + displacementValue;
			double totalHeightPerHeight = 500 / heightValue;

			double scaleBotton = bottonValue * totalHeightPerHeight;
			double scaleTop = valueTopDisplacement * totalHeightPerHeight;
			double scaleDisplacement = displacementValue * totalHeightPerHeight;
			double scaleHeight = heightValue * totalHeightPerHeight;

			int botton = ((int)scaleBotton);
			int top = ((int)scaleTop);
			int displacement = ((int)scaleDisplacement);
			int height = ((int)scaleHeight);

			int xpoints[] = { 400 - (botton / 2), 400 + (botton / 2), 400 - (botton / 2) +
					top, 400 - (botton / 2) + displacement, 400 - (botton / 2) };
			int ypoints[] = { 550, 550, 550 - height, 550 - height, 550 };
			int npoints = 5;

			g.fillPolygon(xpoints, ypoints, npoints);

		} else {

			double valueTopDisplacement = topValue + displacementValue;
			double totalHeightPerHeight = 700 / bottonValue;

			double scaleBotton = bottonValue * totalHeightPerHeight;
			double scaleTop = valueTopDisplacement * totalHeightPerHeight;
			double scaleDisplacement = displacementValue * totalHeightPerHeight;
			double scaleHeight = heightValue * totalHeightPerHeight;

			int botton = ((int)scaleBotton);
			int top = ((int)scaleTop);
			int displacement = ((int)scaleDisplacement);
			int height = ((int)scaleHeight);

			int xpoints[] = { 50, botton + 50, top + 50, displacement + 50, 50 };
			int ypoints[] = { 300 + height / 2, 300 + height / 2, 300 - height / 2, 300 - height / 2, 300 + height / 2 };
			int npoints = 5;

			g.fillPolygon(xpoints, ypoints, npoints);

		}
	}

	public win2() {
		setTitle("Scaled Image");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
		AbstractAction escapeAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		};
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
		getRootPane().getActionMap().put("ESCAPE", escapeAction);

		topField = new JTextField();
		topField.setBounds(693, 16, 86, 20);
		topField.setColumns(10);
		topField.setVisible(false);
		contentPane.add(topField);

		bottonField = new JTextField();
		bottonField.setBounds(693, 42, 86, 20);
		bottonField.setColumns(10);
		bottonField.setVisible(false);
		contentPane.add(bottonField);

		heightField = new JTextField();
		heightField.setBounds(693, 68, 86, 20);
		heightField.setColumns(10);
		heightField.setVisible(false);
		contentPane.add(heightField);

		displacementField = new JTextField();
		displacementField.setBounds(693, 94, 86, 20);
		displacementField.setColumns(10);
		displacementField.setVisible(false);
		contentPane.add(displacementField);
	}
}
