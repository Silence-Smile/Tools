package smile.silence.tools.transformers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import smile.silence.tools.iface.AbstractOneOperationTransformer;

/**
 * Created by silence on 16-11-26.
 */
public class PaymentsLogTransformer extends AbstractOneOperationTransformer
{
	public String getName()
	{
		return "PaymentsLog";
	}

	public String getSyntax()
	{
		return SyntaxConstants.SYNTAX_STYLE_JSON;
	}

	public String transform(String origin, String encoding) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		sb.append(origin.substring(origin.indexOf("context[") + 8, origin.indexOf(" -> {"))).append("\r\n\r\n");
		String jsonPart = origin.substring(origin.indexOf(" -> {") + 4, origin.lastIndexOf("}") + 1);

		JSONObject json = JSON.parseObject(jsonPart);
		String sendToBankSource = (String) json.get("SendToBankSource");
		String bankReply = (String) json.get("BankReply");

		if (sendToBankSource != null)
		{
			sb.append(sendToBankSource).append("\r\n\r\n");
		}
		if (bankReply != null)
		{
			sb.append(bankReply).append("\r\n\r\n");
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(jsonPart);
		return sb.append(gson.toJson(je)).toString();
	}
}
