 /*
********************************************************************************
  Project     : Programming Languages 1 - Assignment 3 - Exercise QSsort
  Authors     : Stylianos Kandylakis el17088, 
                Kitsos Orfanopoulos el17025
  -----------
 ProgLangI 2021, ECE-NTUA
 *******************************************************************************

 Translate Python:
    This solution is a translation of our python solution. 


Main Idea:      
*/

import java.io.*; // for I/O methods
import java.util.*;

public class QSsort {
  // The main function.
  public static void main(String args[]) {
    String inputArg = args[0];
      
		try {
        //------------------
        // reading the input
        //------------------
		    BufferedReader in = new BufferedReader(new FileReader(inputArg));
        String line = in.readLine ();
        String [] a = line.split (" ");
        int N = Integer.parseInt(a[0]); // first line (N)

        line = in.readLine ();  // second line (the stack)
        a = line.split (" ");

        // data structures
        ArrayList<Integer> queue = new ArrayList<Integer>();
        ArrayList<Integer> stack = new ArrayList<Integer>();
        String response = "";


        // Read initial stack
        for (int i = 0; i < N; i++)
            queue.add(Integer.parseInt(a[i]));
        in.close ();
        
        // print initial stack
        System.out.println("Initial queue " + queue);
        
        
        // Object[] arr = queue.toArray();
        // Arrays.sort(arr);
        
        // ArrayList<Integer> sortedQueue = new ArrayList<Integer>(); 
        ArrayList<Integer> sortedQueue = (ArrayList<Integer>)queue.clone();
        // sortedQueue=queue;
        Collections.sort(sortedQueue);  // Sort cars


        // //Adding array to stack 
        // for (int j = 0; j < arr.length; j++)
        //     sortedQueue.add((int)arr[j]);
    

          System.out.println("Stack after sorting " + sortedQueue);
          System.out.println("Initial queue " + queue);
        

        Solver solver = new BFSolver();
        State initial = new QSState(stack, sortedQueue, queue, response, null);
        State result = solver.solve(initial);
        if (result == null) {
          System.out.println("No solution found.");
        } else {
          printSolution(result);
        }
		} catch (IOException e) {
			e.printStackTrace();
		}

  }

  // A recursive function to print the states from the initial to the final.
  private static void printSolution(State s) {
    if (s.getPrevious() != null) {
      printSolution(s.getPrevious());
    }
    System.out.println(s);
  }
}
