package sidoti.gary.mainpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Default seed used for both cases
		 */
		JavaRandomNumber javaDefault = new JavaRandomNumber();
		MersenneTwister twister = new MersenneTwister();

		/*
		 * Create the view
		 */
		View frame = new View();
		frame.setVisible(true);
		frame.comboBox.addItem(javaDefault);
		frame.comboBox.addItem(twister);
		frame.btnGenerateRandomNumbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomGenerator res = (RandomGenerator) frame.comboBox.getSelectedItem();
				String tmp = "";
				for(int i =1;i<=5;i++){
					tmp = tmp + i+") "+res.getRandomNum()+"\n";
				}
				frame.textField.setText(tmp);
			}
		});
		
		/*
		 * First time I had worked with dynamic class loading.
		 */
		frame.btnImportExternalImplementation.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	          JFileChooser fileChooser = new JFileChooser();
	          int returnValue = fileChooser.showOpenDialog(null);
	          if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
					try {
						URLClassLoader cL = new URLClassLoader(new URL[]{new File(file.getParent()).toURI().toURL()});
						Class c = cL.loadClass(file.getName().replace(".class", ""));
						Object o = c.newInstance();
						Method m = c.getMethod("getRandomNum");
						String tmp = "";
						for(int i =1;i<=5;i++){
							tmp = tmp + i+") "+m.invoke(o)+"\n";
						}
						frame.textField.setText(tmp);
					} catch (Exception  e) {
						e.printStackTrace();
					}
	            System.out.println(file.getName());
	          }
	        }
	      });
		
		
	}
}
