package smile.silence.tools.framework.unit;

import smile.silence.tools.framework.group.TransformContentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class ClearButton
  extends JButton
{
  private static final ClearButton instance = new ClearButton();
  
  private ClearButton()
  {
    addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        TransformContentPanel.getInstance().setText("");
      }
    });
    setText("Clear");
  }
  
  public static ClearButton getInstance()
  {
    return instance;
  }
}
