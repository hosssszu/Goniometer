package szog;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class win {

	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					win window = new win();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public win() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Goniometer");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mntmExit.setToolTipText("Exit application");
		mntmExit.addActionListener((event) -> System.exit(0));
		mnFile.add(mntmExit);

		menuBar.add(Box.createHorizontalGlue());
		JMenu menuhelp = new JMenu("Help");
		menuhelp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuhelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menuhelp);

		JMenuItem about = new JMenuItem("About");
		about.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		about.setMnemonic(KeyEvent.VK_A);
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel author = new JLabel("Created by Szegedi Loránd!");
				author.setFont(new Font("Segoe UI", Font.PLAIN, 14));
				JOptionPane.showMessageDialog(null, author, "Message", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuhelp.add(about);

		JLabel angle_1 = new JLabel();
		angle_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		angle_1.setBounds(70, 213, 50, 25);
		frame.getContentPane().add(angle_1);

		JLabel angle_2 = new JLabel();
		angle_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		angle_2.setBounds(147, 272, 50, 25);
		frame.getContentPane().add(angle_2);

		JLabel angle_3 = new JLabel();
		angle_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		angle_3.setBounds(470, 242, 50, 25);
		frame.getContentPane().add(angle_3);

		JLabel angle_4 = new JLabel();
		angle_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		angle_4.setBounds(582, 175, 50, 25);
		frame.getContentPane().add(angle_4);

		JTextField top = new JTextField();
		top.setFont(new Font("Tahoma", Font.PLAIN, 12));
		top.setBounds(334, 12, 56, 25);
		top.setToolTipText("top");
		top.setColumns(10);
		frame.getContentPane().add(top);

		JTextField botton = new JTextField();
		botton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botton.setBounds(315, 411, 56, 25);
		botton.setColumns(10);
		botton.setToolTipText("botton");
		frame.getContentPane().add(botton);

		JTextField height = new JTextField();
		height.setFont(new Font("Tahoma", Font.PLAIN, 12));
		height.setBounds(315, 213, 56, 25);
		height.setColumns(10);
		height.setToolTipText("height");
		frame.getContentPane().add(height);

		JTextField displacement = new JTextField();
		displacement.setFont(new Font("Tahoma", Font.PLAIN, 12));
		displacement.setBounds(95, 12, 56, 25);
		displacement.setColumns(10);
		displacement.setToolTipText("displacement");
		frame.getContentPane().add(displacement);

		JLabel image = new JLabel();
		image.setBounds(20, 12, 650, 450);
		image.setIcon(new ImageIcon("src\\download3.jpg"));
		frame.getContentPane().add(image);

		JButton btnScale = new JButton("Scale");
		btnScale.setBounds(306, 474, 119, 30);
		btnScale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				win2 scale = new win2();
				scale.setTextFieldText1(top.getText());
				scale.setTextFieldText2(botton.getText());
				scale.setTextFieldText3(height.getText());
				scale.setTextFieldText4(displacement.getText());
//     		   frame.dispose();
				scale.setVisible(true);

			}
		});
		frame.getContentPane().add(btnScale);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(435, 474, 119, 30);
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCalculate) {

					double valueTop = Double.parseDouble(top.getText());
					double valueBotton = Double.parseDouble(botton.getText());
					double valueHeight = Double.parseDouble(height.getText());
					double valueDisplacement = Double.parseDouble(displacement.getText());

					double v1 = valueTop - (valueBotton - valueDisplacement);
					double v2 = v1 / valueHeight;
					double v3 = Math.atan(v2);
					float v4 = (float) ((v3 * 180) / Math.PI);
					double v5 = Math.abs(v4);

					double v6 = 90 - v5;

					double v7 = valueTop + valueDisplacement;

					double v8 = valueDisplacement / valueHeight;
					double v9 = Math.atan(v8);
					double v10 = (float) ((v9 * 180) / Math.PI);

					double v11 = 90 - v10;

					if (v7 <= valueBotton && valueDisplacement >= 0) {

						angle_1.setText(String.format("%.2f°", v10));
						angle_2.setText(String.format("%.2f°", v11));
						angle_3.setText(String.format("%.2f°", v6));
						angle_4.setText(String.format("%.2f°", v5));

						image.setIcon(new ImageIcon("src\\download2.jpg"));

					} else {
						angle_1.setText("");
						angle_2.setText("");
						angle_3.setText("");
						angle_4.setText("");
						top.setText("");
						botton.setText("");
						height.setText("");
						displacement.setText("");
						image.setIcon(new ImageIcon("src\\download3.jpg"));
						JOptionPane.showMessageDialog(null, "Something went wrong!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		frame.getContentPane().add(btnCalculate);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				angle_1.setText("");
				angle_2.setText("");
				angle_3.setText("");
				angle_4.setText("");
				top.setText("");
				botton.setText("");
				height.setText("");
				displacement.setText("");
				image.setIcon(new ImageIcon("src\\download3.jpg"));
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(11, 474, 119, 30);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(564, 474, 119, 30);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnExit);
	}
}
