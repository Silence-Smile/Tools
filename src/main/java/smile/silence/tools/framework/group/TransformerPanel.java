package smile.silence.tools.framework.group;

import smile.silence.tools.framework.unit.TransformButton;
import smile.silence.tools.iface.Transformer;
import smile.silence.tools.framework.TransformerContainer;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by hzxie on 2016/9/25.
 */
public class TransformerPanel extends JPanel
{
	private static TransformerPanel ourInstance = new TransformerPanel();

	public static TransformerPanel getInstance()
	{
		return ourInstance;
	}

	private TransformerPanel()
	{
		super(new FlowLayout(2, 20, 10));

		Iterator<Transformer> transformerIterator = TransformerContainer.getIterator();
		while (transformerIterator.hasNext())
		{
			Transformer t = (Transformer) transformerIterator.next();
			add(new TransformButton(t));
		}
	}
}
