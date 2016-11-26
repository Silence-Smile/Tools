package smile.silence.tools.framework.group;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class TransformContentPanel extends JPanel
{
	private static TransformContentPanel ourInstance = new TransformContentPanel();
	private final RSyntaxTextArea textArea = new RSyntaxTextArea();

	public static TransformContentPanel getInstance()
	{
		return ourInstance;
	}

	private TransformContentPanel()
	{
		super(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("微软雅黑", 0, 14));
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
		textArea.setCodeFoldingEnabled(true);
		RTextScrollPane sp = new RTextScrollPane(textArea);
		add(sp);
	}

	public String getText()
	{
		return this.textArea.getText();
	}

	public void setText(String t)
	{
		this.textArea.setText(t);
	}

	public void setSyntax(String syntax)
	{
		textArea.setSyntaxEditingStyle(syntax);
	}

	public void setLineWrap(boolean wrap)
	{
		textArea.setLineWrap(wrap);
	}

	public int getCaretPosition()
	{
		return textArea.getCaretPosition();
	}

	public void setSelectionStart(int start)
	{
		textArea.setSelectionStart(start);
	}

	public void setSelectionEnd(int end)
	{
		textArea.setSelectionEnd(end);
	}





}
