class Coin {
    String tailColor;
    boolean isHead;
    Coin(String color){
        tailColor = color;
        isHead = true;
    }
    @Override
    public String toString(){
        return "I am a coin object with tailColor = " + tailColor + ". My isHead is " + isHead;
    }
    void filp(){
        if(isHead)
            System.out.println("From filp() -> I am head my color is SILVER (my tailColor is " + tailColor + ")");
        else
            System.out.println("From filp() -> My face color is " + tailColor);
        isHead = !isHead;
    }
    void hit(Coin c){
        this.filp();
        c.filp();
    }
    void hit(Coin c1, Coin c2){
        System.out.println("Coin with tailColor = " + this.tailColor + " hits me.");
        c1.filp();
        System.out.println("Coin with tailColor = " + this.tailColor + " hits me.");
        c2.filp();
        this.filp();
    }
}