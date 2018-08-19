import java.util.ArrayList;
import java.util.LinkedList;


public class CourseSchedule {

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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        int total = prerequisites.length;

        for(int i=0;i<total;i++) {
            g.addEdge(prerequisites[i][0],prerequisites[i][1]);
        }

        return  topologicalSorting(g);
    }

    public boolean topologicalSorting(Graph g) {
            boolean visited[] = new boolean[g.V];
            boolean processing[] = new boolean[g.V];


            for(int i=0;i<g.V;i++){
                if(!visited[i]) {
                    boolean fin = helper(g, i, visited, processing);
                    if (!fin) {
                        System.out.println("Cycle detected.Cannot find topological sort");
                        return false;
                    }
                }
            }

            return true;
    }


    public boolean helper(Graph g, int vertex, boolean visited[], boolean processing[]) {
            processing[vertex] = true;
            ArrayList<Integer> adj = g.adj[vertex];
            for(int adjV : adj) {
                if(processing[adjV]) {
                    return false;
                }
                if(!visited[adjV]) {
                    boolean intermediate = helper(g, adjV, visited, processing);
                    if(!intermediate) {
                        return false;
                    }
                }
            }
            processing[vertex] = false;
            visited[vertex] = true;
            return true;
        }


}