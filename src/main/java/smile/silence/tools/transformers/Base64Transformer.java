package smile.silence.tools.transformers;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;
import smile.silence.tools.iface.Transformer;

public class Base64Transformer implements Transformer
{
	public String getName()
	{
		return "Base64";
	}

	public String encode(String origin, String encoding) throws Exception
	{
		return Base64.encodeBase64String(origin.getBytes(encoding));
	}

	public String decode(String originalStr, String encoding) throws Exception
	{
		return new String(Base64.decodeBase64(originalStr),encoding);
	}

}
