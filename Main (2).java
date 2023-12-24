import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<String> visitedStates = new HashSet<>();

    public static void main(String[] args) {
        int jug1Capacity = 4;
        int jug2Capacity = 3;
        int targetAmount = 2;

        System.out.println("DFS Solution:");
        dfs(0, 0, jug1Capacity, jug2Capacity, targetAmount);
    }

    static void dfs(int jug1, int jug2, int jug1Capacity, int jug2Capacity, int targetAmount) {
        if (jug1 == targetAmount || jug2 == targetAmount) {
            System.out.println("Solution Found: (" + jug1 + ", " + jug2 + ")");
            return;
        }

        String state = jug1 + "-" + jug2;

        if (visitedStates.contains(state)) {
            return;
        }

        visitedStates.add(state);

        
        if (jug1 < jug1Capacity) {
            dfs(jug1Capacity, jug2, jug1Capacity, jug2Capacity, targetAmount);
        }

        
        if (jug2 < jug2Capacity) {
            dfs(jug1, jug2Capacity, jug1Capacity, jug2Capacity, targetAmount);
        }

        
        if (jug1 > 0) {
            dfs(0, jug2, jug1Capacity, jug2Capacity, targetAmount);
        }

        
        if (jug2 > 0) {
            dfs(jug1, 0, jug1Capacity, jug2Capacity, targetAmount);
        }

        
        int pourAmount = Math.min(jug1, jug2Capacity - jug2);
        dfs(jug1 - pourAmount, jug2 + pourAmount, jug1Capacity, jug2Capacity, targetAmount);

        
        pourAmount = Math.min(jug2, jug1Capacity - jug1);
        dfs(jug1 + pourAmount, jug2 - pourAmount, jug1Capacity, jug2Capacity, targetAmount);
    }
}
