package practice.blind75.linkedList;

public class PrintHyphens {
    public static void printHyphens(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println(); // Add a newline at the end
    }

    public static void main(String[] args) {
        printHyphens(10); // Prints 10 hyphens
    }

  // Method to return a repeated string  
          public static String repeat(String s, int count) {  
StringBuilder result = new StringBuilder();  
for (int i = 0; i < count; i++) {  
result.append(s);  
}  
return result.toString(); // Return the repeated string  
}
}
