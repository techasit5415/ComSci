package Button;

import Algorithm.KruskalAlgorithm;
import ControlState.AlgorithmType;
import ControlState.AnimationState;
import Gui.DrawingPanel;
import Gui.MainGui;
import automata.AutomataAlgorithm;

public class ButtonEvent{

    private static DrawingPanel drawingPanel;
    private static int animationDelay;

    public ButtonEvent(DrawingPanel drawingPanel, int animationDelay){
        this.drawingPanel = drawingPanel;
        this.animationDelay = animationDelay;

    }

    public static void startBFSAlgorithm() {
        if((MainGui.getAnimationState() == AnimationState.IDLE)){
            MainGui.setAnimationState(AnimationState.WAITING);
            MainGui.setAlgorithmType(AlgorithmType.BFS);
            MainGui.textArea.setText("");
            MainGui.textArea.setText(MainGui.textArea.getText() + "Select a vertex to start BFSAlgorithm.");
        }
    }

    public static void startDFSAlgorithm() {
        if(MainGui.getAnimationState() == AnimationState.IDLE){
            MainGui.setAnimationState(AnimationState.WAITING);
            MainGui.setAlgorithmType(AlgorithmType.DFS);
            MainGui.textArea.setText("");
            MainGui.textArea.setText(MainGui.textArea.getText() + "Select a vertex to start DFSAlgorithm.");
        }
        
    }

    public static void handleKruskalButtonClick() {
        MainGui.sideTextArea.append("Kruskal's Algorithm started.");
        MainGui.setAnimationState(AnimationState.RUNNING);
        KruskalAlgorithm kAlgorithm = new KruskalAlgorithm(drawingPanel, animationDelay);
        kAlgorithm.findMSTWithAnimation();
    }

    public static void handlePrimButtonClick() {
        MainGui.sideTextArea.append("Prim's Algorithm started.");
        if(MainGui.getAnimationState() == AnimationState.WAITING){
            MainGui.setAnimationState(AnimationState.WAITING);
            MainGui.setAlgorithmType(AlgorithmType.PRIM);
            MainGui.setAnimationState(AnimationState.RUNNING);
            MainGui.textArea.setText("");
            MainGui.textArea.setText(MainGui.textArea.getText() + "Select a vertex to start Prim's Algorithm.");
        }
        
    }

    public static void handleDijkstraButtonClick() {
        MainGui.sideTextArea.append("Dijkstra's Algorithm started.");
        if(MainGui.getAnimationState() == AnimationState.WAITING){
            MainGui.setAnimationState(AnimationState.WAITING);
            MainGui.setAlgorithmType(AlgorithmType.DIJKSTRA);
            MainGui.setAnimationState(AnimationState.RUNNING);
            MainGui.textArea.setText("");
            MainGui.textArea.setText(MainGui.textArea.getText() + "Select a vertex to start Dijkstra's Algorithm.");
        }
    }

}
