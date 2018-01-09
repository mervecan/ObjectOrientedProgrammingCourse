package PresentationLayer;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BusinessLayer.Calculation;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class Information extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	//Launch app
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information frame = new Information();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create frame
	public Information() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male"}));
		comboBox.setBounds(25, 75, 91, 20);
		contentPane.add(comboBox);
		
		JLabel lblPleaseFillYour = new JLabel("Please Fill Your Information");
		lblPleaseFillYour.setBounds(25, 11, 193, 14);
		contentPane.add(lblPleaseFillYour);
		
		JLabel lblYourWeightinKg = new JLabel("Your Weight (in kg)");
		lblYourWeightinKg.setBounds(25, 125, 125, 14);
		contentPane.add(lblYourWeightinKg);
		
		textField = new JTextField();
		textField.setBounds(25, 150, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblYourHeightin = new JLabel("Your height (in cm)");
		lblYourHeightin.setBounds(25, 192, 125, 14);
		contentPane.add(lblYourHeightin);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 217, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(27, 260, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 285, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(25, 327, 89, 23);
		contentPane.add(btnNext);
		
		JLabel lblNotePleaseDo = new JLabel("NOTE: Please do not enter String!");
		lblNotePleaseDo.setBounds(25, 38, 226, 14);
		contentPane.add(lblNotePleaseDo);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String gender = null;
				Double weight = (double) 0;
				Double height = (double) 0;
				int age = 0;
				
				Calculation cal = null;
				if(textField.getText().equals("")|| textField_1.getText().equals("") || textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill!", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(Double.valueOf(textField.getText()) <0 || Double.valueOf(textField_1.getText()) <0 ||Integer.valueOf(textField_2.getText()) <0) {
					JOptionPane.showMessageDialog(null, "Please do not enter negative number", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
				try {
					cal = new Calculation();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gender = comboBox.getSelectedItem().toString();
				weight = Double.valueOf(textField.getText());
				height = Double.valueOf(textField_1.getText());
				age = Integer.valueOf(textField_2.getText());
				cal.calculateMaxCalorie(gender, weight, height, age);
				System.out.println("Max Calorie: "+cal.calculateMaxCalorie(gender, weight, height, age));
				if(cal.calculateMaxCalorie(gender, weight, height, age)<0) {
					JOptionPane.showMessageDialog(null, "Max calorie cannot less than 0!", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
				 try
				  {
				  MealSelection frame=new MealSelection();
				 
				  frame.setVisible(true);
				  }
				  catch(Exception e)
				  {
					  JOptionPane.showMessageDialog(null, e.getMessage());
					  }
				  }
				}
			}
		});

		
		
	}
}
