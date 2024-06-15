package Gui;
import javax.swing.*;

import Button.ButtonClickListener;
import Button.ButtonEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShortestPanel extends JPanel {
    JButton kruskalButton;
    JButton primButton;
    JButton dijkstraButton;
    JButton automataButton;
    
    public ShortestPanel() {
        setupPanel();

        addButtonClickListener(kruskalButton, ButtonEvent::handleKruskalButtonClick);
        addButtonClickListener(primButton, ButtonEvent::handlePrimButtonClick);
        addButtonClickListener(dijkstraButton, ButtonEvent::handleDijkstraButtonClick);
        
    }

    private void setupPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        // Create buttons
        kruskalButton = new JButton("Kruskal's");
        primButton = new JButton("Prim's");
        dijkstraButton = new JButton("Dijkstra's");

        //new add by born
         automataButton = new JButton("Automata");
        // end


        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        int verticalSpacing = 10;
        buttonPanel.add(Box.createVerticalStrut(verticalSpacing));
        buttonPanel.add(kruskalButton);
        buttonPanel.add(Box.createVerticalStrut(verticalSpacing));
        buttonPanel.add(primButton);
        buttonPanel.add(Box.createVerticalStrut(verticalSpacing));
        buttonPanel.add(dijkstraButton);
            //new add by born
        buttonPanel.add(Box.createVerticalStrut(verticalSpacing));
        buttonPanel.add(automataButton);
            // end
        add(buttonPanel, BorderLayout.CENTER);

    }

    public void addButtonClickListener(JButton button, ButtonClickListener listener) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onButtonClick();
            }
        });
    }
    
}
