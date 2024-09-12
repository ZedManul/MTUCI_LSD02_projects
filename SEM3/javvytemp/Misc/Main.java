package Misc;
public class Main{
	public static void main(String[] args) {
		
		String theGreeting = "Greetings";
		String theRecipient = args[0];
		System.out.println(theGreeting.concat(" " + theRecipient));
	}
}