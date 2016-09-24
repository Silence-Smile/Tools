package smile.silence.tools.framework.unit;

import smile.silence.tools.constant.OperationType;
import smile.silence.tools.framework.RevertStack;
import smile.silence.tools.framework.group.TransformContentPane;
import smile.silence.tools.framework.unit.EncodingComboBox;
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
				String original = TransformContentPane.getInstance().getText();
				if ((original != null) && (original.length() > 0))
				{
					RevertStack.push(original);
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
					}
					catch (Exception exc)
					{
						afterTransform = "transform error:" + exc.getMessage();
					}
					TransformContentPane.getInstance().setText(afterTransform);
				}
			}
		});
		setText(transformer.getName());
	}
}
