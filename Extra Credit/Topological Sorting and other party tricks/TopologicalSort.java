import java.util.*;

public class TopologicalSort{
    private int V;
    private LinkedList<Integer> adj[];

    TopologicalSort(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0;i<v;i++){
            adj[i] = new LinkedList(); //says unchecked
        }
    }

    public void addEdge(int v, int u){
        adj[v].add(u);
    }

    public void khanAlgo(){
        int[] inDegree = new int[V];
        for(int i = 0;i<V;i++){
            for(int node:adj[i]){
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int u = queue.poll();
            result.add(u);
            for(int node:adj[u]){
                if(--inDegree[node]==0) queue.add(node);
            }
            count++;
        }
        if(count!=V){
            System.out.println("There is a cycle");
            return;
        }
        for(int vertex:result){
            System.out.print(vertex + " ");
        }
        System.out.println();
    }

    public void bfs(){
        int[] inDegree = new int[V];
        for(int i = 0;i<V;i++){
            for(int node:adj[i]){
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(inDegree[i]==0) queue.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int u = queue.poll();
            result.add(u);
            for(int node:adj[u]){
                if(--inDegree[node]==0) queue.add(node);
            }
        }

        if(result.size() != V){
            System.out.println("There is a cycle");
            return;
        }
        for(int vertex:result){
            System.out.print(vertex + " ");
        }
        System.out.println();
    }

    public void dfs(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                sortHelper(i, visited, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    public void sortHelper(int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        for(int i:adj[v]){
            if(!visited[i]) sortHelper(i,visited,stack);
        }
        stack.push(v);
    }

    public static void main(String args[]){
        TopologicalSort a = new TopologicalSort(6);
        a.addEdge(5, 2);
        a.addEdge(5, 0);
        a.addEdge(4, 0);
        a.addEdge(4, 1);
        a.addEdge(2, 3);
        a.addEdge(3, 1);

        System.out.println("Topological Sort: Kahn's algorithm");
        a.khanAlgo();

        System.out.println("Topological Sort: BFS");
        a.bfs();

        System.out.println("Topological Sort: DFS");
        a.dfs();

    }
}