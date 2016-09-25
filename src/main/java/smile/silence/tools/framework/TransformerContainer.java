package smile.silence.tools.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import smile.silence.tools.iface.Transformer;
import smile.silence.tools.transformers.*;

public class TransformerContainer
{
	private static final List<Transformer> transformers = new ArrayList();

	static
	{
		regist(new HexStrTransformer());
		regist(new Base64Transformer());
		regist(new UrlTransformer());
		regist(new SqlInTransformer());
		regist(new QueryStringTransformer());
		regist(new XmlFormatTransformer());
		regist(new JsonFormatTransformer());
	}

	private static void regist(Transformer transformer)
	{
		transformers.add(transformer);
	}

	public static Iterator<Transformer> getIterator()
	{
		return transformers.iterator();
	}
}
