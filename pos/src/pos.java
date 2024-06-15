import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class pos{
    static int x=30;
    static int y=25;
  
public static void main(String[] args) {
    frame(x,y);
}
public static void  frame (int x,int y){
     DefaultTableModel tableModel;

    JFrame frame = new JFrame("POS");

        // Set the default close operation and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1900, 1050); 



        // Create a JPanel with a FlowLayout for better component arrangement
        JPanel panel = new JPanel();




        // Create a JLabel to label the text field, e.g., for user ID
        JLabel labelbr = new JLabel("บาร์โค้ด ");
        labelbr.setBounds(x, y, 200, 30);
        labelbr.setFont(new Font("TH Krub", Font.BOLD, 24));
        JLabel labelhowmuch = new JLabel("จำนวน");
        labelhowmuch.setBounds(x+500, y, 200, 30);
        labelhowmuch.setFont(new Font("TH Krub", Font.BOLD, 24));


        // Create a JTextField with a specified width in columns
        JTextField textField = new JTextField(20);
        textField.setBounds(x, y+40, 200, 30);
        JTextField howmuch = new JTextField(20);
        howmuch.setBounds(x+500, y+40, 200, 30);
        
        String[] columnNames = {"ID", "name", "price"};
        Object[][] data = {
        //     {"John", "Doe", 28},
        //     {"Jane", "Doe", 25},
        //     {"Sara", "Smith", 30},
        //     {"Mike", "Brown", 35}
        };


        
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(x+5, y+150, 700, 800);
        table.setFillsViewportHeight(true);



        // Add the JLabel and JTextField to the JPanel
        panel.setLayout(null);
        panel.add(labelhowmuch);
        panel.add(howmuch);
        panel.add(labelbr);
        panel.add(textField);
        panel.add(scrollPane);
        // Add the JPanel to the JFrame
        
        frame.add(panel);
        // Set the JFrame to be visible
        frame.setVisible(true);

        HashMap<String, String> hash_map = new HashMap<>(); 

        hash_map.put("8850188242103", "โฟโมส");
    }
}

