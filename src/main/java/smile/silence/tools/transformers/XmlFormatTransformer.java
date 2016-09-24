package smile.silence.tools.transformers;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.group.TransformContentPane;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by hzxie on 2016/9/24.
 */
public class XmlFormatTransformer implements smile.silence.tools.iface.Transformer
{
	public String getName()
	{
		return "XML";
	}

	public String encode(String origin, String encoding) throws Exception
	{
		TransformContentPane.getInstance().setSyntax(SyntaxConstants.SYNTAX_STYLE_XML);
		BufferedReader br = new BufferedReader(new StringReader(origin));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null)
		{
			sb.append(line.trim());
		}
		return sb.toString();
	}

	public String decode(String origin, String encoding) throws Exception
	{
		TransformContentPane.getInstance().setSyntax(SyntaxConstants.SYNTAX_STYLE_XML);
		Source xmlInput = new StreamSource(new StringReader(origin));
		StringWriter stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		transformerFactory.setAttribute("indent-number", 4);
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
		transformer.transform(xmlInput, xmlOutput);
		return xmlOutput.getWriter().toString();
	}
}
