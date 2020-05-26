package Calculator.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * describe:����ջ�ı��ʽ����
 * @author TimaNetworks
 *
 */
public class OperateUtil {
	
	/**
	 * describe: ԭʼ���ʽת���ɺ�׺���ʽ
	 * @param expression ԭʼ���ʽ
	 * @return ��׺���ʽ
	 */
	public String postFixExp(String expression) throws Exception{
		//��׺���ʽ
		String postfix = "";
		int size = expression.length();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;expression!=null&&i<size;i++){
			char c = expression.charAt(i);
			//������
			if(isLiftBracket(c)){
				stack.push(c);
				//�����ţ���ջ��������������Ϊֹ
			}else if(isRightBracket(c)){
				char lift = stack.pop();
				while(!isLiftBracket(lift)){
					postfix=postfix+lift;
					lift = stack.pop();
				}
			}else if(isOperator(c)){
				if(!stack.isEmpty()){
					
				
				Character pop = stack.pop();
				while(pop!=null&&priority(pop)>priority(c)){
					postfix+=pop;
					pop = stack.pop();
				}
				
				if(pop!=null){
					stack.push(pop);
				}
				}
				stack.push(c);
			
			}else{
				postfix+=c;
			}
			
		}
		
		while(!stack.isEmpty()){
			postfix=postfix+stack.pop();
		}
		return postfix;
	}
	
	public double OperationResult(String postfix){
		int size = postfix.length();
		Stack<Object> stack = new Stack<Object>();
		
		for(int i=0;postfix!=null&&i<size;i++){
			char single = postfix.charAt(i);
			if(isOperator(single)){
				double d2 = Double.valueOf(stack.pop().toString());
				double d1 = Double.valueOf(stack.pop().toString());
				double d3 = 0;
				switch(single){
				case '+':
					d3 = d2+d1;
					break;
				case '-':
					d3 = d1-d2;
					break;
				case '*':
					d3 = d2*d1;
					break;
				case '/':
					d3 = d1/d2;
					break;
				default:
					break;
				}
				stack.push(d3);
				
				
			}else{
				stack.push(single);
			}
		}
		
		return (double)stack.pop();
	}
	
	/**
	 * ��������ȼ�
	 * @param c
	 * @return
	 */
	private int priority(char c) {
		// TODO Auto-generated method stub
		switch (c) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		
		return 0;
	}
	/**
	 * �жϲ�����
	 * @param c
	 * @return
	 */
	private boolean isOperator(char c) {
		// TODO Auto-generated method stub
		if('+'==c||'-'==c||'*'==c||'/'==c){
			return true;
		}
		return false;
	}
	
	private boolean isOperatorByString(String str){
		if("+".equals(str)||"-".equals(str)||"*".equals(str)||"/".equals(str)){
			return true;
		}
		
		return false;
	}
	/**
	 * �ж��Ƿ�������
	 * @param c
	 * @return
	 */
	private boolean isRightBracket(char c) {
		// TODO Auto-generated method stub
		return ')'==c;
	}
	/**
	 * �Ƿ�������
	 * @param c
	 * @return
	 */
	private boolean isLiftBracket(char c) {
		// TODO Auto-generated method stub
		return '('==c;
	}
	/**
	 * ��list�����׺���ʽ��ÿ���ַ�
	 * @param expresstion
	 * @return
	 */
	public LinkedList<String> prefixByList(String expresstion){
		LinkedList<String> list = new LinkedList<String>();
		Stack<Character> stack = new Stack<Character>();
		int size = expresstion.length();
		String num = "";
		for(int i=0;expresstion!=null&&i<size;i++){
			
			if(" "!=expresstion){
				Character c = expresstion.charAt(i);
				//������
				if(isLiftBracket(c)){
					stack.push(c);
					//������
				}else if(isRightBracket(c)){
					
					if(num!=""){
						list.add(num);
						num="";
					}
					
					Character left = stack.pop();
					while(left!=null&&!isLiftBracket(left)){
						list.add(left.toString());
						left=stack.pop();
					}
					
				}else if(isOperator(c)){
					if(num!=""){
						list.add(num);
						num="";
					}
					
					//ջ��Ų�����
					if(!stack.isEmpty()){
						Character inStack = stack.pop();
//						System.out.println("in:"+inStack);
						while(inStack!=null&&priority(inStack)>priority(c)){
						
							list.add(inStack.toString());
							
//							System.out.println("stack:"+inStack);
							if(!stack.isEmpty()){
								inStack = stack.pop();
							}else{
								inStack=null;
							}
						
							
							
						}
						if(inStack!=null){
							stack.push(inStack);
						}
					}
					
					stack.push(c);
					//�������ֵ����
				}else{
//					list.add(c.toString());
					num=num+c;
				}
				if(size-1==i&&num!=""){
//					System.out.println("=left:"+c);
					list.add(num);
					num="";
				}
			}
		}
		while(!stack.isEmpty()){
//			System.out.println("stack:"+stack);
			list.add(stack.pop().toString());
		}
		
		
		return list;
	}
	
	public double operattionResultByList(List<String> list) throws Exception{
		Stack<Double> stack = new Stack<Double>();
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()){
			String c = iterator.next();
//			System.out.println("c:"+c);
			if(isOperatorByString(c)){
//				
				double d3=0;
				double d2=stack.pop();
				double d1=stack.pop();
				char operate = c.charAt(0);
//				System.out.println("??:"+operate);
				switch (operate) {
				case '+':
					d3=d1+d2;
					break;
				case '-':
					d3=d1-d2;
					break;
				case '*':
					d3=d1*d2;
					break;
				case '/':
					d3=d1/d2;
					break;
				default:
					break;
				}
				stack.push(d3);
			}else{
				stack.push(Double.valueOf(c));
			}
			
			
		}
		
		
		return stack.pop();
		
	}
	
	
}
