package smile.silence.tools.framework;

import java.util.Stack;

public class RevertStack
{
	private static final Stack<TransformContent> STACK = new Stack();

	public static void push(TransformContent content)
	{
		STACK.push(content);
	}

	public static TransformContent pop()
	{
		return STACK.pop();
	}

	public static boolean isEmpty()
	{
		return STACK.isEmpty();
	}

	public static class TransformContent
	{
		private String content;
		private String syntax;

		public TransformContent(String content, String syntax)
		{
			this.content = content;
			this.syntax = syntax;
		}

		public String getContent()
		{
			return content;
		}

		public String getSyntax()
		{
			return syntax;
		}
	}

}
