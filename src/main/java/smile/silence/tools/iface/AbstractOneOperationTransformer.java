package smile.silence.tools.iface;

/**
 * Created by hzxie on 2016/9/25.
 */
public abstract class AbstractOneOperationTransformer implements Transformer
{
	public String encode(String origin, String encoding) throws Exception
	{
		return transform(origin, encoding);
	}

	public String decode(String origin, String encoding) throws Exception
	{
		return transform(origin, encoding);
	}

	public abstract String transform(String origin, String encoding) throws Exception;
}
