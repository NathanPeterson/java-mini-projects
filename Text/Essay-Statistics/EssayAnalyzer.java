import java.io.*;
import java.util.Scanner;

public class EssayAnalyzer{
  Scanner input = new Scanner(System.in);
  String essay;
  int lengthOfEssay;
  long startTime;

  public EssayAnalyzer(){
    startTime = System.nanoTime();


    inputEssay();

    System.out.println("\n\t\tEssay Statistics".toUpperCase());
    wordCount();
    countVowels();
    letterCount();
    countSpaces();
    paragraphCount();
    sentenceCount();
    processTime();


    System.out.println();
  }

  private void processTime(){
    double estimatedTime = ((double) (System.nanoTime() - startTime)) /1E9;
    System.out.println("\n\tElapsed Time: " + estimatedTime + " seconds");
  }

  private void countSpaces(){
    System.out.println("\tSpaces Count: " + (lengthOfEssay - essay.replaceAll(" ","").length()));
  }

  private void letterCount(){
    System.out.println("\tLetter Count: " + essay.replaceAll("[\\s\\.\\,]","").length());
  }

  private void wordCount(){
    int wordCount = 0;
    boolean tmp = false;
    System.out.print("\tWord Count: ");

    for(int i =0; i<lengthOfEssay; i++){
      if(essay.charAt(i) == ' '){
        wordCount++;
      }
      if(essay.charAt(i) == '\n' && !tmp){
        wordCount++;
        tmp = true;
      }
      else if( ! Character.isWhitespace(essay.charAt(i))){
        tmp = false;
      }
    }

    System.out.println(wordCount);
  }

  private void paragraphCount(){
    int paragraph =0;
    boolean tmp = false;
    for(int i =0; i<lengthOfEssay; i++){
      if(essay.charAt(i) == '\n' && !tmp){
          paragraph++;
          tmp = true;
        }
        else if( ! Character.isWhitespace(essay.charAt(i))){
          tmp = false;
        }
      }
    System.out.println("\tParagraphs: " + paragraph);
  }

  private void sentenceCount(){
    int sentence =0;
    for(int i =0; i<lengthOfEssay; i++){
      if(essay.charAt(i) == '.'){
        sentence++;
      }
    }
    System.out.println("\tSentences: " + sentence);
  }

  private void countVowels(){
    int totalVowels;
    int aCount=0, eCount=0, iCount=0, oCount=0, uCount=0;

    System.out.println("\tVowel Statistics: ");

    for(int i =0; i<lengthOfEssay; i++){
      switch(essay.charAt(i)){
        case 'a': aCount++;
                  break;
        case 'e': eCount++;
                  break;
        case 'i': iCount++;
                  break;
        case 'o': oCount++;
                  break;
        case 'u': uCount++;
                  break;
        default: break;
      }
    }
    totalVowels = aCount + eCount + iCount + oCount + uCount;
    System.out.println("\t  A: " + aCount);
    System.out.println("\t  E: " + eCount);
    System.out.println("\t  I: " + iCount);
    System.out.println("\t  O: " + oCount);
    System.out.println("\t  U: " + uCount);
    System.out.println("\tTotal Vowels: " + totalVowels);
  }


  private void inputEssay(){
    System.out.print("\n\n\tEnter name of text file: ");
    String fileName = input.next() + ".txt";

    try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine().toLowerCase();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    essay = sb.toString();
    lengthOfEssay=sb.length();
    }catch(IOException e){
      System.out.println("Error: File " + fileName +" does not exist.");
    }
  }
}
