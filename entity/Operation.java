package Calculator.entity;

public interface Operation {
	//获取最后一位的字符
	public String lastChar(StringBuilder buf);
	
	//验证输入是否是数字0-9
	public boolean bolNum(String num);
	
	//当为0时的处理
	public boolean bolZero(StringBuilder builder,String value);
	
	//输入符号判断
	public boolean bolChar(String var);
	
	//过滤运算符
	public boolean bolOperate(String operate);
	
	//匹配操作符，并返回
	public void doOperate(StringBuilder builder,String value);
	
	//对左括号计数
//	public int  leftBracket(StringBuilder builder);
	

	//检测符号出现次数
	public int countChar(StringBuilder builder,String sign);
	
	//过滤该数是否存在逗号
	public boolean bolCommo(StringBuilder builder);
}
