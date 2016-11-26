package smile.silence.tools.framework.unit;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.group.TransformContentPanel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by hzxie on 2016/9/25.
 */
public class SyntaxComboBox extends JComboBox<String>
{
	private static SyntaxComboBox ourInstance = new SyntaxComboBox();

	public static SyntaxComboBox getInstance()
	{
		return ourInstance;
	}

	private SyntaxComboBox()
	{
		addItem(SyntaxConstants.SYNTAX_STYLE_NONE);
		addItem(SyntaxConstants.SYNTAX_STYLE_XML);
		addItem(SyntaxConstants.SYNTAX_STYLE_JSON);
		addItem(SyntaxConstants.SYNTAX_STYLE_JAVA);
		addItem(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE);
		addItem(SyntaxConstants.SYNTAX_STYLE_UNIX_SHELL);
		addItem(SyntaxConstants.SYNTAX_STYLE_SQL);
		addItem(SyntaxConstants.SYNTAX_STYLE_HTML);
		addItem(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);

		addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					TransformContentPanel.getInstance().setSyntax((String) e.getItem());
				}
			}
		});
	}

	public void setSelectedSyntax(String item)
    {
        setSelectedItem(item);
    }

    public String getSelectedSyntax()
	{
		return (String) getSelectedItem();
	}


}
