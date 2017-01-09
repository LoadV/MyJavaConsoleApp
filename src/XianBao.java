
public class XianBao
{
	String time = "2017-1-5,20:00";
	String title = "默认标题";
	String content = "默认内容";

	public XianBao(String time ,String title, String content)
	{
		this.time = time;
		this.title = title;
		this.content = content;
	}

	public XianBao()
	{
		
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getTime ()
	{
		return this.time;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getContent()
	{
		return content;
	}
	public static XianBao inflateXianBaoFromString(String string)
	{
		String[] XianBaoData = string.split(":::");
		XianBao result = new XianBao(XianBaoData[0],XianBaoData[1],XianBaoData[2]);
		return result;
	}
}
