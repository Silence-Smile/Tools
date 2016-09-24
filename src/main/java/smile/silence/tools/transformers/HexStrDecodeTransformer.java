package smile.silence.tools.transformers;


import smile.silence.tools.iface.Transformer;

public class HexStrDecodeTransformer
  implements Transformer
{
  public String getName()
  {
    return "HexStrDecode";
  }
  
  public String transform(String originalStr, String encoding)
  {
    try
    {
      return new String(hexStrToBytes(originalStr), encoding);
    }
    catch (Exception e)
    {
      return "transform error:" + e.getMessage();
    }
  }
  
  private final byte[] hexStrToBytes(String s)
  {
    byte[] bytes = new byte[s.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = ((byte)Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16));
    }
    return bytes;
  }
}
