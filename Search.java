/*
 * Search.java
 * ------------
 * Name: Nathan Hayes-Roth
 * Online Maze Solver
 * ------------
 * Holds the search algorithm to be implemented in Play.java.
 */

package OnlineMazeSolver;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.net.*;
import java.io.*;


public class Search{

    /* static variables */
    private static LinkedList<Node> solution = new LinkedList<Node>();  // series of solution nodes
    private static int Open = 0;   // number of open nodes
    private static int Ignored = 0;  // number of ignored nodes
    private static int Closed = 0;  // number of closed nodes
    private static long start_time = 0;
    private static long elapsed_time = 0;

    /*
     * printStats(Node current, String searchName)
     * prints all the required information after a test has been run
     */
    public static void printStats(Node current){
        System.out.println("---Output---");
        int depth = current.getDepth();
        while(current.getParent()!=null){    
            solution.addFirst(current);
            current = current.getParent();
        }
        solution.addFirst(Play.start);
        //print series of moves
        while(!solution.isEmpty()){
            Node first = solution.removeFirst();
            System.out.print(Node.toString(first.getCoordinates()) + " ");
            // System.out.print(Node.getDirection(first, solution.peek())+ " ");
        //print number of moves
        }
        System.out.print("\n\n---Statistics----" +
                         "\nSeconds Elapsed:\t" + elapsed_time +
                         "\nDepth:\t\t" + depth + 
                         "\nNodes Generated:\t" + (Open+Ignored+Closed) + 
                         "\nNodes Ignored:\t" + Ignored + 
                         "\nOpen Nodes:\t" + Open + 
                         "\nClosed Nodes:\t" + Closed + "\n");
    }
  
    /*
     * bfs(Node start, Node goal)
     * runs breadth first search on the start/end states
     */
    public static void bfs(Node start){
        start_time = System.nanoTime();
        Queue<Node> open = new LinkedList<Node>();    // open list
        Queue<Node> closed = new LinkedList<Node>();    // closed list
        ArrayList<Point> moves = new ArrayList<Point>();    // legal moves
        String str = "";    // response string
        
        //add the start state to the open list
        open.add(start);
        
        // loop while the open list is not empty
        while(!open.isEmpty()){
            
            //check the current open node
            Node current = open.remove();
            try{
                // make a URL from the current Node's coordinates
                URL url = new URL(Play.buildURL(current.getCoordinates()));
                // connect to the webpage
                URLConnection con = url.openConnection();
                // read in the response
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                str = br.readLine();
            }
            // catch any exception and print the message
            catch(Exception e) {
                System.out.println("Exception: " + e);
            }
            if (Play.check(str)){ // the response contains "true"
                elapsed_time = (System.nanoTime() - start_time)/1000000000;
                // Count the number of open nodes
                while (!open.isEmpty()){
                    Node removed = open.remove();
                    Open++;
                }
                // print the relevant stats
                printStats(current);
                return;
            }
            else{
                // move the current node to closed, and increment the Closed statistic
                closed.add(current);
                Closed++;
                
                // set the current Node's next moves
                current.setValidMoves(Play.parseMoves(str));
                // iterate across the moves
                moves = current.getValidMoves();
                for (Point move : moves){
                    // build a child node
                    Node child = new Node (current, move);
                    // search open and closed for potential child
                    if ((!open.contains(child)) && 
                         (!closed.contains(child))){
                        // add those not in either to open
                        open.add(child);
                    }
                    else
                        // otherwise, increment the Ignored statistic
                        Ignored++;
                }      
            }
        }
        System.out.println("Failed");
    }
}
