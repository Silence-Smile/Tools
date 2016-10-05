package smile.silence.tools.transformers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by hzxie on 2016/10/5.
 */
public class Base64TransformerTest
{
	private Base64Transformer t;

	@Before
	public void init()
	{
		t = new Base64Transformer();
	}


	@Test
	public void EncodeTest() throws Exception
	{
		String result = t.encode("123", "utf-8");
		assertEquals("Base64EncodeError", "MTIz", result);
	}

	@Test
	public void DecodeTest() throws Exception
	{
		String result = t.decode("MTIz", "utf-8");
		assertEquals("Base64DecodeError", "123", result);
	}

}
