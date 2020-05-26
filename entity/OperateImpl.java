package Calculator.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Calculator.util.OperateUtil;



public class OperateImpl {
	/**
	 * 
	 * @param str  计算器保存的字符
	 * @param text 输入的字符
	 * @return
	 */
	//学习正则表达式，进行检测
	public static boolean checkCharacter(StringBuilder str,String text){
		//只有1位是0时
		
//		if(str.length()==1&&"0".equals(str.toString())){
//			if(text!="0"){
//				//0-9时取代
//				str.replace(0, 1, text);
//				//+-操作符错误
//			}
//		}
		
//		String inStr = text;
		ComUtil util = new ComUtil();
//		StringBuilder builder = str;
		//输入数字
		if(util.bolNum(text)){
			//首位是0
			 
			
//			System.out.println("number!!!");
			//前面是数字
			if(util.bolNum(util.lastChar(str))==true){
				//首位为0被替换
				if(!util.bolZero(str, text)){
					str.append(text);
				 }
				
			}else{
				//前一个非数
				//运算符：(),/,x,+,-,.
				//其它操作符：c,back,=
				if(util.bolOperate(util.lastChar(str))){
//					System.out.println("??:"+text);
					str.append(text);
					
				}
			}
			
			
			
			
		}else{
			//输入非数
//			System.out.println("no num!!!");
			//如果str为0;
			if(str.toString().equals("0")){
				if(text.equals("(")){
					str.replace(0, 1, text);
					return true;
				}
				return false;
			}
			
			//输入。
			if(text.equals(".")){
				int lastIndex = str.length()-1;
//				System.out.println("??");
				String lastStr = str.toString();
//				while((lastIndex=lastStr.lastIndexOf("."))!=-1){
//					System.out.println("last:"+lastIndex);
//					lastStr = lastStr.substring(0,lastIndex);
//				}
				//小数前必须是数字
				if(util.bolNum(util.lastChar(str))){
					
				//从后往前遍历，如盗操作符前无小数，可以添加
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
			
			
			//in 左括号
			if(text.equals("(")){
				//index=0 replace (
				//str 为 0
//				util.bolZero(str, text);
				
				//str lastIndex is num && not rightBracket
				if(!util.bolNum(util.lastChar(str))&&!")".equals(util.lastChar(str))){
					str.append(text);
					return true;
				}
			
				//str lastIndex is operator
				return false;
				
			}
			//in 右括号
			//左侧必须存在>右括号数
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
			
			//输入操作符+-*/
			
			if(util.bolOperate(text)){
				if(util.bolNum(util.lastChar(str))||(util.lastChar(str)).equals(")")){
					str.append(text);
					return true;
				}
				return false;
			}
			//输入back
			if(text.equals("back")){
				str.deleteCharAt(str.length()-1);
				if(str.toString().equals("")){
					str.append("0");
				}
				return true;
			}
			//输入c
			if(text.equals("c")){
				str.replace(0,str.length(),"0");
				return true;
			}
			
			
			//输入=
			if(text.equals("=")){
				
				//=前必须是数字，至少包含一个操作符
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
							System.out.println("数据格式异常!!");
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
