package smile.silence.tools.transformers;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.unit.SyntaxComboBox;
import smile.silence.tools.iface.AbstractOneOperationTransformer;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by hzxie on 2016/9/24.
 */
public class XmlFormatTransformer extends AbstractOneOperationTransformer
{
	public String getName()
	{
		return "XML";
	}

	public String transform(String origin, String encoding) throws Exception
	{
		Source xmlInput = new StreamSource(new StringReader(origin));
		StringWriter stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		transformerFactory.setAttribute("indent-number", 4);
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
		transformer.transform(xmlInput, xmlOutput);

		SyntaxComboBox.getInstance().setSelectedSyntax(SyntaxConstants.SYNTAX_STYLE_XML);

		return xmlOutput.getWriter().toString();
	}
}
