package smile.silence.tools.framework.unit;

import smile.silence.tools.framework.group.TransformContentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by hzxie on 2016/9/25.
 */
public class LineWrapCheckBox extends JCheckBox
{
	private static LineWrapCheckBox ourInstance = new LineWrapCheckBox();

	public static LineWrapCheckBox getInstance()
	{
		return ourInstance;
	}

	private LineWrapCheckBox()
	{
		addItemListener(new ItemListener() {
			JCheckBox jCheckBox;

			public void itemStateChanged(ItemEvent e)
			{
				jCheckBox = (JCheckBox) e.getSource();
				TransformContentPanel.getInstance().setLineWrap(jCheckBox.isSelected());
			}
		});
        setSelected(true);
		setText("LineWrap");
	}
}