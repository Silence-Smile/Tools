package smile.silence.tools.transformers;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.iface.Transformer;

public class SqlInTransformer implements Transformer
{
	public String getName()
	{
		return "SqlIn";
	}

	public String getSyntax()
	{
		return SyntaxConstants.SYNTAX_STYLE_NONE;
	}

	public String encode(String originalStr, String encoding)
	{
		if (originalStr.trim().startsWith("in"))
		{
			return originalStr;
		}
		return originalStr.trim().replaceAll("\r\n", "\n").replaceAll("\n", "','").replaceAll("^", "in ('").replaceAll("$", "')");
	}

	public String decode(String origin, String encoding) throws Exception
	{
		return encode(origin, encoding);
	}
}