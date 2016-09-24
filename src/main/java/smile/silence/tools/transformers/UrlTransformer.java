package smile.silence.tools.transformers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import smile.silence.tools.iface.Transformer;

public class UrlTransformer implements Transformer
{
	public String getName()
	{
		return "Url";
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
