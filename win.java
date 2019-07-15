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
import java.awt.Label;

public class win {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel textField_3;
	private JTextField textField_4;

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
		frame.setBounds(100, 100, 700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Goniometer");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_X);
        mntmExit.setToolTipText("Exit application");
		mntmExit.addActionListener((event) -> System.exit(0));
		mnFile.add(mntmExit);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		   menuBar.add(Box.createHorizontalGlue());
		   JMenu menuhelp = new JMenu("Help");
		   menuhelp.setMnemonic(KeyEvent.VK_H);
		   menuBar.add(menuhelp);
		   
		   JMenuItem about = new JMenuItem("About");
		   about.setMnemonic(KeyEvent.VK_A);
		   about.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		JOptionPane.showMessageDialog(null, String.format("Created by Szegedi Loránd!",e.getActionCommand()));
		   	}
		   });
		   menuhelp.add(about);
        
        		textField_3 = new JLabel();
        		textField_3.setBounds(573, 162, 50, 25);
        		frame.getContentPane().add(textField_3);
        		
                JLabel label_1 = new JLabel();
                label_1.setBounds(65, 195, 50, 25);
                frame.getContentPane().add(label_1);
                
                JLabel label_2 = new JLabel();
                label_2.setBounds(156, 263, 50, 25);
                frame.getContentPane().add(label_2);
                
                JLabel label_3 = new JLabel();
                label_3.setBounds(449, 247, 50, 25);
                frame.getContentPane().add(label_3);

        
        textField = new JTextField();
        textField.setBounds(334, 12, 56, 25);
        textField.setToolTipText("top");
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setToolTipText("botton");
        textField_1.setBounds(315, 411, 56, 25);
        frame.getContentPane().add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setToolTipText("height");
        textField_2.setBounds(315, 213, 56, 25);
        frame.getContentPane().add(textField_2);
		//textField_3.setEditable(false);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setToolTipText("displacement");
        textField_4.setBounds(95, 12, 56, 25);
        frame.getContentPane().add(textField_4);

        
		btnNewButton.setBounds(559, 464, 114, 25);
		frame.getContentPane().add(btnNewButton);
        
        JButton btnCalculate = new JButton("Calculate!");
        btnCalculate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 if (e.getSource() == btnCalculate)
        	      {
     				String first=textField.getText();
    				String second=textField_1.getText();
    				String third=textField_2.getText();
    				String fourth=textField_4.getText();
    				
    				double d1 = Double.parseDouble(first); //top
    				double d2 = Double.parseDouble(second); //botton
    				double d3 = Double.parseDouble(third); //height
    				double de = Double.parseDouble(fourth); //displacement
    				
    				double d4 = d1-(d2-de);
    				double d5 = d4/d3;
    				double d6 = Math.atan(d5);
    				float d7 = (float)((d6*180)/Math.PI);
    				double d8=Math.abs(d7);
    				
    				double d9 = 90-d8;
    				
    				double di = de/d3;
    				double dii = Math.atan(di);
    				double diii = (float)((dii*180)/Math.PI);
    				
    				double diiii = 90-diii;
    
    			    textField_3.setText(String.format("%.2f°", d8));
    			    label_1.setText(String.format("%.2f°", diii));
    			    
    			    label_2.setText(String.format("%.2f°", diiii));
    			    label_3.setText(String.format("%.2f°", d9));
        	      }
        	}
        });
        btnCalculate.setBounds(435, 464, 114, 25);
        frame.getContentPane().add(btnCalculate);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\Lorand\\eclipse-workspace\\szog\\src\\download2.jpg"));// your image here
        label.setBounds(20, 12, 660, 441);
        frame.getContentPane().add(label);
	}
}