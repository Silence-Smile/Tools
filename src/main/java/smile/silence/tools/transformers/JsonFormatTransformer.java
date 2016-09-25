package smile.silence.tools.transformers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.framework.unit.SyntaxComboBox;
import smile.silence.tools.iface.AbstractOneOperationTransformer;

/**
 * Created by hzxie on 2016/9/24.
 */
public class JsonFormatTransformer extends AbstractOneOperationTransformer
{
	public String getName()
	{
		return "JSON";
	}

	public String transform(String origin, String encoding) throws Exception
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(origin);

		SyntaxComboBox.getInstance().setSelectedSyntax(SyntaxConstants.SYNTAX_STYLE_JSON);

		return gson.toJson(je);
	}
}
