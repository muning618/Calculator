package Calculator.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Calculator.util.OperateUtil;



public class OperateImpl {
	/**
	 * 
	 * @param str  ������������ַ�
	 * @param text ������ַ�
	 * @return
	 */
	//ѧϰ������ʽ�����м��
	public static boolean checkCharacter(StringBuilder str,String text){
		//ֻ��1λ��0ʱ
		
//		if(str.length()==1&&"0".equals(str.toString())){
//			if(text!="0"){
//				//0-9ʱȡ��
//				str.replace(0, 1, text);
//				//+-����������
//			}
//		}
		
//		String inStr = text;
		ComUtil util = new ComUtil();
//		StringBuilder builder = str;
		//��������
		if(util.bolNum(text)){
			//��λ��0
			 
			
//			System.out.println("number!!!");
			//ǰ��������
			if(util.bolNum(util.lastChar(str))==true){
				//��λΪ0���滻
				if(!util.bolZero(str, text)){
					str.append(text);
				 }
				
			}else{
				//ǰһ������
				//�������(),/,x,+,-,.
				//������������c,back,=
				if(util.bolOperate(util.lastChar(str))){
//					System.out.println("??:"+text);
					str.append(text);
					
				}
			}
			
			
			
			
		}else{
			//�������
//			System.out.println("no num!!!");
			//���strΪ0;
			if(str.toString().equals("0")){
				if(text.equals("(")){
					str.replace(0, 1, text);
					return true;
				}
				return false;
			}
			
			//���롣
			if(text.equals(".")){
				int lastIndex = str.length()-1;
//				System.out.println("??");
				String lastStr = str.toString();
//				while((lastIndex=lastStr.lastIndexOf("."))!=-1){
//					System.out.println("last:"+lastIndex);
//					lastStr = lastStr.substring(0,lastIndex);
//				}
				//С��ǰ����������
				if(util.bolNum(util.lastChar(str))){
					
				//�Ӻ���ǰ���������������ǰ��С�����������
				for(int i = lastIndex;i>=0;i--){
					lastStr = String.valueOf(str.charAt(i));
//					System.out.println("lastInput:"+lastStr);
					if(util.bolOperate(lastStr)){
						if(".".equals(lastStr)){
							return false;
						}
						str.append(text);
						System.out.println("??:"+lastStr);
						return true;
					}
				}
				
				}
			}
			
			
			//in ������
			if(text.equals("(")){
				//index=0 replace (
				//str Ϊ 0
//				util.bolZero(str, text);
				
				//str lastIndex is num && not rightBracket
				if(!util.bolNum(util.lastChar(str))&&!")".equals(util.lastChar(str))){
					str.append(text);
					return true;
				}
			
				//str lastIndex is operator
				return false;
				
			}
			//in ������
			//���������>��������
			//str lastIndex is num
			//str lastIndex is operator
			if(text.equals(")")){
				int leftBracket=util.countChar(str, "(");
				int rightBracket=util.countChar(str, ")");
				if(leftBracket>rightBracket){
					if(util.bolNum(util.lastChar(str))||")".equals(util.lastChar(str)))
						str.append(text);
					return true;
				}
				return false;
			}
			
			//���������+-*/
			
			if(util.bolOperate(text)){
				if(util.bolNum(util.lastChar(str))||(util.lastChar(str)).equals(")")){
					str.append(text);
					return true;
				}
				return false;
			}
			//����back
			if(text.equals("back")){
				str.deleteCharAt(str.length()-1);
				if(str.toString().equals("")){
					str.append("0");
				}
				return true;
			}
			//����c
			if(text.equals("c")){
				str.replace(0,str.length(),"0");
				return true;
			}
			
			
			//����=
			if(text.equals("=")){
				
				//=ǰ���������֣����ٰ���һ��������
				if(util.bolNum(util.lastChar(str))||")".equals(util.lastChar(str))){
					if(util.bolOperate2(str.toString())){
						OperateUtil u1 = new OperateUtil();
						try {
						
					    List<String> postfix = u1.prefixByList(str.toString());
						double num = u1.operattionResultByList(postfix);
						String bigDecimal = new BigDecimal(String.valueOf(num)).stripTrailingZeros().toPlainString();
						str.replace(0, str.length(),bigDecimal);
						} catch (NumberFormatException n) {
							// TODO: handle exception
							System.out.println("���ݸ�ʽ�쳣!!");
						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						return true;
					}
				}
				return false;
				
				
				
			}
		}
		
		
		
		return false;
	}
	

}
