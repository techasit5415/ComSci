package Checkbill;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JPanel;

//คลาสข้อมูลสินค้า
public class Product_Information extends Personal_Information   {   

	protected static final JComboBox<String> Product = null;
	protected static final AbstractButton AddaList = null;
	JFrame frame;
	private JTable table;
	private JTextField TotalText;
	private JTextField QuantityText;
	protected DefaultTableModel tableModel;
	protected double total;
	private String product;
	private int quantity;
	private int amount;
	protected JTextComponent lblNewLabel_2;
	private int price;
	
	
    /**
	 * Launch the application.
	 */
	
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				Product_Information window = new Product_Information();
	// 				window.frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }
	
	
	/**
	 * Create the application.
	 */
	public Product_Information() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ข้อมูลสินค้า");
		frame.setBounds(100, 100, 675, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(52, 102, 558, 182);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane Table = new JScrollPane();
		Table.setBounds(0, 11, 558, 156);
		panel.add(Table);
		Table.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table = new JTable(tableModel);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("TH Krub", Font.BOLD, 20));
		Table.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Price", "Quantity", "Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(218);
		table.setBackground(new Color(255, 255, 255));
		
		
		TotalText = new JTextField();
		TotalText.setBounds(146, 336, 107, 25);
		frame.getContentPane().add(TotalText);
		TotalText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ชื่อสินค้า");
		lblNewLabel.setFont(new Font("TH Krub", Font.BOLD, 24));
		lblNewLabel.setBounds(52, 18, 73, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("จำนวน");
		lblNewLabel_3.setFont(new Font("TH Krub", Font.BOLD, 24));
		lblNewLabel_3.setBounds(375, 19, 97, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		QuantityText = new JTextField();
		QuantityText.setBounds(375, 49, 73, 20);
		frame.getContentPane().add(QuantityText);
		QuantityText.setColumns(10);
		
		JComboBox<String> Product = new JComboBox <String> ();
		Product.setEditable(true);
		Product.setToolTipText("");
		Product.setBounds(52, 48, 278, 22);
		frame.getContentPane().add(Product);
		
		//ปุ่ม Clear
		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuantityText.setText("") ;
				Product.setSelectedItem("") ;
				TotalText.setText("");
				tableModel.setRowCount(0) ;
			}
		});
		
		btnNewButton_2.setFont(new Font("TH Krub", Font.BOLD, 20));
		btnNewButton_2.setBounds(417, 295, 91, 23);
		frame.getContentPane().add(btnNewButton_2);
		    
		Product.addItem("Singha drinking water 600 ml. Price 7 baht.");
		Product.addItem("Crystal drinking water 1.5 L Price 14 baht.");
		Product.addItem("Milo UHT 110 ml. Price 13 baht.");
		Product.addItem("Lactasoy UHT original 300 ml. Price 15 baht.");
		Product.addItem("Mama Cup 60 g. Price 18 baht.");
		Product.addItem("Rosa canned fish 155 g. Price 20 baht.");
		Product.addItem("Ros Dee 155 g. Price 27 baht.");
		Product.addItem("Lay's Original Flavor 116 g. Price 20 baht.");
		Product.addItem("Halls Fresh Lime Lemon 34 g. Price 5 baht.");
		Product.addItem("Neely Crackers 40 g. Price 12 baht.");
		
		Product.setSelectedItem("");
		
		//ปุ่มเพิ่มรายการสินค้า
		JButton btnAddaList = new JButton("เพิ่มรายการ");
		btnAddaList.setForeground(new Color(255, 255, 255));
		btnAddaList.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent e) {

		    	

		    	if (Product.getSelectedItem()  == "Singha drinking water 600 ml. Price 7 baht.") {
		    		String product = "Singha drinking water 600 ml" ;
		    		int price = 7 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		    	
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		      
		    }
		    	if (Product.getSelectedItem()  == "Crystal drinking water 1.5 L Price 14 baht.") {
		    		String product = "Crystal drinking water 1.5 L" ;
		    		int price = 14 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		       
		    }
		    	if (Product.getSelectedItem()  == "Milo UHT 110 ml. Price 13 baht.") {
		    		String product = "Milo UHT 110 ml." ;
		    		int price = 13 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		      
		    }
		    	if (Product.getSelectedItem()  == "Lactasoy UHT original 300 ml. Price 15 baht.") {
		    		String product = "Lactasoy UHT original 300 ml." ;
		    		int price = 15 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		        
		    }
		    	if (Product.getSelectedItem()  == "Mama Cup 60 g. Price 18 baht.") {
		    		String product = "Mama Cup 60 g." ;
		    		int price = 18 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		        
		    }
		    	if (Product.getSelectedItem()  == "Rosa canned fish 155 g. Price 20 baht.") {
		    		String product = "Rosa canned fish 155 g." ;
		    		int price = 20 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		    	
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		        
		    }
		    	if (Product.getSelectedItem()  == "Ros Dee 155 g. Price 27 baht.") {
		    		String product = "Ros Dee 155 g." ;
		    		int price = 27 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		        
		    }
		    	if (Product.getSelectedItem()  == "Lay's Original Flavor 116 g. Price 20 baht.") {
		    		String product = "Lay's Original Flavor 116 g." ;
		    		int price = 20 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		    
		    }
		    	if (Product.getSelectedItem()  == "Halls Fresh Lime Lemon 34 g. Price 5 baht.") {
		    		String product = "Halls Fresh Lime Lemon 34 g." ;
		    		int price = 5 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		        
		    }
		    	if (Product.getSelectedItem()  == "Neely Crackers 40 g. Price 12 baht.") {
		    		String product = "Neely Crackers 40 g." ;
		    		int price = 12 ;
		    		int quantity = Integer.parseInt(QuantityText.getText()) ;
		    		int amount = price * quantity ;
					setHashMap(product,price);
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.addRow(new Object [] {product , price, quantity, amount} );
		        
		    	}
		    }
		});
		
		btnAddaList.setBackground(new Color(64, 0, 0));
		btnAddaList.setFont(new Font("TH Krub", Font.BOLD, 24));
		btnAddaList.setBounds(493, 35, 117, 43);
		frame.getContentPane().add(btnAddaList);
		
		JLabel lblNewLabel_1 = new JLabel("เงินรวม :");
		lblNewLabel_1.setFont(new Font("TH Krub", Font.BOLD, 24));
		lblNewLabel_1.setBounds(72, 335, 73, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		//ปุ่ม Delete
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel TableModel = (DefaultTableModel) table.getModel();
				if(table.getSelectedRowCount() == 1) {
					TableModel.removeRow(table.getSelectedRow());
	            } 
				else {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.") ;
					}
					else {
						JOptionPane.showMessageDialog(null, "Please select Single For Delete.") ;
					}
				};
			}
		});
		
		btnNewButton.setFont(new Font("TH Krub", Font.BOLD, 20));
		btnNewButton.setBounds(519, 295, 91, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("คิดเงิน");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total = 0;
		        for(int i = 0; i<table.getRowCount(); i++) {
		        	int amount = Integer.parseInt(table.getValueAt(i, 3).toString()) ;
		        	total += amount ;
		        }
		        TotalText.setText(String.format("%, .2f", total));
				
				setMoney(total);
			}
		});
		btnNewButton_3.setFont(new Font("TH Krub", Font.BOLD, 22));
		btnNewButton_3.setBounds(263, 328, 77, 35);
		frame.getContentPane().add(btnNewButton_3);
	
		  //ปุ่ม Next ไปยังหน้า......
	     JButton btnNewButton_1 = new JButton("Next");
	     btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 Personal_Information window = new Personal_Information();
        	 DefaultTableModel model = (DefaultTableModel) table.getModel();
        	 window.frame.setVisible(true);
			 frame.setVisible(false);
		}
	});
	btnNewButton_1.setForeground(new Color(0, 0, 0));
	btnNewButton_1.setBackground(new Color(192, 192, 192));
	btnNewButton_1.setFont(new Font("TH Krub", Font.BOLD, 30));
	btnNewButton_1.setBounds(515, 336, 95, 34);
	frame.getContentPane().add(btnNewButton_1);
	}
	
	public Product_Information(String product, int price, int quantity, int amount, double total) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.total = total ;
	}
	public String getproduct() {
        return product ;		
	}
	public int getprice() {
		return price ;
	}
	public int getquantity() {
		return quantity ;
	}
	public int getamount() {
		return amount ; 
	}
	public double total() {
		return total;
	}
}

	