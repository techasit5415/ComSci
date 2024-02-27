public class CheckType {
    boolean repeatedVertex = false;
    boolean repeatedEdge = false;
    boolean sameStartEnd = false;
    boolean containEdge1 = false;
    Type type = Type.Path;

    CheckType(boolean rV, boolean rE, boolean sSE, boolean cE) {
        repeatedVertex = rV;
        repeatedEdge = rE;
        sameStartEnd = sSE;
        containEdge1 = cE;
    }

    public void checkType() {
        if(repeatedVertex == true && repeatedEdge == true && sameStartEnd == false && containEdge1 == false) {
            type = Type.Walk;
        }
        else if(repeatedVertex == false && repeatedEdge == true && sameStartEnd == false && containEdge1 == false) {
            type = Type.Trail;
        }
        else if(repeatedVertex == false && repeatedEdge == false && sameStartEnd == false && containEdge1 == false) {
            type = Type.Path;
        }
        else if(repeatedVertex == true && repeatedEdge == true && sameStartEnd == true && containEdge1 == false) {
            type = Type.Closed_walk;
        }
        else if(repeatedVertex == false && repeatedEdge == true && sameStartEnd == true && containEdge1 == true) {
            type = Type.Circuit;
        }
        else if(repeatedVertex == false && repeatedEdge == false && sameStartEnd == true && containEdge1 == true) {
            type = Type.Simple_circuit;
        }
    }

    @Override
    public String toString() {
        return "Output Type : " + type;
    }
}
