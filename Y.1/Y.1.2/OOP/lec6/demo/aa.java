import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;


public class aa implements ActionListener{
    public static void main(String[] args) {
        aa app = new aa();
    }
    JFrame f;
    JTextField tf;
    JButton btn;


    aa(){
        f= new JFrame("app Title");
        tf = new JTextField("full name");
        btn = new JButton("click me");
        tf.setBounds(50,50,150,20);
        btn.setBounds(50,100,60,30);

        btn.addActionListener(this);
        f.add(tf);
        f.add(btn);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        tf.setText("from mettad");
    }
    
}