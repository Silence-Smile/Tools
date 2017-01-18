package smile.silence.tools.transformers;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.iface.AbstractOneOperationTransformer;

/**
 * Created by silence on 17-1-18.
 */
public class GarbledTransformer extends AbstractOneOperationTransformer
{
	public String getName()
	{
		return "乱码";
	}

	public String getSyntax()
	{
		return SyntaxConstants.SYNTAX_STYLE_NONE;
	}

	public String transform(String origin, String encoding) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		String temp = new String(origin.getBytes(), "GBK");
		sb.append("****** getBytes() -> GBK ******\n" + temp).append("\n");
		temp = new String(origin.getBytes("GBK"), "UTF-8");
		sb.append("****** GBK -> UTF-8 *******\n" + temp).append("\n");
		temp = new String(origin.getBytes("GBK"), "ISO-8859-1");
		sb.append("****** GBK -> ISO-8859-1 *******\n" + temp).append("\n");
		temp = new String(origin.getBytes("ISO-8859-1"), "UTF-8");
		sb.append("****** ISO-8859-1 -> UTF-8 *******\n" + temp).append("\n");
		temp = new String(origin.getBytes("ISO-8859-1"), "GBK");
		sb.append("****** ISO-8859-1 -> GBK *******\n" + temp).append("\n");
		temp = new String(origin.getBytes("UTF-8"), "GBK");
		sb.append("****** UTF-8 -> GBK *******\n" + temp).append("\n");
		temp = new String(origin.getBytes("UTF-8"), "ISO-8859-1");
		sb.append("****** UTF-8 -> ISO-8859-1 *******\n" + temp).append("\n");
		return sb.toString();
	}
}
