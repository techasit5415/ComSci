package solutions.pack1;

public class Dog_660160 {
    private Breed_660160 b;
    private int weight;
    public Dog_660160(Breed_660160 breed,int w){
        b=breed ;
        weight = w;
    }
    public Breed_660160 getB() {
        return b;
    }
    public void setB(Breed_660160 b) {
        this.b = b;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Dog [b=" + b + ", weight=" + weight + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + weight;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog_660160 other = (Dog_660160) obj;
        if (b != other.b)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
}
