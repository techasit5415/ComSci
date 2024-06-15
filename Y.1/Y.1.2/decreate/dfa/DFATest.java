public class DFATest {
    // Define states
    enum State {
        START, Q1, Q2, FINAL
    }

    // Define alphabet symbols
    enum Symbol {
        ZERO, ONE, OTHER
    }

    // Transition function
    static State transition(State currentState, Symbol inputSymbol) {
        switch (currentState) {
            case START:
                return inputSymbol == Symbol.ZERO ? State.Q1 : State.START;
            case Q1:
                return inputSymbol == Symbol.ZERO ? State.Q1 : (inputSymbol == Symbol.ONE ? State.Q2 : State.START);
            case Q2:
                return inputSymbol == Symbol.ONE ? State.FINAL : State.START;
            default:
                return State.START; // Invalid state, reset to START
        }
    }

    // Check if the string is accepted
    static boolean acceptString(String input) {
        State currentState = State.START;
        for (char c : input.toCharArray()) {
            Symbol inputSymbol = c == '0' ? Symbol.ZERO : (c == '1' ? Symbol.ONE : Symbol.OTHER);
            currentState = transition(currentState, inputSymbol);
        }
        return currentState == State.FINAL; // Check if the final state is reached
    }

    public static void main(String[] args) {
        String[] testCases = {"101", "001", "11101", "0101", "10001"};
        for (String input : testCases) {
            System.out.println("String '" + input + "' is " + (acceptString(input) ? "accepted" : "rejected"));
        }
    }
}
