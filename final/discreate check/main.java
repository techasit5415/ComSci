import javax.swing.JOptionPane;

import automata.AutomataAlgorithm;

public class main {
    public static void main(String[] args) {
     
        String state = JOptionPane.showInputDialog(null, "Enter state:");
       int getstateFinite = Integer.parseInt(state);
       String finite = JOptionPane.showInputDialog(null, "Enter finite:");
       long getfinite = Integer.parseInt(finite);

       AutomataAlgorithm a1 = new AutomataAlgorithm(getstateFinite);
       a1.Accept(getfinite);

    }
}
