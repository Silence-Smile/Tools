package smile.silence.tools.transformers;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
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

	public String getSyntax()
	{
		return SyntaxConstants.SYNTAX_STYLE_XML;
	}

	public String transform(String origin, String encoding) throws Exception
	{
	    String oldDecl = getDecla(origin);
		SAXReader reader = new SAXReader();
		StringReader in = new StringReader(origin);
		Document doc = reader.read(in);
		OutputFormat formater = OutputFormat.createPrettyPrint();
		formater.setEncoding(encoding);
		formater.setIndentSize(4);
		StringWriter out = new StringWriter();
		XMLWriter writer = new XMLWriter(out, formater);
		writer.write(doc);
		writer.close();
		return replaceDecl(out.toString(),oldDecl);
	}

	/**
     * 用原xml头替换dom4j自己生成的头
	 */
	private String replaceDecl(String xml,String newDeclaration)
	{
		return xml.replace(xml.substring(0, xml.lastIndexOf("?>") + 2), newDeclaration).trim();
	}

    /**
     * 得到原xml头
     * @param xml
     * @return
     */
	private String getDecla(String xml)
    {
        String xmlTrim = xml.trim();
        if (xmlTrim.startsWith("<?") && xmlTrim.contains("?>"))
        {
           return xmlTrim.substring(0, xmlTrim.lastIndexOf("?>") + 2);
        }
       return StringUtils.EMPTY;
    }

}
