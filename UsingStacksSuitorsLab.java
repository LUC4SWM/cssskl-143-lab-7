/* CSSSKL 142
 * 
 * UsingStacksSuitorsLab
 * 
 * This class is mostly a driver for playing with Strings as palindromes, 
 * both iteratively and recursively.  The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 * 
 * 
 */

import java.util.LinkedList;
import java.util.Queue;

public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;
	
	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}
	
	public static void main(String[] args) {
		String s1 = "food";		    //not a palindrome
		String s2 = "racecar";      //a palindrome

		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");
		
//		System.out.println(s1 + " reversed is: ");
//		printReverse(s1);
//		System.out.println();
//		System.out.println(s2 + " reversed is: ");
//		printReverse(s2);
		
//	    recPrintReverse(s1);
//		System.out.println();
//		recPrintReverse(s2);
//		System.out.println();
		
//	System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
//		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));
		
//		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
//		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));
		
			int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
		
		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
		/*
		System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());
		*/
	}
		
	public static void printReverse(String target) {
		//todo: use a LLStack
		LLStack foo = new LLStack();
		for (int i = 0; i < target.length(); i++){
			foo.addToStart(String.valueOf(target.charAt(i)));
		}
		while (!foo.isEmpty()){
			System.out.print(foo.deleteHead());
		}
	}
	
	public static void recPrintReverse(String target) {
		//todo
		if (target.length() == 1){
			System.out.print(target);
		} else {
			System.out.print(target.substring(target.length()-1));
			target = target.substring(0,target.length()-1);
			recPrintReverse(target);
		}

	}
	
	public static boolean isPalindrome(String input) {
		//todo: use a stack
		String s = "";
		LLStack lls = new LLStack();
		for (int i = 0; i < input.length(); i++){
			lls.addToStart(String.valueOf(input.charAt(i)));
		}
		while(!lls.isEmpty()){
			s += String.valueOf(lls.deleteHead());
		}
		return input.equals(s); //placeholder
	}

	public static boolean isPalindromeRec(String sentence)	{
	  	//todo
		if (sentence.length() == 0 || sentence.length() == 1){
			return true;
		}
		if (sentence.substring(0,1).equals(sentence.substring(sentence.length()-1))){
			return isPalindromeRec(sentence.substring(1,sentence.length()-1));
		}
		return false;
	}
	
	public static int findPlaceToStand(int numSuitors) {
		//todo
		LLStack forward = new LLStack();
		LLStack backward = new LLStack();
		for (int i = 1; i <= numSuitors; i++){
			forward.addToStart(i);
		}
		boolean fwd = true;
		while (!forward.isEmpty() || !backward.isEmpty()) {
			if (fwd) {
				backward.addToStart(forward.deleteHead());
				if (forward.isEmpty()) {
					fwd = false;
				} else {
					forward.addToStart(backward.deleteHead());
					if (backward.isEmpty()) {
						fwd = true;
					}
				}
			}
		}
			return (int) forward.deleteHead();
		}




	/*
	public static boolean buildThreadQueue() {	//returns true upon success
		Queue<Thread> q = new LinkedList<Thread>(); 
		
		//when our program starts up, it might create multiple threads to use
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		q.enqueue( new Thread(new UsingStacksSuitorsLab()));
		
		System.out.println("Initial Thread order:");
		q.toString();  
		
		//We need to iterate over our pool of threads and call start() on each one
		//Make a loop that dequeues a thread, calls start on it, and //enqueues it again
		//to do:
		//current = get a thread
		//current.start();
		//put the thread back
		
		System.out.println("Thread order after start()ing:");
		q.toString();  
		
		return true;  //on successful start
	}
	*/
	/*
	 * No need to edit anything below here, 
	 * unless you'd like to change the 
	 * behavior of each thread in the thread pool above
	 */
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// do nothing here
			}
		}
	}
}
