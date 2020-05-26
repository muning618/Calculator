package Calculator.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Calculator.entity.OperateImpl;

public class Model {
	private static  Model model=null;
	private JFrame jf;
	private JPanel jp;
	private JTextField jtf;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	private StringBuilder sb;
	
	public static Model getInstance(){
		if(model==null){
			model= new Model();
		}
		return model;
	}
	private Model(){
		init();
	}
	//初始化
	private void init() {
		// TODO Auto-generated method stub
		jf=new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(300,400);
		jf.setLocationRelativeTo(null);
		
		sb = new StringBuilder("0");
		gbl = new GridBagLayout();
		jp=new JPanel(gbl);
		//添加计算器显示框
		addJtf();
		//添加第一行操作
		addBtn1();
		
		addBtn2();
		
		addBtn3();
		
		addBtn4();
		
		addBtn5();
		
		
		jf.setContentPane(jp);
		jf.setVisible(true);
	}
	private void addBtn5() {
		// TODO Auto-generated method stub
		gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		makeButton("c",gbc);
		makeButton("0", gbc);
		makeButton(".", gbc);

//		gbc.gridwidth=GridBagConstraints.REMAINDER;
		makeButton("=", gbc);
	}
	private void addBtn4() {
		// TODO Auto-generated method stub
		gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		makeButton("1",gbc);
		makeButton("2", gbc);
		makeButton("3", gbc);

		gbc.gridwidth=GridBagConstraints.REMAINDER;
		makeButton("+", gbc);
	}
	private void addBtn3() {
		// TODO Auto-generated method stub
		gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		makeButton("4",gbc);
		makeButton("5", gbc);
		makeButton("6", gbc);

		gbc.gridwidth=GridBagConstraints.REMAINDER;
		makeButton("-", gbc);
	}
	//添加button按钮
	public void makeButton(String str,GridBagConstraints gbc){
		JButton jb = new JButton(str);
		jb.setFont(new Font(str, Font.BOLD, 15));
		gbl.setConstraints(jb, gbc);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn = (JButton)e.getSource();
				String t = btn.getText();
//				if(t.length()==1&&"0".equals(t)){
//					
//				}
				//检验操作是否正常，并对str操作
				OperateImpl.checkCharacter(sb,t);
//				sb.append(t);
				jtf.setText(sb.toString());
				
			}
		});
		jp.add(jb);
	}
	private void addBtn2() {
		// TODO Auto-generated method stub
		
		gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		makeButton("7",gbc);
		makeButton("8", gbc);
		makeButton("9", gbc);

		gbc.gridwidth=GridBagConstraints.REMAINDER;
		makeButton("*", gbc);	
	}
	private void addBtn1() {
		// TODO Auto-generated method stub
		gbc = new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		makeButton("(",gbc);
		makeButton(")", gbc);
		makeButton("/", gbc);

	
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		makeButton("back", gbc);
		
	}
	private void addJtf() {
		// TODO Auto-generated method stub
		jtf=new JTextField(10);
		jtf.setEditable(false);
		jtf.setText("0");
		jtf.setHorizontalAlignment(JTextField.RIGHT);
		jtf.setFont(new Font(null, Font.PLAIN, 20));
		gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbl.setConstraints(jtf, gbc);
		jp.add(jtf);
		
	}
	
}
