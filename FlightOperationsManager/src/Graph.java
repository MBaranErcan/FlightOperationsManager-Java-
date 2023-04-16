//-----------------------------------------------------
// Title: Graph class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Homework: 1
// Description: This class is the Undirectional Graph implementation class.
//-----------------------------------------------------
import java.util.*;

    public class Graph {
        private final int V;                                // - Number of vertices in the graph.
        private List<Integer>[] adjList;                    // - Adjacency list for each element.
        private int E = 0;                                  // - Number of edges in the graph.

        public Graph(int V) {                               // - Constructor to create a graph with V vertices..
            this.V = V;                                         
            adjList = new List[V+1];                        // - Initialize adjacency list for each vertex.
            for (int i = 1; i < V + 1; i++) {               // - (V + 1) instead of (V) because airport indexes start from 1 not 0.
                adjList[i] = new ArrayList<Integer>();
            }
        }

    public void addEdge(int v, int w) {                     // - Method to add an undirected edge between vertices v and w.
            adjList[v].add(w);                              // - Add w to v's adjacency list.
            adjList[w].add(v);                              // - Vice versa.
            E++;                                            // - Increase the E by 1.
        }

        public int V() {                                    // - Method to get the number of vertices in the graph
            return V;
        }    

    public int BFS(int src, int des, List<Integer> shortestPath) {  // - This method uses Breadth First Search algorithm to calculate the shortest path and the distance of that path.
        int[] dist = new int[V+1];                                  // - The method takes three inputs, src, des (represent the source and destination) and shortestPath.
        int[] prev = new int[V+1];                                  // - Distance array stores the minimum distances to src from all other nodes.
        Arrays.fill(dist, Integer.MAX_VALUE);                       // - Prev array stores the previous node.
        Arrays.fill(prev, -1);                                      // - Set all the distances to maximum value and previous nodes to -1 initially.
        dist[src] = 0;                                              // - (Distance from src to src is 0)
        Queue<Integer> q = new LinkedList<Integer>();               // - A queue is used to perform the BFS traversal.
        q.add(src);
        while (!q.isEmpty()) {                                      // - While the queue is not empty, the algorithm dequeues node u,
            int u = q.poll();                                       // - and checks the adjacency list for all of its neighbors.
            for (int v : adjList[u]) {                              // - for each neighbor:
                if (dist[u] + 1 < dist[v]) {                        // - if the distance to v from src through u is shorter than the current distance to v update the values.
                    dist[v] = dist[u] + 1;
                    prev[v] = u;                    
                    q.add(v);
                }
            }
        }
        if (prev[des] == -1) {                              // - If there is no path from src to des return -1
            return -1;
        } else {
            shortestPath.clear();                           // - Else, first clears the shortest path list.
            int u = des;                                    // - Starts from destination node until it reaches to the source and adds each node.
            while (u != src) {
                shortestPath.add(u);
                u = prev[u];
            }
            shortestPath.add(src);                          // - Finaly adds the source node.
            Collections.reverse(shortestPath);              // - Reverses the path or else it will be from destination to source.
            return dist[des];                               // - Returns the shortest distance from src to des.
        }
    }

}
