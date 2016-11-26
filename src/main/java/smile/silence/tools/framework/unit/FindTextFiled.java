package smile.silence.tools.framework.unit;

import org.apache.commons.codec.binary.StringUtils;
import smile.silence.tools.framework.group.TransformContentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by silence on 16-11-26.
 */
public class FindTextFiled extends JTextField
{
	private final static FindTextFiled instance = new FindTextFiled();
	private String lastFindingText = "";
	private int cursorPos = 0;

	private FindTextFiled()
	{
		this.setPreferredSize(new Dimension(80, 25));
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String findingText = getText();
				if (findingText != null && findingText.length() > 0)
				{
					//换了关键字，搜索起点归零
					if (!lastFindingText.equals(findingText))
					{
						lastFindingText = findingText;
						cursorPos = 0;
					}

					String textAfterCursor = TransformContentPanel.getInstance().getText().substring(cursorPos);
					if (textAfterCursor.indexOf(findingText) != -1)
					{
						//查到下一个，高亮
						int nextPos = textAfterCursor.indexOf(findingText);
						TransformContentPanel.getInstance().setSelectionStart(cursorPos + nextPos);
						int selectionEnd = cursorPos + nextPos + findingText.length();
						TransformContentPanel.getInstance().setSelectionEnd(selectionEnd);
						cursorPos = selectionEnd;

						//查完没有下一个，归0
						String textAfterCursorAfterFind = TransformContentPanel.getInstance().getText().substring(cursorPos);
						if (textAfterCursorAfterFind == null || textAfterCursorAfterFind.indexOf(findingText) == -1)
						{
							cursorPos = 0;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(TransformContentPanel.getInstance(), "找不到：" + findingText);
					}

				}
			}
		});
	}

	public static FindTextFiled getInstance()
	{
		return instance;
	}

}
