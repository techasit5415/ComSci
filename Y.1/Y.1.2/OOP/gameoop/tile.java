package gameoop;
public class tile{
    public int x,y;
    public boolean black;
    public int animateY;
    public boolean inTile(int x,int y)
    {
        return  (x > this.x && x < this.x + remember.TILE_WIDTH && y > this.y && y < this.y + remember.TILE_HEIGHT);
    }
    }
