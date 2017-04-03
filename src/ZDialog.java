import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ZDialog extends JDialog{
	
	private ZDialogInfo zInfo;
	private JLabel iconLabel, nameLabel, genderLabel, hairLabel, heightLabel, secondHeightLabel;
	private JTextField name;
	private JTextField height;
	private JComboBox<String> gender;
	private JComboBox<String> hair;
	private JRadioButton ageSpan1, ageSpan2, ageSpan3, ageSpan4;

	public ZDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		
		this.setSize(650, 270);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.initComponent();
		
	}
	
	private void initComponent() {
		
		//ICON
		iconLabel = new JLabel(new ImageIcon("assassinCreed3.jpg"));
		JPanel iconPane = new JPanel();
		iconPane.setBackground(Color.WHITE);
		iconPane.setLayout(new BorderLayout());
		iconPane.add(iconLabel);
		
		//NAME
		nameLabel = new JLabel("Enter a name");
		
		name = new JTextField();
		name.setPreferredSize(new Dimension(100, 25));
		
		JPanel namePane = new JPanel();
		namePane.setBackground(Color.WHITE);
		namePane.setPreferredSize(new Dimension(250, 60));
		namePane.setBorder(BorderFactory.createTitledBorder("Name of the Caracter : "));
		
		namePane.add(nameLabel);
		namePane.add(name);
		
		//GENDER
		genderLabel = new JLabel("Gender : ");
		
		gender = new JComboBox<>();
		gender.addItem("Undetermined");
		gender.addItem("Male");
		gender.addItem("Female");
		
		JPanel genderPane = new JPanel();
		genderPane.setBackground(Color.WHITE);
		genderPane.setPreferredSize(new Dimension(250, 60));
		genderPane.setBorder(BorderFactory.createTitledBorder("Gender of the Caracter : "));
		
		genderPane.add(genderLabel);
		genderPane.add(gender);
		
		//AGE		
		ageSpan1 = new JRadioButton("15 - 25 years old");
		ageSpan1.setSelected(true);
		ageSpan2 = new JRadioButton("26 - 35 years old");
		ageSpan3 = new JRadioButton("36 - 50 years old");
		ageSpan4 = new JRadioButton("50+ years old");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(ageSpan1);
		buttonGroup.add(ageSpan2);
		buttonGroup.add(ageSpan3);
		buttonGroup.add(ageSpan4);
		
		JPanel agePane = new JPanel();
		agePane.setBackground(Color.WHITE);
		agePane.setPreferredSize(new Dimension(500, 60));
		agePane.setBorder(BorderFactory.createTitledBorder("Age of the Caracter : "));
		
		agePane.add(ageSpan1);
		agePane.add(ageSpan2);
		agePane.add(ageSpan3);
		agePane.add(ageSpan4);
		
		//HAIR
		hairLabel = new JLabel("Hair color : ");
		
		hair = new JComboBox<>();
		hair.addItem("Blond");
		hair.addItem("Black");
		hair.addItem("Redhair");
		hair.addItem("Brown");
		hair.addItem("White");
		
		JPanel hairPane = new JPanel();
		hairPane.setBackground(Color.WHITE);
		hairPane.setPreferredSize(new Dimension(250, 60));
		hairPane.setBorder(BorderFactory.createTitledBorder("Hair of the Caracter : "));
		
		hairPane.add(hairLabel);
		hairPane.add(hair);
		
		//HEIGHT
		heightLabel       = new JLabel("Enter the Height : ");
		secondHeightLabel = new JLabel("cm");
		
		height = new JTextField("180");
		height.setPreferredSize(new Dimension(100, 25));
		
		JPanel heightPane = new JPanel();
		heightPane.setBackground(Color.WHITE);
		heightPane.setPreferredSize(new Dimension(250, 60));
		heightPane.setBorder(BorderFactory.createTitledBorder("Height of the Caracter : "));
		
		heightPane.add(heightLabel);
		heightPane.add(height);
		heightPane.add(secondHeightLabel);
		
		//ROUNDUP
		JPanel motherPane = new JPanel();
		motherPane.setBackground(Color.WHITE);
		motherPane.add(namePane);
		motherPane.add(genderPane);
		motherPane.add(agePane);
		motherPane.add(hairPane);
		motherPane.add(heightPane);
		
		//CONTROL
		JPanel controlPane   = new JPanel();
		JButton okButton     = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				zInfo = new ZDialogInfo(name.getText(), (String)gender.getSelectedItem(), 
											getAge(), (String)hair.getSelectedItem(), getHeight());
				setVisible(false);
			}
			
			public String getAge() {
				return (ageSpan1.isSelected()) ? ageSpan1.getText() :
					   (ageSpan2.isSelected()) ? ageSpan2.getText() :
					   (ageSpan3.isSelected()) ? ageSpan3.getText() :
					   (ageSpan4.isSelected()) ? ageSpan4.getText() :
					    ageSpan1.getText();
			}
			
			public String getHeight() {
				return (height.getText().equals("")) ? "180" : height.getText();
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
			}
		});
		
		controlPane.add(okButton);
		controlPane.add(cancelButton);
		
		this.getContentPane().add(iconPane, BorderLayout.WEST);
		this.getContentPane().add(motherPane, BorderLayout.CENTER);
		this.getContentPane().add(controlPane, BorderLayout.SOUTH);		
		
	}	
	
	public ZDialogInfo showZDialog() {
		this.setVisible(true);
		return this.zInfo;
	}
	
}
