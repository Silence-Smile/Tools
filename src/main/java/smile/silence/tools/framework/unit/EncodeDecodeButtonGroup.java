package smile.silence.tools.framework.unit;

import com.alee.extended.panel.WebButtonGroup;
import com.alee.laf.button.WebToggleButton;
import smile.silence.tools.constant.OperationType;

public class EncodeDecodeButtonGroup extends WebButtonGroup
{
	private static WebToggleButton encodeT = new WebToggleButton("Encode");
	private static WebToggleButton decodeT = new WebToggleButton("Decode");
	private static final EncodeDecodeButtonGroup instance = new EncodeDecodeButtonGroup();

    static
    {
        decodeT.setSelected(true);
    }


	private EncodeDecodeButtonGroup()
	{
		super(true, encodeT, decodeT);
	}

	public static EncodeDecodeButtonGroup getInstance()
	{
		return instance;
	}

	public OperationType getOperationType()
    {
        if(encodeT.isSelected())
        {
            return OperationType.Encode;
        }
        else
        {
            return OperationType.Decode;
        }
    }


}