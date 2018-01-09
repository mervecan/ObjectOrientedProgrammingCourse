package PresentationLayer;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import BusinessLayer.Calculation;
import BusinessLayer.Nutrition;
import BusinessLayer.NutritionType;
import DataAccessLayer.DataAccessLayer;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 * 
 * @author Merve Can - Türkan Demirci, 210201033 - 210201048
 *
 */
public class MealSelection extends JFrame implements ActionListener {

	ButtonGroup bg;
	Calculation cal = new Calculation();
	DataAccessLayer dal = new DataAccessLayer();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnAscending;
    private JButton btnDescending;
    private JButton btnAdd;
    private JButton btnCheck;
    
	//launch app
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MealSelection frame = new MealSelection();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//create frame
	public MealSelection() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JRadioButton rdbtnBreakfast = new JRadioButton("Breakfast");
		rdbtnBreakfast.setBounds(5, 60, 109, 23);
		contentPane.add(rdbtnBreakfast);
		
		JRadioButton rdbtnLunch = new JRadioButton("Lunch");
		rdbtnLunch.setBounds(5, 86, 109, 23);
		contentPane.add(rdbtnLunch);
		
		JRadioButton rdbtnDinner = new JRadioButton("Dinner");
		rdbtnDinner.setBounds(5, 112, 109, 23);
		contentPane.add(rdbtnDinner);
		
		bg = new ButtonGroup();
		bg.add(rdbtnBreakfast);
		bg.add(rdbtnLunch);
		bg.add(rdbtnDinner);
		
		
		
		rdbtnBreakfast.setActionCommand("Breakfast");
		rdbtnLunch.setActionCommand("Lunch");
		rdbtnDinner.setActionCommand("Dinner");	
		
		rdbtnBreakfast.addActionListener((ActionListener) this);
		rdbtnLunch.addActionListener((ActionListener) this);
		rdbtnDinner.addActionListener((ActionListener) this);
		
		table = new JTable();
		table.setBounds(133, 50, 291, 350);
		contentPane.add(table);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(25, 312, 89, 23);
		contentPane.add(btnAdd);
		
		btnAscending = new JButton("Ascending");
		btnAscending.setBounds(5, 166, 89, 23);
		contentPane.add(btnAscending);
		
		btnDescending = new JButton("Descending");
		btnDescending.setBounds(5, 200, 89, 23);
		contentPane.add(btnDescending);
		
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		btnCheck = new JButton("Check");
		btnCheck.setBounds(25, 346, 89, 23);
		contentPane.add(btnCheck);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setBounds(25, 377, 89, 23);
		contentPane.add(btnSaveFile);
		
		JLabel lblPleaseAddOne = new JLabel("Please add nutrition one by one");
		lblPleaseAddOne.setBounds(25, 11, 253, 14);
		contentPane.add(lblPleaseAddOne);
		
		btnCheck.setVisible(false);
		btnSaveFile.setVisible(false);
		
		btnAdd.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		        
		    	int[] selectedRow = table.getSelectedRows();
		       
