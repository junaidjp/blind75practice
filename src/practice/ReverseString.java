package practice;

public class ReverseString {
    public static void main(String args[]) {

        String test ="junaid";
        test = reverseString(test);
        System.out.println(test);
    }

    private static String reverseString(String test) {

    char chars[] = test.toCharArray();
    int left = 0;
    int right = test.length() -1 ;
    while(left < right) {

        char temp  = chars[left];

        chars[left] = chars[right];

        chars[right] = temp;
        left ++;
        right --;





    }

return new String(chars);

    }


}
