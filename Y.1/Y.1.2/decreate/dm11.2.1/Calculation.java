public class Calculation extends Matrix implements Round{

    Calculation(long [][] m) {
        super(m);
    }

    public void solutionMatrix() {
        long [][] newMatrix = new long [matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                for(int k = 0; k < matrix.length; k++) {
                    newMatrix[i][j] += matrix[i][k] * matrix[k][j];
                }
            }
        }
        setMetrix(newMatrix);
    }

    public void round(int round) {
        while(round != 0) {
            solutionMatrix();
            round--;
        }
    }
}
