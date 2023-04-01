import java.lang.Exception;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Graph<Integer> graph = new Graph<Integer>();    
        
        getInput(graph);
    
    }
    
    public static void getInput(Graph graph) {                         // Gets the input from user
        Scanner input = new Scanner(System.in);
        
        try {
            String line = input.nextLine();                 // Creates an String to hold the first input line which includes N M T C values.
            String[] firstLine = (line.split(" "));         // Splits the N M T C values.
            
            Integer[] nmtc = new Integer[4];                // We hold the N M T C values in an Integer array each corresponding to their values.
            
            for (int i = 0; i < 4; i++) {
                nmtc[i] = Integer.valueOf(firstLine[i]);    // Assigns the N M T C values to variables called n m t c.
            }
            if ((nmtc[1]) > (nmtc[0])) {
                System.out.println("There cannot be more bidirectional roads than the number of airports!"); System.exit(0); // Logical check.
            }
            
            for (int i = 1; i < (nmtc[0])+1; i++) {                   //nmtc[0] = n
                graph.addVertex(i);                                   // Instantiates the airports from 1 to M.
            }            
            
            getConnections(graph, (nmtc[1]));                       // Calls our second input method with value m. (nmtc[1] = m) to create the bidirectional roads.
            int[] direction = getStartAndEndPoints(graph);          // Calls our third and last input method to get the starting and ending cities.
            
            
            
        } catch (NumberFormatException e) {
            System.out.println("Something is wrong!");
        }
    }
    
    public static void getConnections(Graph graph, int m) {  //Gets the next input lines
        Scanner scan = new Scanner(System.in);  // each line consist of 2 numbers
        String[] road_str = new String[m];     // in which they indicate source and destination values..
        
        for (int i = 0; i < m; i++) {           // Catch the input values.
            road_str[i] = scan.nextLine();      // Each line is kept as one variable.
        }    
        for (String s : road_str) {             // Iterate each line, use split to get the source and destination values seperately.
            String[] sourceAndDestinaiton_str = new String[2];
            sourceAndDestinaiton_str = s.split(" ");
            
            Integer src = Integer.valueOf(sourceAndDestinaiton_str[0]); // Assigns the src and des values.
            Integer des = Integer.valueOf(sourceAndDestinaiton_str[1]); checkValidAirport(graph,src,des);//Checks if these values are valid.
            
            graph.addEdge(src, des);
        }    
    }
    
    public static int[] getStartAndEndPoints(Graph graph) {    // Returns int array FirstandLastCity containing the start and end points.
        Scanner scan = new Scanner(System.in);
        String lastLine = scan.nextLine();
        String[] v = new String[2];
        v = lastLine.split(" ");
        
        int[] FirstandLastCity = {Integer.valueOf(v[0]), Integer.valueOf(v[1])};    //FirstandLastCity[0] = First City (Starting point)
                                                                                    //FirstandLastCity[1] = Last City (End point)
        checkValidAirport(graph, FirstandLastCity[0], FirstandLastCity[1]);
                                                                            // Checks if the starting and the ending cities are valid or not.
        return (FirstandLastCity);
    }
    
    
    public static void checkValidAirport(Graph graph, int n, int m) {      // Checks if there is an airport or not with the given user inputs.
        if (!graph.hasVertex(n)) {
            System.out.println("There is no such airport with the name: " + n); System.exit(0);
        }if (!graph.hasVertex(m)) {
            System.out.println("There is no such airport with the name: " + m); System.exit(0);
        }if (n == m) {
            System.out.println("Source and destination cannot be the same: " + n + " = " + m); System.exit(0);
        }      
    }
    
    public static int travel(int t){
        
        
        return t;
    }
    
    public static void checkAccessibility(Graph g, int src, int des){
        if(g.hasEdge(src, des))
            System.out.println("1");
    }
    
}
