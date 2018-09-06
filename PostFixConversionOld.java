import java.util.Scanner;
public class PostFixConversionOld{
  private CharStack opstack = new CharStack();
  private Scanner scanner = new Scanner(System.in);
  private String userInput;
  public PostFixConversionOld(){
    System.out.print("Please input your infix expression: ");
    userInput = scanner.nextLine();
    System.out.print("Postfix conversion: ");
    if(userInput != null){
      char currentChar;
      int currentAscii;
      for(int i = 0; i < userInput.length(); i++){
        currentChar = userInput.charAt(i);
        currentAscii = (int) currentChar;
        if((currentAscii > 64 && currentAscii < 91) || (currentAscii > 96 && currentAscii < 123) || (currentAscii > 48 && currentAscii < 58)){ //if AZ or az or 0-9
          System.out.print(currentChar);
        }
        else if(currentChar == '(' || currentChar == '*' || currentChar == '/' || currentChar == '+' || currentChar == '-' || currentChar == ')'){
          System.out.println("this");
          opstack.push(currentChar);
        }
      }
      System.out.println();
    }
    while(!opstack.isEmpty()){
      System.out.println("here");
      while(opstack.peek()!=')' &&  !opstack.isEmpty()){
        System.out.println("h e r e");
        if(opstack.peek() == '(') opstack.pop();
        else System.out.print(opstack.pop());
      }
    }
  }

}