package smile.silence.tools.framework;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class CopyButton
  extends JButton
{
  private static final CopyButton instance = new CopyButton();
  
  private CopyButton()
  {
    addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String content = TransformContentPane.getInstance().getText();
        if ((content != null) && (content.length() > 0))
        {
          Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
          Transferable tText = new StringSelection(content);
          clip.setContents(tText, null);
        }
      }
    });
    setText("Copy");
  }
  
  public static CopyButton getInstance()
  {
    return instance;
  }
}