		        	for (int i = 0; i < selectedRow.length; i++) {
		        	Nutrition nutritionOb = new Nutrition();
		        	nutritionOb.setName((String) table.getValueAt(selectedRow[i], 0));
		        	nutritionOb.setUnit(Double.parseDouble((String) table.getValueAt(selectedRow[i], 1)));
		        	nutritionOb.setCalorie(Double.parseDouble((String)table.getValueAt(selectedRow[i], 2)));
		        	nutritionOb.setType(NutritionType.valueOf((String)table.getValueAt(selectedRow[i], 3)));
		        	nutritionOb.setFoodOrDrink((String)table.getValueAt(selectedRow[i], 4));
		            cal.addNutritionList(nutritionOb);
		            
		        	}
		    }
		});
		
		btnCheck.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		            boolean check = cal.checkCalorie();
		            if(check==true) {
		            	JOptionPane.showMessageDialog(null, "You don't exceed daily calorie limit.");
		            	btnSaveFile.setVisible(true);
		            }else if(check==false) {
		            	JOptionPane.showMessageDialog(null, "You exceed daily calorie limit!", "Error", JOptionPane.ERROR_MESSAGE);
		            	btnSaveFile.setVisible(false);
		            }
		    }
		});

		btnSaveFile.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
		    	ArrayList<Nutrition> dailyList = new ArrayList<Nutrition>();
		    	dailyList = cal.returnList();
		    	boolean check = dal.writeFile(dailyList);
		    	if(check==true) {
		    		JOptionPane.showMessageDialog(null, "Saved successfully into dailyNutritions.dat");
		    	}else if(check==false) {
		    		JOptionPane.showMessageDialog(null, "Cannot saved!", "Error", JOptionPane.ERROR_MESSAGE);
		    	}
		    }
		});
		
	}
	ArrayList<Nutrition> nutritionList = cal.breakfastList();
	public void actionPerformed(ActionEvent e) {
		
		  
		    if(bg.getSelection().getActionCommand().equals("Breakfast")) {
		    	
		    	DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
		        for (Nutrition n : nutritionList) {
		            model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
		            table.setModel(model);
		        }

				btnAscending.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ArrayList<Nutrition> ascendingBreakfastList=cal.ascendingOrder(nutritionList);
						DefaultTableModel model = new DefaultTableModel();
						 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
				        for (Nutrition n : ascendingBreakfastList) {
				        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
				            table.setModel(model);
				        }
					}});
				btnDescending.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ArrayList<Nutrition> decendingBreakfastList=cal.descendingOrder(nutritionList);
						DefaultTableModel model = new DefaultTableModel();
						 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
				        for (Nutrition n : decendingBreakfastList) {
				        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
				            table.setModel(model);
				        }
					}});
		    }else if(bg.getSelection().getActionCommand().equals("Lunch")) {
		    	ArrayList<Nutrition> nutritionLunchList = cal.lunchList();
		    	DefaultTableModel model = new DefaultTableModel();
		    	 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
		        for (Nutrition n : nutritionLunchList) {
		        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
		            table.setModel(model);
		        }
		        btnAscending.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ArrayList<Nutrition> ascendingLunchList=cal.ascendingOrder(nutritionLunchList);
						DefaultTableModel model = new DefaultTableModel();
						 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
				        for (Nutrition n : ascendingLunchList) {
				        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
				            table.setModel(model);
				        }
					}});
				btnDescending.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ArrayList<Nutrition> decendingLunchList=cal.descendingOrder(nutritionLunchList);
						DefaultTableModel model = new DefaultTableModel();
						 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
				        for (Nutrition n : decendingLunchList) {
				        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
				            table.setModel(model);
				        }
					}});
				
			
              }else if(bg.getSelection().getActionCommand().equals("Dinner")) {
            	  btnCheck.setVisible(true);
		    	ArrayList<Nutrition> nutritionDinnerList = cal.dinnerList();
		    	DefaultTableModel model = new DefaultTableModel();
		    	 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
		        for (Nutrition n : nutritionDinnerList) {
		        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
		            table.setModel(model);
		        }
		        btnAscending.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ArrayList<Nutrition> ascendingDinnerList=cal.ascendingOrder(nutritionDinnerList);
						DefaultTableModel model = new DefaultTableModel();
						 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
				        for (Nutrition n : ascendingDinnerList) {
				        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
				            table.setModel(model);
				        }
					}});
				btnDescending.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						ArrayList<Nutrition> decendingDinnerList=cal.descendingOrder(nutritionDinnerList);
						DefaultTableModel model = new DefaultTableModel();
						 model.setColumnIdentifiers(new String[]{"Name", "Unit", "Cal", "Type", "Food/Drink"});
				        for (Nutrition n : decendingDinnerList) {
				        	model.addRow(new String[]{n.getName(),String.valueOf(n.getUnit()),String.valueOf(n.getCalorie()),String.valueOf(n.getType()),String.valueOf(n.getFoodOrDrink())});
				            table.setModel(model);
				        }
					}});
		    }
		}
}