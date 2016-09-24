package smile.silence.tools.framework.group;

import smile.silence.tools.framework.unit.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hzxie on 2016/9/24.
 */
public class OptionPanel extends JPanel
{
	private static OptionPanel ourInstance = new OptionPanel();

	public static OptionPanel getInstance()
	{
		return ourInstance;
	}

	private OptionPanel()
	{
		super(new FlowLayout(2, 20, 0));

		add(EncodeDecodeButtonGroup.getInstance());
		add(EncodingComboBox.getInstance());
		add(RevertButton.getInstance());
		add(CopyButton.getInstance());
		add(ClearButton.getInstance());
	}

}
