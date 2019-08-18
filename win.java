package szog;

import java.awt.Color;
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
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JLabel textField_3;
	public JTextField textField_4;
	
	
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
		   		
		 	JLabel label = new JLabel("Created by Szegedi Loránd!");
		   	label.setFont(new Font("Segoe UI", Font.PLAIN, 14));		   		
		   	JOptionPane.showMessageDialog(null, label ,"Message", JOptionPane.INFORMATION_MESSAGE);
		   	}
		});
		menuhelp.add(about);
        		
        JLabel label_1 = new JLabel();
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_1.setBounds(70, 213, 50, 25);
        frame.getContentPane().add(label_1);
               
        JLabel label_2 = new JLabel();
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_2.setBounds(147, 272, 50, 25);
        frame.getContentPane().add(label_2);
               
        JLabel label_3 = new JLabel();
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3.setBounds(470, 242, 50, 25);
        frame.getContentPane().add(label_3);
                
        JLabel label_4 = new JLabel();
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_4.setBounds(582, 175, 50, 25);
        frame.getContentPane().add(label_4);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField.setBounds(334, 12, 56, 25);
        textField.setToolTipText("top");
        textField.setColumns(10);
        frame.getContentPane().add(textField);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField_1.setBounds(315, 411, 56, 25);
        textField_1.setColumns(10);
        textField_1.setToolTipText("botton");
        frame.getContentPane().add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField_2.setBounds(315, 213, 56, 25);
        textField_2.setColumns(10);
        textField_2.setToolTipText("height");
        frame.getContentPane().add(textField_2);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textField_4.setBounds(95, 12, 56, 25);
        textField_4.setColumns(10);
        textField_4.setToolTipText("displacement");
        frame.getContentPane().add(textField_4);
        
        JButton button = new JButton("Scale");
        button.setBounds(306, 474, 119, 30);
        button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
         		
     		   win2 tuna = new win2();
     		   tuna.setTextFieldText1(textField.getText());
     		   tuna.setTextFieldText2(textField_1.getText());
     		   tuna.setTextFieldText3(textField_2.getText());
     		   tuna.setTextFieldText4(textField_4.getText());
//     		   frame.dispose();
     		   tuna.setVisible(true);	
     		}
        });
        frame.getContentPane().add(button);
        
        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(435, 474, 119, 30);
        btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
				
				double d10 = d1+de;
    				
    				double di = de/d3;
    				double dii = Math.atan(di);
    				double diii = (float)((dii*180)/Math.PI);
    				
    				double diiii = 90-diii;
				
				if(d10<=d2 && de>=0) {
    
    			label_1.setText(String.format("%.2f°", diii));
    			label_2.setText(String.format("%.2f°", diiii));
    			label_3.setText(String.format("%.2f°", d9));
    			label_4.setText(String.format("%.2f°", d8));
			}else {
    				label_1.setText("");
    				label_2.setText("");
    				label_3.setText("");
    				label_4.setText("");
    				JOptionPane.showMessageDialog(null, "Something went wrong!" ,"Message", JOptionPane.INFORMATION_MESSAGE);

    			}
        	    }
        	}
        });
        frame.getContentPane().add(btnCalculate);
        
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(564, 474, 119, 30);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	    frame.getContentPane().add(btnNewButton);

       JLabel label = new JLabel();
       label.setBounds(20, 12, 650, 450);
       label.setIcon(new ImageIcon("C:\\Users\\Lorand\\eclipse-workspace\\szog\\src\\download2.jpg"));
       frame.getContentPane().add(label); 
	}
}
