package smile.silence.tools.framework;

import com.alee.extended.panel.WebButtonGroup;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebToggleButton;
import com.alee.laf.rootpane.WebFrame;
import smile.silence.tools.iface.Transformer;
import smile.silence.tools.transformers.TransformerContainer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;
import javax.swing.*;

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
    basic.setLayout(new BoxLayout(basic, 1));
    add(basic);
    
    basic.add(TransformContentPane.getInstance());
    
    JPanel boxPanel = new JPanel(new FlowLayout(2, 20, 0));
    WebToggleButton encodeT = new WebToggleButton ( "Encode" );
    WebToggleButton decodeT = new WebToggleButton ( "Decode" );
    decodeT.setSelected(true);
    WebButtonGroup textGroup = new WebButtonGroup ( true, encodeT, decodeT );
    boxPanel.add(textGroup);

    boxPanel.add(EncodingComboBox.getInstance());
    boxPanel.add(RevertButton.getInstance());
    boxPanel.add(CopyButton.getInstance());
    boxPanel.add(ClearButton.getInstance());

    basic.add(boxPanel);

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
