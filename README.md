Author:	Nathan Hayes-Roth

Date:	Sunday 4/21/13

## General Description

This project aims to solve an online maze using the breadth-first-search algorithm. The maze is traversed by accessing a URL that returns a set of possible subsequent moves. If the response body contains end:true, the maze has been solved.

## File Descriptions

- Node.java

Manages Node objects, which hold the various states of the maze as the algorithm traverses the search tree. Also contains various helper functions (constructors, getters, setters, comparators, toString, etc.).

- Search.java

Contains the search algorithm (breadth first search) used to solve the maze. In addition to outputting the list of points along the solution path, this program also tracks various interesting statistics (elapsed time, depth of solution, and certain node counts).

- Play.java

Contains the main method, which is called to run the program. Also contains additional tests and methods, which didn't rightly fit in either of the other classes.

## Possible Extensions

- This project was adapted from a previous project that compared the efficiency of several search algorithms (breadth-first, depth-first, iterative-depth-first, uniform-cost, greedy, and A-star). As a  result, the overall project organization is not particularly streamlined. I'd like to **refactor the code for efficiency and remove unnecessary methods**.

- I chose breadth-first for 3 reasons: it's straightforward, it's guaranteed to find the optimal solution (assuming one exists), and I had no indication of where the final solution would exist. Immediately, I'd prefer to **implement an iterative-depth-first solution**. This would require significantly less memory for difficult mazes (deep trees). Additionally, I think it'd be interesting to **try the heuristic searches**. Usually heuristic searches require some indication of where the final solution lies. So, without any indication, I'd have to make some educated guesses.

## Sample Output

---Output---

(0, 0) (1, 0) (2, 0) (2, 1) (2, 2) (1, 2) (1, 1) (0, 1) (0, 2) (0, 3) (1, 3) (2, 3) (3, 3) (4, 3) (5, 3) (5, 4) (6, 4) (6, 3) (6, 2) (5, 2) (4, 2) (3, 2) (3, 1) (4, 1) (4, 0) (5, 0) (6, 0) (6, 1) (7, 1) (7, 0) (8, 0) (9, 0) (10, 0) (11, 0) (11, 1) (10, 1) (10, 2) (10, 3) (9, 3) (9, 4) (8, 4) (8, 3) (7, 3) (7, 4) (7, 5) (6, 5) (6, 6) (6, 7) (6, 8) (5, 8) (5, 9) (4, 9) (4, 8) (4, 7) (5, 7) (5, 6) (5, 5) (4, 5) (3, 5) (2, 5) (2, 6) (2, 7) (2, 8) (1, 8) (0, 8) (0, 9) (1, 9) (1, 10) (1, 11) (2, 11) (3, 11) (3, 12) (4, 12) (5, 12) (5, 11) (4, 11) (4, 10) (5, 10) (6, 10) (6, 9) (7, 9) (7, 10) (8, 10) (9, 10) (10, 10) (10, 9) (11, 9) (11, 10) (11, 11) (12, 11) (12, 12) 


---Statistics----

Seconds Elapsed:	16

Depth:				90

Nodes Generated:	244

Nodes Ignored:		121

Open Nodes:			1

Closed Nodes:		122