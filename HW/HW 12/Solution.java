import java.util.*;
public class Solution {
    public int minCostToSupplyWater(int n, int [] wells, int[][] pipes){
        List<int[]> edges = new ArrayList<>();
        for(int i = 0;i<wells.length;i++){
            edges.add(new int[]{0,i+1,wells[i]});
        }
        for(int[] pipe:pipes){
            edges.add(pipe);
        }
        Collections.sort(edges,(a,b) -> a[2] - b[2]);
        int[] parent = new int[n+1];
        for(int i = 0;i<=n;i++){
            parent[i]=i;
        }
        int cost = 0;
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            int parentU = find(u, parent);
            int parentV = find(v, parent);
            if(parentU != parentV){
                cost += weight;
                parent[parentU] = parentV;
            }
        }
        return cost;
    }
    private int find(int x, int[] parent){
        if(parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 2;
        int[] wells1 = {1, 1};
        int[][] pipes1 = {{1, 2, 1}, {1, 2, 2}};
        int output1 = solution.minCostToSupplyWater(n1, wells1, pipes1);
        System.out.println("Test Case 1: " + (output1)); //should be 2

        // Test Case 2
        int n2 = 3;
        int[] wells2 = {1, 2, 2};
        int[][] pipes2 = {{1, 2, 1}, {2, 3, 1}};
        int output2 = solution.minCostToSupplyWater(n2, wells2, pipes2);
        System.out.println("Test Case 2: " + (output2));//should be 3
    }
}