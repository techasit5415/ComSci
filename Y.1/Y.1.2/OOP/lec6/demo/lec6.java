import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class lec6 {
    public static void main(String[] args) {
        lec6 d1 = new lec6();
    }

    JFrame f;
    JButton btn;
    JLabel lbScore;
    JTextField tfScore;
    JButton lTile;
    JButton rTile;
    JButton btnNew;
    JButton btnNext;
    Icon blue300, orange300, kitty300, wrong300;
    boolean isLeftOpen = false, isRightOpen = false, hasPlayed = false;
    int turnvalue;

    lec6() {
        f = new JFrame();
        f.setSize(300, 300);
        detailComponents();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // secord phase

    }

    void detailComponents() {
        btnNext = new JButton("Next guess");
        lbScore = new JLabel("Score");
        tfScore = new JTextField("0");
        lTile = new JButton("blue");
        rTile = new JButton("orange");
        btnNew = new JButton("new game");
        btnNext.setPreferredSize(new Dimension(100, 50));
        lbScore.setPreferredSize(new Dimension(50, 50));
        tfScore.setPreferredSize(new Dimension(50, 50));
        lTile.setPreferredSize(new Dimension(100, 100));
        rTile.setPreferredSize(new Dimension(100, 100));
        btnNew.setPreferredSize(new Dimension(200, 50));

        f.setLayout(new FlowLayout());
        f.add(btnNext);
        f.add(lbScore);
        f.add(tfScore);
        f.add(lTile);
        f.add(rTile);
        f.add(btnNew);
        secordPhase();
        thirdPhase();
    }

    void secordPhase() {
        try {
            blue300 = new ImageIcon("img/blue300.png");
            orange300 = new ImageIcon("img/orange300.png");
            kitty300 = new ImageIcon("img/kitty300.png");
            wrong300 = new ImageIcon("img/wrong300.png");

        } catch (Exception e) {
            System.err.println(e);
        }
        lTile.setIcon(blue300);
        rTile.setIcon(orange300);

    }

    void thirdPhase() {
        MyActionListener listener = new MyActionListener();
        lTile.addActionListener(listener);
        rTile.addActionListener(listener);
        btnNext.addActionListener(listener);
        btnNew.addActionListener(listener);
        genAns();
    }

    private void genAns() {
        turnvalue = Math.random() > 0.49 ? 1 : 0;
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source == lTile && !hasPlayed) {
                if (turnvalue == 0) {
                    lTile.setIcon(kitty300);
                    int score = Integer.parseInt(tfScore.getText())+1;
                    tfScore.setText(""+score);
                } else {
                    lTile.setIcon(wrong300);
                    tfScore.setText("0");
                }
                hasPlayed = true;
            } else if (source == rTile && !hasPlayed) {
                if (turnvalue == 1) {
                    rTile.setIcon(kitty300);
                    int score = Integer.parseInt(tfScore.getText())+1;
                    tfScore.setText(""+score);
                } else {
                    rTile.setIcon(wrong300);
                    tfScore.setText("0");
                    
                }
                hasPlayed = true;
            } else if (source == btnNext) {
                lTile.setIcon(blue300);
                rTile.setIcon(orange300);
                hasPlayed = false;
                // tfScore.setText("0");
                genAns();
            }else if (source ==btnNew){
                tfScore.setText("0");
                lTile.setIcon(blue300);
                rTile.setIcon(orange300);
                hasPlayed = false;
            }
            // if(source == lTile){
            // if (isLeftOpen){
            // lTile.setIcon(blue300);
            // isLeftOpen = !isLeftOpen;
            // }else{
            // lTile.setIcon(kitty300);
            // isLeftOpen = !isLeftOpen;
            // }
            // }

            // else if(source == rTile){
            // if (isRightOpen){
            // rTile.setIcon(blue300);
            // isRightOpen = !isRightOpen;
            // }else{
            // rTile.setIcon(wrong300);
            // isRightOpen = !isRightOpen;
            // }
            // }
        }
    }

}
