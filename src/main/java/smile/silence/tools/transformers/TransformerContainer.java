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
    register(new HexStrDecodeTransformer());
    register(new UrlEncodeTransformer());
    register(new UrlDecodeTransformer());
    register(new SqlInTransformer());
  }
  
  private static void register(Transformer transformer)
  {
    transformers.add(transformer);
  }
  
  public static Iterator<Transformer> getIterator()
  {
    return transformers.iterator();
  }
}
