import java.util.Scanner;
public class PostFixConversion{
  String output = "";
  CharStack stack = new CharStack();
  Scanner scanner = new Scanner(System.in);
  public PostFixConversion(){
    //stringReader(getInput());
    stringReader(getInput());
    postRead();
    output = "";
  }
  public String getInput(){
    System.out.print("Please input your infix expression: ");
    String x = scanner.nextLine();
    if (x.length() == 0) x = getInput();
    return x;
  }
  public void stringReader(String in){
    for(int i = 0; i < in.length(); i++){
      if(isOperand(in.charAt(i))) output += in.charAt(i);
      else if(in.charAt(i) == '(') stack.push(in.charAt(i));
      else if(in.charAt(i) == ')'){
        while(!stack.isEmpty()){
          if(stack.peek() != '('){
            output += stack.pop();
            //System.out.println(stack.toString());
          }
          else{
            break;
          }
        }
        if(!stack.isEmpty())stack.pop();//dont really need the if, but.....
      }/*
      else if(isOperator(in.charAt(i))){
        System.out.println("operator get me the navy");
        String temp = "";
        while(!stack.isEmpty()){
          System.out.println("test");
          temp += stack.pop();
        }
        System.out.println(output);
        for(int j = 0; j < temp.length(); j++){
          if(precedenceOrder(temp.charAt(j)) >= precedenceOrder(in.charAt(i))) output+= temp.charAt(j);
          System.out.println("thisisis");
          stack.push(temp.charAt(temp.length()-1-j));
        }
        stack.push(in.charAt(i));
      }*/


      /*else if(isOperator(in.charAt(i))){
        while(!stack.isEmpty()){
          if(precedenceOrder(stack.peek()) >= precedenceOrder(in.charAt(i))) output += stack.pop();
          else break;
        }
        stack.push(in.charAt(i));
      }*/
      ////////////////////////////////////////////////////////////////////////////////////////////////
      else if(isOperator(in.charAt(i))){
        while(!stack.isEmpty() && stack.peek() != '(' && precedenceOrder(stack.peek()) >= precedenceOrder(in.charAt(i))){
          output += stack.pop();
        }
        stack.push(in.charAt(i));
        //System.out.println(stack.toString());
      }
      ////////////////////////////////////////////////////////////////////////////////////////////////      //System.out.println(stack.toString());
    }
  }
  public void postRead(){
    while(!stack.isEmpty()){
      output += stack.pop();
    }
    System.out.println("Postfix conversion: " + output.replace("(",""));
  }
  public boolean isOperand(char c){
    if(
      (c>='a' && c<='z') ||
      (c>='A' && c<='Z') ||
      (c>='0' && c<='9')){
        return true;
      }else{
        return false;
      }
  }

  public boolean isOperator(char c){
    return c=='+' || c=='-' || c=='*' || c=='/';
  }

  public int precedenceOrder(char c){
      if(c == '*' || c == '/')return 2;
      return 1;
  }

}