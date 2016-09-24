package smile.silence.tools.transformers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import smile.silence.tools.iface.Transformer;

public class TransformerContainer
{
	private static final List<Transformer> transformers = new ArrayList();

	static
	{
		regist(new HexStrTransformer());
		regist(new UrlTransformer());
		regist(new SqlInTransformer());
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
