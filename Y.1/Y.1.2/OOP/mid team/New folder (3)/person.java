class person {
    private String name;
    private Level level = Level.NO_OB;

    public person(String name){
        this.name = name;
    }
    public void promote(){
        if (level==Level.NO_OB){}

    @Override
    public String toString(){
        return name + " " + level;
    }

    public static void main(String[] args) {
        person p1 = new person("Yindee");
        System.out.println(p1.toString());
        p1.promote();
        System.out.println(p1.toString());
        p1.promote();
        System.out.println(p1.toString());
        p1.promote();
        System.out.println(p1.toString());
        
    }
}
