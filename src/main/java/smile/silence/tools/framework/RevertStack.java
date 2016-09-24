package smile.silence.tools.framework;

import java.util.Stack;

public class RevertStack
{
  private static final Stack<String> STACK = new Stack();
  
  public static void push(String str)
  {
    STACK.push(str);
  }
  
  public static String pop()
  {
    return (String)STACK.pop();
  }
  
  public static boolean isEmpty()
  {
    return STACK.isEmpty();
  }
}
