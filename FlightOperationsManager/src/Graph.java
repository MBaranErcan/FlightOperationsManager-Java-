import java.util.*;

public class Graph<T> { // Generic class of Graph, T stands for "Type"
    
// Use Hashmap to store the edges of graph.
    private Map<T, List<T> > map = new HashMap<>();
    
    public void addVertex(T s) {    // This method adds a new vertex to the graph.
        map.put(s, new LinkedList<T>());
    }
    
    public void addEdge(T source, T destination) {  // This method adds ther edge and the vertices if they don't exist 
                                                    // Standart add edge method works with a boolean parameter called bidirection.
        if(!map.containsKey(source))                // Since all of our edges are undirected, we don't need to keep that unnecessary information.
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);
        
        map.get(source).add(destination);
        map.get(destination).add(source);
        
    }
    
    public int getVertexCount() {       // This method returns the # of vertices
        return (map.keySet().size());
    }
    
    public int getEdgeCount() {         //This method returns the # of edges
        int count = 0;                  
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        return (count/2);               // Since all edges are bidirectional, we count them twice. So the real count is half of it.
    }

    public boolean hasVertex(T s) {     // If the graph has that vertex; return true, else retuns false.
        return (map.containsKey(s));
    }
    
    public boolean hasEdge(T src, T des) { // If the graph has that edge; return true, else retuns false.
        if (map.get(src).contains(des)) return true;
        else return false;
    }
    
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w: map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }



}
