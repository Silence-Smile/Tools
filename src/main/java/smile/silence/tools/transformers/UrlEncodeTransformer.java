package smile.silence.tools.transformers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import smile.silence.tools.iface.Transformer;

public class UrlEncodeTransformer
  implements Transformer
{
  public String getName()
  {
    return "UrlEncode";
  }
  
  public String transform(String originalStr, String encoding)
  {
    try
    {
      return URLEncoder.encode(originalStr, encoding);
    }
    catch (UnsupportedEncodingException e)
    {
      return "transform error:" + e.getMessage();
    }
  }
}
