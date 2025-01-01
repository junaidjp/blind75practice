package practice.blind75.basic;

public class CheckPalindrome {

    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str) ? "Palindrome" : "Not a palindrome");
    }

    private static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() -1;

        while(start < end) {


            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end --;
        }

        return true;
    }
}
