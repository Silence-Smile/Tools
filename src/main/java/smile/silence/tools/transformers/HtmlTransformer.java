package smile.silence.tools.transformers;

import org.apache.commons.lang3.StringEscapeUtils;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.iface.Transformer;

/**
 * Created by silence on 16-11-27.
 */
public class HtmlTransformer implements Transformer
{
	public String getName()
	{
		return "Html";
	}

	public String getSyntax()
	{
		return SyntaxConstants.SYNTAX_STYLE_NONE;
	}

	public String encode(String origin, String encoding) throws Exception
	{
		return StringEscapeUtils.escapeHtml3(origin);
	}

	public String decode(String origin, String encoding) throws Exception
	{
		return StringEscapeUtils.unescapeHtml3(origin);
	}
}
