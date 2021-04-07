package jsjf;
import java.util.Scanner;
import java.util.Stack;
public class PalindromeChecker
{
	static String QueueStringStatus = "IS";
	 static String StackStringStatus = "IS";
	public static boolean isPalindromeQueue(String Word)
		{
		 LinkedQueue<String> QueueCheck = new LinkedQueue<String>();
		 
		 String letter = new String();
		 
		 for (int i = 0; i < Word.length(); i++) {
	            letter = "" + Word.charAt(i);
	            QueueCheck.enqueue(letter);
	        }
		 int j = Word.length() - 1;
		
		 while(!QueueCheck.isEmpty())
		 {
			 String QueueLetter = QueueCheck.first();
			 String wordLetter = Character.toString(Word.charAt(j));
			 if (!QueueLetter.equals(wordLetter))
			 {
				 QueueStringStatus = "IS NOT";
	                return false;
			 }
			 else {
				 j=j-1;
				QueueCheck.dequeue(); 
			 }	
		 }
		 return true;
		}
	 
	 public static  boolean isPalindromeStack(String Word)
	 {
		 Stack<String> StackCheck = new Stack<String>();
		 String letter = new String();
		 
		 for (int i = 0; i < Word.length(); i++) {
			 letter = "" + Word.charAt(i);
			 StackCheck.push(letter);
		 }
		 int j = 0;
	      
		 while(!StackCheck.isEmpty())
		 {
			 String StackLetter = StackCheck.peek();
			 String wordLetter = Character.toString(Word.charAt(j));
			 if (!StackLetter.equals(wordLetter))
			 {
				 StackStringStatus = "IS NOT";
	                return false;
			 }
			 else {
				 j=j+1;
				StackCheck.pop(); 
			 }	
		 }       
		 
		 return true;
	 }

	public static void main(String[] args)
	{
		int restart = 0;
		
		while(restart == 0)
		{
		System.out.println("Enter a string:");
		 Scanner s = new Scanner(System.in);
	String Input = s.nextLine();
		isPalindromeQueue(Input);
		 isPalindromeStack(Input);
		
		
		System.out.println("According to the queue method that statement " + QueueStringStatus + " a palindrome.");
		System.out.println("According to the stack method that statement " + StackStringStatus + " a palindrome.");
		System.out.println("Try another(y/n)? ");
		Scanner p = new Scanner(System.in);
		String RestartQuestion = p.nextLine();
		if(RestartQuestion.equalsIgnoreCase("y"))
			restart = 0;
		
		else {
			restart = 1;
		}
	}

}
}
