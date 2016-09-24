package smile.silence.tools.framework;

import com.alee.extended.panel.WebButtonGroup;
import com.alee.laf.button.WebToggleButton;

class EncodeDecodeButtonGroup extends WebButtonGroup
{
	private static WebToggleButton encodeT = new WebToggleButton("Encode");
	private static WebToggleButton decodeT = new WebToggleButton("Decode");
	public static final EncodeDecodeButtonGroup instance = new EncodeDecodeButtonGroup();

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

}