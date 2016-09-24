package smile.silence.tools.iface;

import java.io.UnsupportedEncodingException;

public interface Transformer
{
	public String getName();

	public String encode(String origin, String encoding) throws Exception;

	public String decode(String origin, String encoding) throws Exception;
}
