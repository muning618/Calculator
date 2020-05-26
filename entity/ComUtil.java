package Calculator.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComUtil implements Operation{


	
	@Override
	public String lastChar(StringBuilder buf) {
		// TODO Auto-generated method stub
		char last = buf.charAt(buf.length()-1);
		return String.valueOf(last);
	}

	@Override
	public boolean bolNum(String num) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(num);
		return matcher.find();
	}

	

	@Override
	public boolean bolChar(String var) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean bolZero(StringBuilder builder, String value) {
		// TODO Auto-generated method stub
		if((builder.toString()).equals("0")){
			builder.replace(0, 1, value);
		    return true;
	       }

		return false;
	}

	@Override
	public boolean bolOperate(String operate) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[\\+\\-\\*/().]");
		Matcher matcher = pattern.matcher(operate);
		return matcher.find();
	}
	
	public boolean bolOperate2(String operate){
		Pattern pattern = Pattern.compile("[\\+\\-\\*/]");
		Matcher matcher = pattern.matcher(operate);
		return matcher.find();
		
	}

	@Override
	public void doOperate(StringBuilder builder, String value) {
		// TODO Auto-generated method stub
		if("".equals("=")){
			
		}
		if("".equals("c")){
			
		}
		if("".equals("break")){
			
		}
	}

//	@Override
//	public int leftBracket(StringBuilder builder) {
//		// TODO Auto-generated method stub
//		String str = builder.toString();
//	    int count = 0;
//	    int index=0;
//	    
//		while((index=str.indexOf("("))!=-1){
//			count++;
//			str = str.substring(index+1);
//		}
//		return count;
//	}

	

	@Override
	public int countChar(StringBuilder builder, String sign) {
		// TODO Auto-generated method stub
		String str = builder.toString();
	    int count = 0;
	    int index=0;
	    if(sign==null||sign=="")
			try {
				throw new Exception("×Ö·û¸ñÊ½´íÎó£¡");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
		while((index=str.indexOf(sign))!=-1){
			count++;
			str = str.substring(index+1);
		}
		return count;
	}

	@Override
	public boolean bolCommo(StringBuilder builder) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
