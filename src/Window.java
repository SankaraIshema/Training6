import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame {
	
	JButton button = new JButton("Call the ZDialog");
	
	public Window() {
		this.setTitle("My beautiful window");
		this.setSize(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(button);
		
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			
			public void actionPerformed(ActionEvent e) {
				ZDialog zDialog = new ZDialog(null, "My astounishing caracter", true);
				ZDialogInfo zInfo = zDialog.showZDialog();
				
				JOptionPane dialogBox = new JOptionPane();
				dialogBox.showMessageDialog(null, zInfo.toString(), "Caracter Informations", 
																		JOptionPane.INFORMATION_MESSAGE);
			}
		});
		this.setVisible(true);
	}
}
