package sidoti.gary.mainpackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * 
 * @author gsidoti
 *
 */
public class View extends JFrame {

	private JPanel contentPane;
	JTextArea textField;
	JComboBox<RandomGenerator> comboBox;
	JButton btnGenerateRandomNumbers;
	JButton btnImportExternalImplementation;
	String filePath;
	
	

	/**
	 * Create the frame.
	 */
	public View() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
        setTitle("Gary Sidoti Random Number Generator");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<RandomGenerator>();
		comboBox.setBounds(6, 5, 273, 41);
		contentPane.add(comboBox);
		
		btnGenerateRandomNumbers = new JButton("Generate Random Numbers");
		btnGenerateRandomNumbers.setBounds(6, 52, 273, 35);
		contentPane.add(btnGenerateRandomNumbers);
		
		textField = new JTextArea();
		textField.setEditable(false);
		textField.setBounds(6, 100, 438, 145);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnImportExternalImplementation = new JButton("<html>Generate From<br>External Class</html>");
		btnImportExternalImplementation.setBounds(283, 7, 161, 80);
		contentPane.add(btnImportExternalImplementation);
	}
}
