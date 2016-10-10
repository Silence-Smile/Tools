package smile.silence.tools.transformers;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.unit.SyntaxComboBox;
import smile.silence.tools.iface.AbstractOneOperationTransformer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by hzxie on 2016/9/25.
 */
public class QueryStringTransformer extends AbstractOneOperationTransformer
{
	public String getName()
	{
		return "QueryStr";
	}

	public String transform(String origin, String encoding) throws Exception
	{
		if (origin.indexOf("?") != -1)
		{
			origin = origin.substring(origin.indexOf("?") + 1);
		}
		String[] kvs = origin.split("&");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < kvs.length; i++)
		{
			sb.append(kvs[i]);
			if (i != kvs.length - 1)
			{
				sb.append("\r\n");
			}
		}
		SyntaxComboBox.getInstance().setSelectedSyntax(SyntaxConstants.SYNTAX_STYLE_PROPERTIES_FILE);
		return sb.toString();
	}
}
