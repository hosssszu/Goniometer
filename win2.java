package szog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class win2 extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
	
	public void setTextFieldText1(String txt){
	    textField.setText(txt);
	}

	public void setTextFieldText2(String txt){
	    textField_1.setText(txt);
	}
	
	public void setTextFieldText3(String txt){
	    textField_2.setText(txt);
	}
		
	public void setTextFieldText4(String txt){
	    textField_3.setText(txt);
	}

	public void paint(Graphics g) {
		  
		String top = new String();
		top=textField.getText();
		Double d1 = Double.parseDouble(top);
		
		String botton = new String();
		botton=textField_1.getText();
		Double d2 = Double.parseDouble(botton);
		
		String height = new String();
		height=textField_2.getText();
		Double d3 = Double.parseDouble(height);
		
		String displacement = new String();
		displacement=textField_3.getText();
		Double d4 = Double.parseDouble(displacement);		
		
		double d5 = d1+d4;
		double d6 = 700/d2; //scale factor
		
		Double d7 = d2*d6; //botton
		Double d8 = d5*d6; //top
		Double d9 = d4*d6; // displacement
		Double d10 = d3*d6; // height
		
		Integer i1 = d7.intValue(); //botton
		Integer i2 = d8.intValue(); //top
		Integer i3 = d9.intValue(); //displacement
		Integer i4 = d10.intValue(); // height
		  
		int xpoints[] = {50, i1+50, i2+50, i3+50, 50};
		int ypoints[] = {550, 550, 550-i4, 550-i4, 550};
		int npoints = 5;
		   
		g.fillPolygon(xpoints, ypoints, npoints);
	}
	
	public win2() {
		setTitle("Scaled Image");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField(); //top
		textField.setBounds(693, 16, 86, 20);
		textField.setColumns(10);
		textField.setVisible(false);
		contentPane.add(textField);
		
		textField_1 = new JTextField();//botton
		textField_1.setBounds(693, 42, 86, 20);
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();//height
		textField_2.setBounds(693, 68, 86, 20);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();//displacement
		textField_3.setBounds(693, 94, 86, 20);
		textField_3.setColumns(10);	
		textField_3.setVisible(false);
		contentPane.add(textField_3);
	}
}