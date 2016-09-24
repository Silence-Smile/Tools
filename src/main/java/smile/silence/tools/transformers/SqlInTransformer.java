package smile.silence.tools.transformers;

import smile.silence.tools.iface.Transformer;

public class SqlInTransformer implements Transformer
{
	public String getName()
	{
		return "SqlIn";
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