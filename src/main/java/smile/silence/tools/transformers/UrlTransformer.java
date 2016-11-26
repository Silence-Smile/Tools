package smile.silence.tools.transformers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.unit.SyntaxComboBox;
import smile.silence.tools.iface.Transformer;

public class UrlTransformer implements Transformer
{
	public String getName()
	{
		return "Url";
	}

	public String getSyntax()
	{
		return SyntaxConstants.SYNTAX_STYLE_NONE;
	}

	public String encode(String origin, String encoding) throws Exception
	{
		return URLEncoder.encode(origin, encoding);
	}

	public String decode(String originalStr, String encoding) throws Exception
	{
		return URLDecoder.decode(originalStr, encoding);
	}

}
