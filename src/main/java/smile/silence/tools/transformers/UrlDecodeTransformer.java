package smile.silence.tools.transformers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import smile.silence.tools.iface.Transformer;

public class UrlDecodeTransformer
  implements Transformer
{
  public String getName()
  {
    return "UrlDecode";
  }
  
  public String transform(String originalStr, String encoding)
  {
    try
    {
      return URLDecoder.decode(originalStr, encoding);
    }
    catch (UnsupportedEncodingException e)
    {
      return "transform error:" + e.getMessage();
    }
  }
}
