package smile.silence.tools.framework;

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
  private final JTextArea textArea = new JTextArea();
  
  public static TransformContentPane getInstance()
  {
    return ourInstance;
  }
  
  private TransformContentPane()
  {
    super(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    this.textArea.setLineWrap(true);
    this.textArea.setFont(new Font("������������", 0, 14));
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
