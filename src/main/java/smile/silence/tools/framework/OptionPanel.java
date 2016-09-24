package smile.silence.tools.framework;

import com.alee.extended.panel.WebButtonGroup;
import com.alee.laf.button.WebToggleButton;

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
