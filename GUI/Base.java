package Calculator.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout.Constraints;
import javax.swing.WindowConstants;

public class Base {
	public void init(){
		JFrame jFrame = new JFrame("窗口！");
		jFrame.setSize(250, 250);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel jPanel = new JPanel();
		JButton btn1 = new JButton("测试按钮");
		jPanel.add(btn1);
		
		jFrame.setContentPane(jPanel);
		
		jFrame.setVisible(true);
		
	}
	public void gridFrame(){
		JFrame jf = new JFrame("网格布局");
		jf.setSize(250,300);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel jp = new JPanel(new GridLayout(3, 3));
		
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		jp.add(btn5);
		jp.add(btn6);
		jp.add(btn7);
//		jp.add(btn8);
		
		jf.setContentPane(jp);
		jf.setVisible(true);
	}
	public void gridBagFrame(){
		JFrame jf = new JFrame("测试网格包");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		GridBagLayout grBagLayout = new GridBagLayout();
		JPanel jp = new JPanel(grBagLayout);
		GridBagConstraints constraints = null;
		
		JButton btn1 = new JButton("test1");
		JButton btn2 = new JButton("test2");
		JButton btn3 = new JButton("test3");
		JButton btn4 = new JButton("test4");
		JButton btn5 = new JButton("test5");
		JButton btn6 = new JButton("test6");
		JButton btn7 = new JButton("test7");
		JButton btn8 = new JButton("test8");
		JButton btn9 = new JButton("test9");
		JButton btn10 = new JButton("test10");
		
		constraints= new GridBagConstraints();
		grBagLayout.addLayoutComponent(btn1, constraints);
		
		constraints= new GridBagConstraints();
		grBagLayout.addLayoutComponent(btn2, constraints);
		
		constraints= new GridBagConstraints();
		grBagLayout.addLayoutComponent(btn3, constraints);
		
		constraints= new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn4, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn5, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn6, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
//		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn7, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn8, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn9, constraints);
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		constraints.fill = GridBagConstraints.BOTH;
		grBagLayout.addLayoutComponent(btn10, constraints);
		
		jp.add(btn1);
		jp.add(btn2);
		jp.add(btn3);
		jp.add(btn4);
		jp.add(btn5);
		jp.add(btn6);
		jp.add(btn7);
		jp.add(btn8);
		jp.add(btn9);
		jp.add(btn10);
		
		jf.setContentPane(jp);
		//按组件大小自动适配
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		
	}
	public void jfTextField(){
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jf.setLocationRelativeTo(null);
		jf.setSize(300, 300);
		
		JPanel jp = new JPanel();
		
		JTextField jField = new JTextField("test",8);
		jField.setFont(new Font(null, Font.PLAIN, 20));
		jField.setEditable(false);
		System.out.println(jField.getText());
		jField.setText("update Test!");
		
		jp.add(jField);
		
		jf.setContentPane(jp);
		jf.setVisible(true);
		
		
		
	}
}
