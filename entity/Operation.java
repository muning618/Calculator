package Calculator.entity;

public interface Operation {
	//��ȡ���һλ���ַ�
	public String lastChar(StringBuilder buf);
	
	//��֤�����Ƿ�������0-9
	public boolean bolNum(String num);
	
	//��Ϊ0ʱ�Ĵ���
	public boolean bolZero(StringBuilder builder,String value);
	
	//��������ж�
	public boolean bolChar(String var);
	
	//���������
	public boolean bolOperate(String operate);
	
	//ƥ���������������
	public void doOperate(StringBuilder builder,String value);
	
	//�������ż���
//	public int  leftBracket(StringBuilder builder);
	

	//�����ų��ִ���
	public int countChar(StringBuilder builder,String sign);
	
	//���˸����Ƿ���ڶ���
	public boolean bolCommo(StringBuilder builder);
}
