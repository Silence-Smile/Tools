package smile.silence.tools.framework;

import smile.silence.tools.iface.Transformer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class TransformButton
  extends JButton
{
  private Transformer transformer;
  
  public TransformButton(final Transformer transformer)
  {
    this.transformer = transformer;
    addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        String original = TransformContentPane.getInstance().getText();
        if ((original != null) && (original.length() > 0))
        {
          RevertStack.push(original);
          String encoding = (String)EncodingComboBox.getInstance().getSelectedItem();
          TransformContentPane.getInstance().setText(transformer.transform(original, encoding));
        }
      }
    });
    setText(transformer.getName());
  }
}
