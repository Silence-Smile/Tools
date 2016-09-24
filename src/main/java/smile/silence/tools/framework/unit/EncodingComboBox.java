package smile.silence.tools.framework.unit;

import javax.swing.JComboBox;

public class EncodingComboBox
  extends JComboBox<String>
{
  private static EncodingComboBox ourInstance = new EncodingComboBox();
  
  public static EncodingComboBox getInstance()
  {
    return ourInstance;
  }
  
  private EncodingComboBox()
  {
    addItem("utf-8");
    addItem("gbk");
  }
}
