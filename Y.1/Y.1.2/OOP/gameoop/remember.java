package gameoop;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;

public class remember implements ActionListener {
    public final static int TILE_WIDTH=250,TILE_HEIGHT= 300;
    public static remember rem;
    public ArrayList<Tile> tiles;
    public Renderer renderer;
    public remember() 
    {
        JFrame frame = new JFrame();
        renderer = new Renderer();

        Timer timer = new Timer(20,this);
        frame.setSize(TILE_WIDTH*3,TILE_HEIGHT*3);
        frame.add(renderer);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }

    public static void main(String[] args) {
        rem = new remember();
    }

    public void render(Graphics g) {
        for(gameoop.tile tile : tiles){
            g.
            g.fillRect(tile.x*TILE_WIDTH, tile.y*TILE_HEIGHT-tile.animateY,TILE_WIDTH,TILE_HEIGHT);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}