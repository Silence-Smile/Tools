package smile.silence.tools.framework;

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
        TransformContentPane.getInstance().setText("");
      }
    });
    setMnemonic(90);
    setText("Clear");
  }
  
  public static ClearButton getInstance()
  {
    return instance;
  }
}
