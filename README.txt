Nathan Hayes-Roth
Flipboard Programming Challenge
Completed: Sunday 4/21/13

*****************
Task Description
*****************
Hello!

This is a challenge that requires you to construct a program that will complete a maze. Each step of the maze is done by accessing a URL that returns the next set of moves. If the response body contains end:true then your program is complete and it should print out the steps it used to get there. Bonus points if your program can also display a human-understandable representation of the maze you just completed.

You may use any language to write the program, the only caveat is that it must be buildable and runnable on common, modern operating systems (definition of which is intentionally loose). We won’t accept pseudo-code :)

Access this link (http://challenge.flipboard.com/m?s=3664557117915935000.13&x=0&y=0) to begin. You can start a new maze at any time by returning to the same link.

What you should submit

*The output of your program for one maze. This should be a list of the points along the path that takes you from the initial URL to the final URL which returns a response containing end:true.
*The code you used to generate the output.
*(Optional) Have your code also output a representation of the maze it just completed.

*****************
File Descriptions
*****************
Node.java
Manages Node objects, which hold the various states of the maze as it is solved. Also contains various helper functions (constructors, getters, setters, comparators, toString, etc.).

Search.java
Contains the search algorithm (breadth first search) used to solve the maze. In addition to outputting the list of points along the solution path, this program also tracks various interesting statistics (elapsed time, depth of solution, and certain node counts).

Play.java
Contains the main method, which is called to run the program. Also contains additional tests and methods, which didn't rightly fit in either other program.

*****************
Task Description
*****************
Hello!

This is a challenge that requires you to construct a program that will complete a maze. Each step of the maze is done by accessing a URL that returns the next set of moves. If the response body contains end:true then your program is complete and it should print out the steps it used to get there. Bonus points if your program can also display a human-understandable representation of the maze you just completed.

You may use any language to write the program, the only caveat is that it must be buildable and runnable on common, modern operating systems (definition of which is intentionally loose). We won’t accept pseudo-code :)

Access this link (http://challenge.flipboard.com/m?s=3664557117915935000.13&x=0&y=0) to begin. You can start a new maze at any time by returning to the same link.

What you should submit

*The output of your program for one maze. This should be a list of the points along the path that takes you from the initial URL to the final URL which returns a response containing end:true.
*The code you used to generate the output.
*(Optional) Have your code also output a representation of the maze it just completed.

**************************
Output
**************************
---Output---
(0, 0) (1, 0) (2, 0) (2, 1) (2, 2) (1, 2) (1, 1) (0, 1) (0, 2) (0, 3) (1, 3) (2, 3) (3, 3) (4, 3) (5, 3) (5, 4) (6, 4) (6, 3) (6, 2) (5, 2) (4, 2) (3, 2) (3, 1) (4, 1) (4, 0) (5, 0) (6, 0) (6, 1) (7, 1) (7, 0) (8, 0) (9, 0) (10, 0) (11, 0) (11, 1) (10, 1) (10, 2) (10, 3) (9, 3) (9, 4) (8, 4) (8, 3) (7, 3) (7, 4) (7, 5) (6, 5) (6, 6) (6, 7) (6, 8) (5, 8) (5, 9) (4, 9) (4, 8) (4, 7) (5, 7) (5, 6) (5, 5) (4, 5) (3, 5) (2, 5) (2, 6) (2, 7) (2, 8) (1, 8) (0, 8) (0, 9) (1, 9) (1, 10) (1, 11) (2, 11) (3, 11) (3, 12) (4, 12) (5, 12) (5, 11) (4, 11) (4, 10) (5, 10) (6, 10) (6, 9) (7, 9) (7, 10) (8, 10) (9, 10) (10, 10) (10, 9) (11, 9) (11, 10) (11, 11) (12, 11) (12, 12) 

---Statistics----
Seconds Elapsed:	16
Depth:		90
Nodes Generated:	244
Nodes Ignored:	121
Open Nodes:	1
Closed Nodes:	122