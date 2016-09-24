package smile.silence.tools.transformers;

import smile.silence.tools.iface.Transformer;

public class HexStrEncodeTransformer
  implements Transformer
{
  public String getName()
  {
    return "HexStrEncode";
  }
  
  public String transform(String originalStr, String encoding)
  {
    try
    {
      return bytesToHexStr(originalStr.getBytes(encoding));
    }
    catch (Exception e)
    {
      return "transform error:" + e.getMessage();
    }
  }
  
  private static final String bytesToHexStr(byte[] bcd)
  {
    StringBuffer s = new StringBuffer(bcd.length * 2);
    for (int i = 0; i < bcd.length; i++)
    {
      s.append(bcdLookup[(bcd[i] >>> 4 & 0xF)]);
      s.append(bcdLookup[(bcd[i] & 0xF)]);
    }
    return s.toString();
  }
  
  private static final char[] bcdLookup = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
}
