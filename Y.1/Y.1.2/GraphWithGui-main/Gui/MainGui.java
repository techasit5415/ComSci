package Gui;
import javax.security.auth.kerberos.KerberosCredMessage;
import javax.swing.*;

import Button.ButtonEvent;
import ControlState.AlgorithmType;
import ControlState.AnimationState;

import java.awt.*;

public class MainGui {

    static JSlider slider;
    public static JTextArea sideTextArea;
    public static JTextArea textArea;

    public static AnimationState animationState = AnimationState.IDLE;
    public static AlgorithmType algorithmType = AlgorithmType.NONE;

    static DrawingPanel drawingPanel;
    static ButtonEvent buttonEvent;

    public MainGui() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = createFrame();
            frame.setVisible(true);
        });
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        ShortestPanel shortestPanel = new ShortestPanel();

        frame.add(shortestPanel, BorderLayout.WEST);

        sideTextArea = new JTextArea();
        sideTextArea.setLineWrap(true);
        sideTextArea.setEditable(false);
        sideTextArea.setPreferredSize(new Dimension(130, 580));
        JScrollPane sideScrollPane = new JScrollPane(sideTextArea);

        JPanel sidePanel = new JPanel(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(150, 700));
        sidePanel.add(sideScrollPane, BorderLayout.CENTER);

        frame.add(sidePanel, BorderLayout.EAST);

        drawingPanel = new DrawingPanel();

        JButton bfsButton = new JButton("BFS");
        JButton dfsButton = new JButton("DFS");
        JButton resetButton = new JButton("Reset");

        

        textArea = new JTextArea("Click anywhere on this empty space to create a vertex.");

        slider = new JSlider(JSlider.HORIZONTAL, 500, 3000, 500);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));


        JPanel textPanel = new JPanel();
        textPanel.add(textArea);

        bottomPanel.add(textPanel);

        JPanel buttonsAndSliderPanel = new JPanel();
        buttonsAndSliderPanel.setLayout(new FlowLayout());
        buttonsAndSliderPanel.add(bfsButton);
        buttonsAndSliderPanel.add(dfsButton);
        buttonsAndSliderPanel.add(slider);
        buttonsAndSliderPanel.add(resetButton);

        bottomPanel.add(buttonsAndSliderPanel);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(drawingPanel, BorderLayout.CENTER);

        buttonEvent = new ButtonEvent(drawingPanel, getSilderValue());

        bfsButton.addActionListener(e -> buttonEvent.startBFSAlgorithm());
        dfsButton.addActionListener(e -> buttonEvent.startDFSAlgorithm());
        resetButton.addActionListener(e -> drawingPanel.reset());

        frame.setVisible(true);
        return frame;
    }

    public static int getSilderValue() {
        return slider.getValue();
    }

    public static AnimationState getAnimationState() {
        return animationState;
    }

    public static void setAnimationState(AnimationState animationState) {
        MainGui.animationState = animationState;
    }

    public static AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public static void setAlgorithmType(AlgorithmType algorithmType) {
        MainGui.algorithmType = algorithmType;
    }

    public static void setToStandard() {
        MainGui.animationState = AnimationState.IDLE;
        MainGui.algorithmType = AlgorithmType.NONE;
    }

   
    
}