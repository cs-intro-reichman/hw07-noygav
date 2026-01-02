/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args)
	{
		System.out.println(isPalindrome("kayak"));
    	//System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String str)
	{
		if(str==null || str.length()<=1)
			return true;
		if(str.charAt(0)==str.charAt(str.length()-1))
			return isPalindrome(str.substring(1, str.length()-1));
		return false;
    }
}