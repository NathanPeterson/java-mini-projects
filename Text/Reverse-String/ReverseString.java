import java.util.Scanner;

class ReverseString{

  Scanner input = new Scanner(System.in);
  String reverseWord = "";
  String word ="";

  public ReverseString(){
    System.out.print("\n\tEnter a word or sentence: ");
    word = input.nextLine().toLowerCase();
    int wordLength = word.length();

    for (int i = wordLength -1; i >= 0; i--) {
      reverseWord += word.charAt(i);
    }

    System.out.println("\n\tYour word in reverse is: " + reverseWord);
    System.out.println("\tWas your word a Palindrome: " + checkPalindrome() +"\n\n");
  }

  public boolean checkPalindrome(){
    //replaceAll is used in case your word is a sentence.
    //Ex: "Mr Owl Ate My Metal Worm" is a palindrome.
    return word.replaceAll(" ", "").equals(reverseWord.replaceAll(" ", ""));
  }
}
