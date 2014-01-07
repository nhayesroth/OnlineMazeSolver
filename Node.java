/*
 * Node.java
 * ------------
 * Name: Nathan Hayes-Roth
 * Online Maze Solving Project
 * ------------
 * Handles specific states of the maze which will be passed to other programs.
 */

package OnlineMazeSolver;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Node implements Comparable{

    /* class attributes */
    private Node parent;                  // parent node
    private Point coordinates;            // current coordinates
    private int depth;                    // # of moves it took to get here
    private ArrayList<Point> valid_moves; // possible next moves
    
    /* initial constructor */
    public Node(){
        this.parent = null;
        this.coordinates = new Point();
        this.depth = 0;
        this.valid_moves = new ArrayList<Point>();
    }
    
    /* general constructor */
    public Node(Node parent, Point coordinates){
        this.parent = parent;
        this.coordinates = coordinates;
        this.depth = parent.depth + 1;
        this.valid_moves = generateMoves();
    }
    
    /* getParent() */
    public Node getParent(){
        return this.parent;
    }
    
    /* getCoordinates() */
    public Point getCoordinates(){
        return this.coordinates;
    }
    /* getDepth() */
    public int getDepth(){
        return this.depth;
    }
    
    /* getValidMoves() */
    public ArrayList<Point> getValidMoves(){
        return this.valid_moves;
    }
    
   /* setParent(Node parent) */
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    /* setCoordinates(Point coordinates) */
    public void setCoordinates(Point coordinates){
        this.coordinates = coordinates;
    }
    /* setDepth(int depth) */
    public void setDepth(int depth){
        this.depth = depth;
    }
    
    /* setValidMoves(ArrayList<Point> moves) */
    public void setValidMoves(ArrayList<Point> moves){
        this.valid_moves = moves;
    }
    
    /*
     * generateMoves()
     * placeholder for function that will grab moves from HTML
     */
    public ArrayList<Point> generateMoves(){
        String url = Play.buildURL(this.coordinates);
        return Play.parseMoves(Play.getResponse(url));
    }
    
    /* 
     * compareTo()
     * returns 0 if two nodes' coordinates are identical
     * returns 1 otherwise
     */
    public int compareTo(Object other){
        Point this_point = this.getCoordinates();
        Point that_point = ((Node)other).getCoordinates();
        if (this_point.equals(that_point))
            return 0;
        else return 1;
    }

    /*
     * equals(Object other)
     * overrides the equals() method used in searching stacks
     */
    public boolean equals(Object other){
        if (this.compareTo(other) == 0)
            return true;
        else return false;
    }
    
    /*
     * toString()
     * converts a node to an easily readable String
     */
    public String toString(){
        String to_return = "Coordinates: ";
        to_return += toString(this.coordinates);
        to_return += "   Moves: ";
        for(Point p : this.valid_moves)
            to_return += toString(p) + " ";
        return to_return;
    }
    
    /*
     * toString(Point)
     * overrides the typical Point.toString() method to accommodate int values
     */
    public static String toString(Point point){
        String to_return = "(";
        to_return += (int)point.getX();
        to_return += ", ";
        to_return += (int)point.getY();
        to_return += ")";
        return to_return;
    }
    
    /*
     * getDirection(Node A, Node B)
     * compares two nodes and returns a string describing the direction moved
     */
    public static String getDirection(Node A, Node B){
        if ((A == null)||(B == null))
                return "";
        Point first = A.coordinates;
        Point second = B.coordinates;
        if ((int)first.getX()>(int)second.getX())
            return "N";
        if ((int)first.getX()<(int)second.getX())
            return "S";
        if ((int)first.getY()>(int)second.getY())
            return "W";
        else
            return "E";
    }
}
