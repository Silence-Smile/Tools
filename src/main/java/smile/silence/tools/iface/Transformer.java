package smile.silence.tools.iface;

public abstract interface Transformer
{
  public abstract String getName();
  
  public abstract String transform(String paramString1, String paramString2);
}
