package Checkbill;

// import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
// import javax.swing.ImageIcon;
import javax.swing.JButton;

//คลาสช่องทางการชำระเงิน
public class Payment {  

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			Payment window = new Payment();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 511, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ธนาคาร กสิกรไทย");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("TH Krub", Font.BOLD, 30));
		lblNewLabel.setBounds(160, 32, 180, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("เลขชัญชี :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("TH Krub", Font.BOLD, 24));
		lblNewLabel_1.setBounds(65, 208, 82, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ชื่อ :");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("TH Krub", Font.BOLD, 24));
		lblNewLabel_2.setBounds(65, 250, 45, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("FINISH");
		btnNewButton.setFont(new Font("TH Krub", Font.BOLD, 28));
		btnNewButton.setBounds(363, 275, 99, 31);
		frame.getContentPane().add(btnNewButton);
	}
}


