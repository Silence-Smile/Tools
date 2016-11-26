package smile.silence.tools.framework;

import com.alee.laf.WebLookAndFeel;
import smile.silence.tools.framework.group.OptionPanel;
import smile.silence.tools.framework.group.TransformContentPanel;
import smile.silence.tools.framework.group.TransformerPanel;

import java.awt.Dimension;
import javax.swing.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class TransformTool extends JFrame
{

	private TransformTool()
	{
		initUI();
	}

	public final void initUI()
	{
		JPanel basic = new JPanel();
		basic.setLayout(new BoxLayout(basic, Y_AXIS));
		add(basic);

		basic.add(TransformContentPanel.getInstance());
		basic.add(OptionPanel.getInstance());
		basic.add(TransformerPanel.getInstance());

		setTitle("Transform Tool");
		setSize(new Dimension(835, 600));
		setResizable(true);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				WebLookAndFeel.install();
				TransformTool tt = new TransformTool();
				tt.setVisible(true);
			}
		});
	}
}
