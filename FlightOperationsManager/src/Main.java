//-----------------------------------------------------
// Title: Main class
// Author: Mustafa Baran Ercan
// ID: 28810555206
// Section: 1
// Homework: 1
// Description: This class is the main class.
//-----------------------------------------------------
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);// - Get N, M, T, C values from the user.
  
            int N = scanner.nextInt();  // - N represents the number of cities (vertices).
            int M = scanner.nextInt();  // - M represents the number of connections (edges).
            int T = scanner.nextInt();  // - T represents the time required by airports to change their states.
            int C = scanner.nextInt();  // - C represents the time for travelling one city to another.
            
            // - Instantiate the graph with N vertices.
            Graph graph = new Graph(N);
            
            // - Get edges (roads) from the user.
            for (int i = 0; i < M; i++) {
                int v = scanner.nextInt();
                int u = scanner.nextInt();
                
                checkValidVertex(graph, v, u);  // - Check if the vertex is valid.
                graph.addEdge(v, u);    // - If they are, then add them to the graph.
            }
            
            // - Get the source and destination vertices.
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            
            
            List<Integer> path = new LinkedList<>(); // -List to store the shortest path from source to destination.
            int dist = -1;  // - Int value to store the distance value.
            // - Find the shortest path and distance using BFS algorithm.
            dist = graph.BFS(source, destination, path);
            
            // - Calculate the required time.
            int time = 0;
            if(dist == 1) {
                time = T;
            } else {
                // - Mathematical calculations to find the time.
                int t_temp = T;
                for (int i = 0; i < dist; i++) {
                    if (t_temp <= 0){
                        time += (T-(Math.abs(t_temp)));
                        t_temp = T;
                    }
                    time += C;
                    t_temp -= C;   
                }
            }
            // - Print the number of cities you need to go through (K), the path, and the total time.
            System.out.println(dist +1);        // - Print the distance.
            for (Integer x : path) {            // - Print the path.
                System.out.print(x + " ");
            }
            System.out.println("\n" + (time));  // - Print the time.       
            
        } catch (InputMismatchException e) {    // - Exceptions
            System.out.println("Something is wrong with the input!");
        }
    }
    
    // - Checks if the input vertex is valid or not.
    public static void checkValidVertex(Graph graph, int n, int m) {
        if ((n > graph.V()) || (n <= 0)) {
            System.out.println("There is no such airport with the code: " + n); 
            System.exit(0);
        }
        if ((m > graph.V()) || (m <= 0)) {
            System.out.println("There is no such airport with the code: " + n); 
            System.exit(0);
        }
        if (n == m) {
            System.out.println("Source and destination cannot be the same: (" + n + " = " + m + ")"); 
            System.exit(0);
        }      
    }
    
}
