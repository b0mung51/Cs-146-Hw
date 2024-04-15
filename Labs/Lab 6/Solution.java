import java.util.*;

public class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] prereq:prerequisites){
            adjList.get(prereq[1]).add(prereq[0]);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i<numCourses;i++){
            if(visited[i] == 0 && !dfs(adjList,visited, i)) return false; // cycle
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjList, int[] visited, int course){
        visited[course] = 1;
        for(int nextCourse:adjList.get(course)){
            if(visited[nextCourse]==1) return false; //cycle
            if(visited[nextCourse]==0 && !dfs(adjList, visited, nextCourse)) return false; // cycle in subtree
        }
        visited[course]=2;
        return true;    
    }

    public static void main(String[] args) {
        Solution schedule = new Solution();

        // Test cases
        System.out.println(schedule.canFinish(2, new int[][]{{1, 0}})); //Case 1
        System.out.println(schedule.canFinish(2, new int[][]{{1, 0}, {0, 1}})); //Case 2
    }
}