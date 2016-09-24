package smile.silence.tools.transformers;

import com.alee.managers.style.skin.web.SyntaxPanelStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.group.TransformContentPane;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by hzxie on 2016/9/24.
 */
public class JsonFormatTransformer implements smile.silence.tools.iface.Transformer
{
	public String getName()
	{
		return "JSON";
	}

	public String encode(String origin, String encoding) throws Exception
	{
		TransformContentPane.getInstance().setSyntax(SyntaxConstants.SYNTAX_STYLE_JSON);
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
		TransformContentPane.getInstance().setSyntax(SyntaxConstants.SYNTAX_STYLE_JSON);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(origin);
		return gson.toJson(je);
	}
}
