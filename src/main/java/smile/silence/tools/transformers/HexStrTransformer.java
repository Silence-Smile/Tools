package smile.silence.tools.transformers;

import smile.silence.tools.iface.Transformer;

import java.io.UnsupportedEncodingException;

public class HexStrTransformer implements Transformer
{
	public String getName()
	{
		return "HexStr";
	}

	public String encode(String originalStr, String encoding) throws UnsupportedEncodingException
	{
		return bytesToHexStr(originalStr.getBytes(encoding));
	}

	public String decode(String originalStr, String encoding) throws UnsupportedEncodingException
	{
		return new String(hexStrToBytes(originalStr), encoding);
	}

	private final byte[] hexStrToBytes(String s)
	{
		byte[] bytes = new byte[s.length() / 2];
		for (int i = 0; i < bytes.length; i++)
		{
			bytes[i] = ((byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16));
		}
		return bytes;
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

	private static final char[] bcdLookup =
	{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
}
