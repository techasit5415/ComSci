package Checkbill;

import java.awt.EventQueue;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

//คลาสบิลใบเสร็จ
public class Bill_of_receipt extends Personal_Information {

	JFrame frame;
	private String Name;
	

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			Bill_of_receipt window = new Bill_of_receipt();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Bill_of_receipt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("บิลใบเสร็จ");
		frame.setBounds(100, 100, 357, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	 Payment window = new Payment();
				 window.frame.setVisible(true);
				 frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("TH Krub", Font.BOLD, 22));
		btnNewButton.setBounds(231, 427, 69, 28);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Personal_Information window = new Personal_Information();
					window.frame.setVisible(true);
					frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("TH Krub", Font.BOLD, 22));
		btnNewButton_1.setBounds(35, 427, 77, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("บิลใบเสร็จ");
		lblNewLabel.setFont(new Font("TH Krub", Font.BOLD, 30));
		lblNewLabel.setBounds(132, 11, 102, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("***********************************");
		lblNewLabel_1.setFont(new Font("TH Krub", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 104, 321, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("รายการสินค้า");
		lblNewLabel_2.setFont(new Font("TH Krub", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 117, 87, 21);
		frame.getContentPane().add(lblNewLabel_2);
		

		keepall k1 = new keepall();
        k1.printNamesOnGUI(frame);

		JLabel lblNewLabel_3 = new JLabel("รวมการสั่งซื้อ :");
		lblNewLabel_3.setFont(new Font("TH Krub", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 298, 102, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("การจัดส่ง :");
		lblNewLabel_4.setFont(new Font("TH Krub", Font.BOLD, 20));
		lblNewLabel_4.setBounds(10, 332, 87, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ยอดชำระทั้งหมด :"  +getMoney()+"บาท");
		lblNewLabel_5.setFont(new Font("TH Krub", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 364, 200, 28);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel NameText = new JLabel("");
		NameText.setBounds(21, 79, 46, 14);
		frame.getContentPane().add(NameText);
		
	}
}
