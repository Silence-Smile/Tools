package smile.silence.tools.framework;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TransformContentPane
  extends JPanel
{
  private static TransformContentPane ourInstance = new TransformContentPane();
  private final RSyntaxTextArea textArea = new RSyntaxTextArea();
  
  public static TransformContentPane getInstance()
  {
    return ourInstance;
  }
  
  private TransformContentPane()
  {
    super(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    textArea.setLineWrap(true);
    textArea.setFont(new Font("微软雅黑", 0, 14));
    textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
    add(new JScrollPane(this.textArea));
  }
  
  public String getText()
  {
    return this.textArea.getText();
  }
  
  public void setText(String t)
  {
    this.textArea.setText(t);
  }
}
