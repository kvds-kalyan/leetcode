import java.util.ArrayList;
import java.util.LinkedList;



public class CourseSchedule2 {

    class Graph {
        int V;

        ArrayList<Integer> adj[];

        Graph(int V) {
            this.V = V;
            init();
        }

        void init() {
            adj = new ArrayList[V];
            for(int i=0;i<V;i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int from,int to) {
            adj[from].add(to);
        }
    }

    public void topologicalSorting(Graph g) {
        boolean visited[] = new boolean[g.V];
        boolean processing[] = new boolean[g.V];
        LinkedList<Integer> res = new LinkedList<>();



        for(int i=0;i<g.V;i++){
            if(!visited[i]) {
                int fin = helper(g, i, visited, processing, res);
                if (fin == -1) {
                    System.out.println("Cycle detected.Cannot find topological sort");
                    return;
                }
            }
        }

        for(int i : res) {
            System.out.print(i+"\t");
        }
    }

    public  int helper(Graph g, int vertex, boolean visited[], boolean processing[], LinkedList<Integer> res) {
        processing[vertex] = true;
        ArrayList<Integer> adj = g.adj[vertex];
        for(int adjV : adj) {
            if(processing[adjV]) {
                return -1;
            }
            if(!visited[adjV]) {
                int intermediate = helper(g, adjV, visited, processing, res);
                if(intermediate==-1) {
                    return -1;
                }
            }
        }
        res.addFirst(vertex);
        processing[vertex] = false;
        visited[vertex] = true;
        return 0;

    }


}

