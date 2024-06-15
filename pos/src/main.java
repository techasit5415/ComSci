import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class main{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Column Names
        String[] columnNames = {"First Name", "Last Name", "Age"};

        // Data
        Object[][] data = {
            {"John", "Doe", 28},
            {"Jane", "Doe", 25},
            {"Sara", "Smith", 30},
            {"Mike", "Brown", 35}
        };

        // Creating a table model and configuring the JTable
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // Adding the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // Add the scroll pane to the frame
        frame.add(scrollPane);
        frame.pack();  // Pack the frame to the contents
        frame.setVisible(true);
    }
}
