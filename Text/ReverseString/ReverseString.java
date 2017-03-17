import java.util.Scanner;

class ReverseString{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String reverseWord = "";

    System.out.print("Enter a word: ");
    String word = input.nextLine();
    int wordLength = word.length();

    for (int i = wordLength -1; i >= 0; i--) {
      reverseWord += word.charAt(i);
    }

    System.out.println("\nYour word in reverse is: " + reverseWord +"\n\n");

  }
}
