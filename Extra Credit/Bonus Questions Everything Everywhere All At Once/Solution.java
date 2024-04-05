public class Solution {
    public int[][] convertAdjacencyListToMatrix(int[][] adjList) {
        int numVertices = adjList.length;
        int[][] adjMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int edge : adjList[i]) {
                adjMatrix[i][edge] = 1;
            }
        }
        return adjMatrix;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        int[][] adjList = {{}, {0, 2}, {0}};
        int[][] adjMatrix = solution.convertAdjacencyListToMatrix(adjList);
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
