package smile.silence.tools.framework.unit;

import smile.silence.tools.framework.RevertStack;
import smile.silence.tools.framework.group.TransformContentPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class RevertButton
  extends JButton
{
  private static final RevertButton instance = new RevertButton();
  
  private RevertButton()
  {
    addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if (!RevertStack.isEmpty()) {
          TransformContentPane.getInstance().setText(RevertStack.pop());
        }
      }
    });
    setText("Revert");
  }
  
  public static RevertButton getInstance()
  {
    return instance;
  }
}
