package smile.silence.tools.framework.unit;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.constant.OperationType;
import smile.silence.tools.framework.RevertStack;
import smile.silence.tools.framework.group.TransformContentPanel;
import smile.silence.tools.iface.Transformer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public final class TransformButton extends JButton
{
	private Transformer transformer;

	public TransformButton(final Transformer transformer)
	{
		this.transformer = transformer;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String original = TransformContentPanel.getInstance().getText();
				if ((original != null) && (original.length() > 0))
				{
					RevertStack.push(new RevertStack.TransformContent(original,SyntaxComboBox.getInstance().getSelectedSyntax()));
					String encoding = (String) EncodingComboBox.getInstance().getSelectedItem();

					String afterTransform;
					try
					{
						if (EncodeDecodeButtonGroup.getInstance().getOperationType() == OperationType.Encode)
						{
							afterTransform = transformer.encode(original, encoding);
						}
						else
						{
							afterTransform = transformer.decode(original, encoding);
						}
						SyntaxComboBox.getInstance().setSelectedSyntax(transformer.getSyntax());

					}
					catch (Exception exc)
					{
						afterTransform = "transform error:" + exc.getMessage();
						SyntaxComboBox.getInstance().setSelectedSyntax(SyntaxConstants.SYNTAX_STYLE_NONE);
					}
					TransformContentPanel.getInstance().setText(afterTransform);
				}
			}
		});
		setText(transformer.getName());
	}
}
