package Checkbill;

// import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
// import javax.swing.JCheckBox;
// import javax.swing.JRadioButton;
// import java.util.ArrayList;

//คลาสข้อมูลส่วนตัว
public class Personal_Information extends keepall  {

	JFrame frame;
	private JTextField NameText;
	private JTextField AddressText;
	private JTextField PNBText;
	private String name;
	private String address;
	private String phone_number;
	private String delivery;
	
	public Personal_Information(String name, String address, String phone_number, String delivery) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.delivery = delivery;
	}
	public String getname() {
        return name ;		
	}
	public String getaddress() {
		return address ;
	}
	public String getphone_number() {
		return phone_number ;
	}
	public String getdelivery() {
		return delivery ;
	}

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			Personal_Information window = new Personal_Information();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the application.
	 */
	public Personal_Information() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ข้อมูล");
		frame.setBounds(100, 100, 499, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Name = new JLabel("ชื่อผู้รับสินค้า :");
		Name.setForeground(new Color(0, 0, 0));
		Name.setFont(new Font("TH Krub", Font.BOLD, 28));
		Name.setBounds(33, 25, 132, 31);
		frame.getContentPane().add(Name);
		
		JLabel Address = new JLabel("ที่อยู่จัดส่ง :");
		Address.setForeground(new Color(0, 0, 0));
		Address.setFont(new Font("TH Krub", Font.BOLD, 28));
		Address.setBounds(33, 82, 105, 32);
		frame.getContentPane().add(Address);
		
		JLabel PNB = new JLabel("เบอร์โทรผู้รับสินค้า :");
		PNB.setForeground(new Color(0, 0, 0));
		PNB.setFont(new Font("TH Krub", Font.BOLD, 28));
		PNB.setBounds(33, 143, 180, 31);
		frame.getContentPane().add(PNB);
		
		NameText = new JTextField();
		NameText.setBackground(new Color(255, 230, 255));
		NameText.setBounds(240, 29, 120, 31);
		frame.getContentPane().add(NameText);
		NameText.setColumns(10);
		String inputText = NameText.getText();
		setName(inputText);
		AddressText = new JTextField();
		AddressText.setBackground(new Color(255, 230, 255));
		AddressText.setBounds(240, 87, 212, 31);
		frame.getContentPane().add(AddressText);
		AddressText.setColumns(10);
		String inputadd = NameText.getText();
		setAddress(inputadd);
		PNBText = new JTextField();
		PNBText.setBackground(new Color(255, 230, 255));
		PNBText.setBounds(240, 147, 144, 31);
		frame.getContentPane().add(PNBText);
		PNBText.setColumns(10);
		String inputtel = NameText.getText();
		setTel(inputtel);
		//ปุ่ม Back ไปยังหน้า.......
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product_Information window = new Product_Information();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("TH Krub", Font.BOLD, 30));
		btnNewButton.setBounds(61, 269, 86, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel Delivery = new JLabel("การจัดส่ง :");
		Delivery.setForeground(new Color(0, 0, 0));
		Delivery.setFont(new Font("TH Krub", Font.BOLD, 28));
		Delivery.setBounds(33, 207, 105, 24);
		frame.getContentPane().add(Delivery);
		
		//ปุ่มพิมพ์ใบเสร็จ
		JButton BillButton = new JButton("พิมพ์ใบเสร็จ");
		BillButton.setForeground(new Color(255, 255, 255));
		BillButton.setBackground(new Color(71, 35, 35));
		BillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bill_of_receipt window = new Bill_of_receipt();
				window.frame.setVisible(true);
				frame.setVisible(false);
				// printNames();
			
			}
		});
		
		BillButton.setFont(new Font("TH Krub", Font.BOLD, 28));
		BillButton.setBounds(301, 269, 151, 41);
		frame.getContentPane().add(BillButton);
		
		
		JComboBox <String> DeliCombo = new JComboBox<String>();
		DeliCombo.setEditable(true);
		DeliCombo.setBackground(new Color(255, 255, 255));
		DeliCombo.setBounds(240, 208, 212, 31);
		frame.getContentPane().add(DeliCombo);
		
		DeliCombo.addItem("Flash Express Price 30 baht.");
		DeliCombo.addItem("Kerry Express Price 50 baht.");
		DeliCombo.addItem("Thailand Post Price 35 baht.");
		
		DeliCombo.setSelectedItem("");
	
      }
}
