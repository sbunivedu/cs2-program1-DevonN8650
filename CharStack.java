public class CharStack
{
  private final int MAX_CAP = 100;
  private int top; //location of top item on the stack
  private char [] s; //The internal array

  public CharStack(){
    //PRE:
    //POS:
    //TAS: Create an empty stack with a default capacity
    s = new char[MAX_CAP];
    top = -1;
  }

  public void push(char element){
    //PRE: Stack not full
    //POS: Element has been added to the top of the CharStack
    //TAS: Add a new item to the stack
    s[++top] = element;
  }

  public char pop (){
    //PRE: Stack not empty
    //POS: ELement has been removed from the top of the CharStack
    //TAS: remove and return the item on the top of the CharStack
    return s[top--];
  }
  public char peek(){
    //PRE: Stack not empty
    //POS:
    //TAS: Return the item on the top of the stack
    return s[top];
  }

  public boolean isEmpty(){
    return (top == -1);
    //PRE: top variable initialized
    //POS: none
    //TAS: Return whether or not the CharStack is empty. HINT: look
    //     at the constructor.
  }

  public boolean isFull(){
    //PRE: top and MAX_CAP variables initialized
    //POS: none
    //TAS: return whether or not the stack is full
    return top == MAX_CAP-1;
  }
  public String toString(){
    String temp = "";
    String pmet = "";
    for(int i = 0; i <= top; i++){
      temp+= s[i];
    }
    for(int i=temp.length() - 1; i >= 0; i--){
      pmet += temp.charAt(i) + " ";
    }
    return pmet;
  }
}
