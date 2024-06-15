package automata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AutomataAlgorithm {
    Map<String, Map<Integer, String>> state = new HashMap<>();
    String current;
    boolean accept;
    List<String> statefinal = new ArrayList<>();
    // Scanner sc = new Scanner(System.in);

    public AutomataAlgorithm(int stateFinite) {
        for (int i = 0; i < stateFinite; i++) {
            Map<Integer, String> tmp = new HashMap<>();
            String tmpString = String.format("S%d", i);

            for (int j = 0; j < 2; j++) {
                String nextState = JOptionPane.showInputDialog(null,
                        "Line " + j + " Connect Next State for S " + i);
                tmp.put(j, nextState);
            }
            state.put(tmpString, tmp);
        }
        this.current = JOptionPane.showInputDialog(null, "Input your first state : ");
        String F = JOptionPane.showInputDialog(null, "Input your accept state : ");
        String[] finalStete = F.split(" ");
        for (String f : finalStete) {

            statefinal.add(f);
        }
        JOptionPane.showMessageDialog(null, state.entrySet());
    }

    public void Accept(long finite) {
        List<Integer> input = new ArrayList<>();
        String finiteString = String.valueOf(finite);

        for (int i = 0; i < finiteString.length(); i++) {
            input.add(Integer.parseInt(String.valueOf(finiteString.charAt(i))));
        }
        for (int i : input) {
            current = state.get(current).get(i);
        }

        this.accept = (statefinal.contains(current)) ? true : false;

        if (accept) {
            JOptionPane.showMessageDialog(null, "Accept ");
        } else {
            JOptionPane.showMessageDialog(null, "Reject ");
        }
    }
}