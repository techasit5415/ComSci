import java.util.HashMap;

public class eiei {
    int[][] aj;
    HashMap<Character, Integer> hm;

    eiei() {
        int[][] arr = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1}
        };
        aj = arr;
        hm = new HashMap<>();
        hm.put('a', 0);
        hm.put('b', 1);
        hm.put('c', 2);
        hm.put('d', 3);
        hm.put('e', 4);
        hm.put('f', 5);
    }

    public static void main(String[] args) {
        eiei alph = new eiei();

        System.out.println(alph.isTran('d', 'e', 'f'));
        System.out.println(alph.isTran('d', 'f', 'e'));
        System.out.println(alph.isTran('c', 'd', 'e'));
        System.out.println(alph.isTran('e', 'd', 'c'));
        System.out.println(alph.isTran('a', 'c', 'e'));
        System.out.println(alph.isTran('b', 'd', 'f'));
        System.out.println(alph.isTran('a', 'b', 'c'));
    }

    boolean isTran(char c1, char c2, char c3) {
        if (!hm.containsKey(c1) || !hm.containsKey(c2) || !hm.containsKey(c3)) {
            return false;  // At least one of the characters is not in the mapping.
        }

        int start = hm.get(c1);
        int target = hm.get(c3);

        // Use DFS to check for a path from 'start' to 'target'.
        boolean[] visited = new boolean[aj.length];
        return hasPathDFS(start, target, visited);
    }

    boolean hasPathDFS(int current, int target, boolean[] visited) {
        if (current == target) {
            return true;  // Found a path from 'current' to 'target'.
        }

        visited[current] = true;

        for (int i = 0; i < aj[current].length; i++) {
            if (aj[current][i] == 1 && !visited[i]) {
                if (hasPathDFS(i, target, visited)) {
                    return true;
                }
            }
        }

        return false;  // No path found from 'current' to 'target'.
    }
}
