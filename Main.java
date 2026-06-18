import java.util.*;
// Skip List Implementation Skeleton. 

import java.util.*;

public class Main {

	final public static int NEG_INF = Integer.MIN_VALUE;
	final public static int POS_INF = Integer.MAX_VALUE;
	
	public static Random rndObj = new Random();
	
	private ArrayList<node> levels;
	private int size;
	
	// Makes an empty list.
	public Main() {

		// Initially, I am just one level with min and max.
		levels = new ArrayList<node>();
		levels.add(buildLevel(0));
		size = 1;
	}

	// This builds level id to be an empty level.
	public node buildLevel(int id) {
		node first = new node(NEG_INF, id);
		node last = new node(POS_INF, id);
		first.next = last;
		last.prev = first;		
		return first;
	}
	
	// Returns a list of nodes at each level that are right before value.
	public ArrayList<node> search(int value) {
		
		
	}
	
  //****************************
	// Inserts value into the set, returns true iff the value was inserted. (False means the
	// value was already in the set.
	public boolean insert(int value) {
				
		
	}
	
	// Deletes value from the list. Returns true if value was in the list and was deleted.
	// Returns false if value wasn't in the list and takes no action.
	public boolean delete(int value) {
		
		
	}
	
	// Returns the number of items on the top level.
	private int topLevelSize() {
		node cur = levels.get(size-1);
		int sz = 0;
		while (cur != null) {
			cur = cur.next;
			sz++;
		}
		return sz;
	}
	
	// Connects the last level to the rest of the lists.
	public void connectLastLevel() {
		
		// We can obtain both of these.
		node top = levels.get(levels.size()-1);
		node below = levels.get(levels.size()-2);
		
		// Link left sides up and down.
		top.down = below;
		below.up = top;
		
		// End of top list.
		top = top.next;
		
		// Go to end of second to top list.
		while (below.data != POS_INF) below = below.next;
		
		// Link right sides up and down.
		top.down = below;
		below.up = top;
	}
	
	// For debugging.
	public void printAllLevels() {
		System.out.println(levels.size()+" and "+size);
		for (int i=0; i<size; i++) {
			System.out.print("Level "+i+": ");
			printLevel(i);
		}
		System.out.println("---------------------------");
	}
	
	// Prints level id. For debugging.
	public void printLevel(int id) {
		node cur = levels.get(id);
		while (cur != null) {
			System.out.print(cur.data+" ");
			cur = cur.next;
		}
		System.out.println();
	}
	

	
	// Basic insert test.
	public static void basicInsertTest() {
		
		// Create the object.
		Main mine = new Main(); //this constructor creates a level as well
		
		// Do 100 inserts.
		for (int i=0; i<10; i++) {
			
			// Generate the item.
			int item = rndObj.nextInt(1000);
			System.out.println("Gen "+item);
			
			// Insert it.
			boolean flag = mine.insert(item);
			
			// Print what happened.
			if (flag)
				System.out.println("Inserted "+item);
			else
				System.out.println("Rejected "+item);
			
			// See all the lists.
			mine.printAllLevels();
		}
    //Let us delete
    Scanner sc = new Scanner(System.in);
    int item = 0;
    while(item !=-1)
    {
    
      System.out.println("Enter an item to delete: ");
      item = sc.nextInt();
      boolean flag = mine.delete(item);
			if (flag)
      {
					System.out.println("Deleted "+item);
         	mine.printAllLevels();
      }
				else
					System.out.println(item+" can not be deleted.");
    }


	}
	
	
		
	public static void main(String[] args) {
	//	largeTestRandom();
    basicInsertTest();
	}
	
}

class node {

	public int data;
  public node next, prev, up, down;
	public int level;
  
	// public node next;
	// public node prev;
	// public node up;
	// public node down;
	// public int level;

	public node(int myval, int mylev) {
		data = myval;
		level = mylev;
		next = null;
		prev = null;
		up = null;
		down = null;
	}

}
