class CheckType {
    boolean rpVertex = false;
    boolean rpEdge = false;
    boolean sameSE = false;
    boolean ctEdge = false;
    boolean sSEFL = false;
    //contain = ct
    Type type = Type.Path;

    CheckType(boolean rV, boolean rE, boolean sSE, boolean cE,boolean sameSEFL) {
        rpVertex = rV;
        rpEdge = rE;
        sameSE = sSE;
        ctEdge = cE;
        sSEFL = sameSEFL;
    }

    public void checkType() {
         if(rpVertex == false && rpEdge == false && sameSE == false && ctEdge == false) {
            type = Type.Path;
        }
        else if(rpVertex == false && sSEFL==true && rpEdge == false && sameSE == true && ctEdge == true) {
            type = Type.Simple_circuit;
        }
        else if((rpVertex == false || rpVertex == true) && rpEdge == false && sameSE == true && ctEdge == true) {
            type = Type.Circuit;
        }
        else if((rpVertex == true || rpVertex == false) && (rpEdge == true || rpEdge == false) && sameSE == true && ctEdge == false) {
            type = Type.Closed_walk;
        }
        else if((rpVertex == false || rpVertex==true) && rpEdge ==false && (sameSE == false|| sameSE==true) && ctEdge == false) {
            type = Type.Trail;
        }

        else if((rpVertex == true || rpVertex == false) && (rpEdge == true || rpEdge == false) && (sameSE == false || sameSE == true) && ctEdge == false) {
            type = Type.Walk;
        }

        


        else {
            type = Type.error; 
        }
    }
    

    @Override
    public String toString() {
        return "Output Type : " + type;
    }
}