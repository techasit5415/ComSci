import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

public class aaa {
    public static void main(String[] args) {
        aaa app = new aaa();
    }

    JFrame f;
    JTextField tf;
    JButton btn;

    aaa() {
        f = new JFrame("app Title");
        tf = new JTextField("full name");
        btn = new JButton("click me");
        tf.setBounds(50, 50, 150, 20);
        btn.setBounds(50, 100, 60, 30);
        // MyActionListner listener = new MyActionListner();
        // ActionListener listener = new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // tf.setText("from anony class");
        // }

        // };
        // btn.addActionListener(listener);

        btn.addActionListener(ev -> tf.setText("from lamda"));

        f.add(tf);
        f.add(btn);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void demooptionPane() {
        String name = JOptionPane.showInputDialog("what is your name?");
        JOptionPane.showMessageDialog(null, "hello" + name);
    }

    // private class MyActionListner implements ActionListener {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // tf.setText("from private class");
    // }
    // }

}