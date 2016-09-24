package smile.silence.tools.framework;

import com.alee.laf.WebLookAndFeel;
import smile.silence.tools.framework.group.OptionPanel;
import smile.silence.tools.framework.group.TransformContentPane;
import smile.silence.tools.framework.unit.TransformButton;
import smile.silence.tools.iface.Transformer;
import smile.silence.tools.transformers.TransformerContainer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;
import javax.swing.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class TransformTool
  extends JFrame
{
  public TransformTool()
  {
    initUI();
  }
  
  public final void initUI()
  {
    JPanel basic = new JPanel();
    basic.setLayout(new BoxLayout(basic, Y_AXIS));
    add(basic);

    basic.add(TransformContentPane.getInstance());
    basic.add(OptionPanel.getInstance());

    JPanel bottom = new JPanel(new FlowLayout(2, 20, 10));
    
    Iterator<Transformer> transformerIterator = TransformerContainer.getIterator();
    while (transformerIterator.hasNext())
    {
      Transformer t = (Transformer)transformerIterator.next();
      bottom.add(new TransformButton(t));
    }
    basic.add(bottom);
    
    setTitle("Transform Tool");
    setSize(new Dimension(800, 600));
    setResizable(true);
    setDefaultCloseOperation(2);
    setLocationRelativeTo(null);
  }
  
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        WebLookAndFeel.install();
        TransformTool tt = new TransformTool();
        tt.setVisible(true);
      }
    });
  }
}
