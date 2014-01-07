/*
 * Play.java
 * ------------
 * Name: Nathan Hayes-Roth
 * Online Maze Solver
 * ------------
 * Administers all tests and operations.
 */

package OnlineMazeSolver;

import java.awt.Point;
import java.util.ArrayList;
import java.lang.Integer;
import java.io.*;
import java.net.*;
import java.lang.String;

public class Play{
    
    /* url to access the challenge */
    private static String start_url = "This url has been redacted.";
    public static String[] url_pieces = splitURL(start_url);
    
    /* start node */
    public static Node start = new Node();

    
    /*
     * splitURL
     * splits a URL into useful 4 parts:
     *     (1) everything up to the x-coordinate
     *     (2) x-coordinate
     *     (3) everything between the x- and y-coordinates
     *     (4) y-coordinate
     */
    public static String[] splitURL(String url){
        String[] to_return = new String[4];
        int x_index = start_url.indexOf("&x");
        int y_index = start_url.indexOf("&y");
        to_return[0] = url.substring(0, x_index+3);
        to_return[1] = url.substring(x_index+3, y_index);
        to_return[2] = url.substring(y_index, y_index+3);
        to_return[3] = url.substring(y_index+3);
        return to_return;
    }
    
    /* 
     * buildURL(Point p)
     * builds a URL to follow from a Point object
     */
    public static String buildURL(Point p){
        String new_url = url_pieces[0]+(int)p.getX()+url_pieces[2]+(int)p.getY();
        return new_url;
    }
    
    /*
     * getResponse(String str)
     * follows a URL and returns the response as a String
     */
    public static String getResponse(String str){
        String to_return = "";
        try{
            // make a URL object
            URL url = new URL(str);
            // connect to the webpage
            URLConnection con = url.openConnection();
            // read in the response
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            to_return = br.readLine();
        }
        // catch any exception and print the message
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
        return to_return;
    }
    
    /*
     * check(String response)
     * checks the response to see if the maze has been completed
     */
    public static boolean check(String response){
        return response.contains("true")?
            true:
            false;
    }
    
    /*
     * parseMoves(String response)
     * builds an ArrayList<Point> of next moves from the response
     */
    public static ArrayList<Point> parseMoves(String response){
        ArrayList<Point> to_return = new ArrayList<Point>();
        while(true){
            if (response.charAt(0) != '(')
                response = response.substring(response.indexOf('('));
            int first = response.indexOf("(");
            int second = response.indexOf(",");
            int third = response.indexOf(")");
            int x = Integer.parseInt(response.substring(first+1, second));
            int y = Integer.parseInt(response.substring(second+1, third));
            to_return.add(new Point(x,y));
            if (response.indexOf(")") == response.length()-1)
                break;
            response = response.substring(third);
        }
        return to_return;
    }
    
    /* main */
    public static void main(String [] args){
        start.setCoordinates(new Point(0,0));
        start.setValidMoves(start.generateMoves());
        Search.bfs(start);
    }
}