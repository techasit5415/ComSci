import Gui.MainGui;
import automata.AutomataAlgorithm;

public class Main {

    static MainGui mainGui;

    public static void main(String[] args) {
        // mainGui = new MainGui();
        mainAutomata();
    }
    public static void mainAutomata(){
        AutomataAlgorithm a1 = new AutomataAlgorithm(5);
        a1.Accept(10111);
    }
   
}
