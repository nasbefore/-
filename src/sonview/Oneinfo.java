package sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fatherview.IBKmanageView;
import model.FoodModel;

public class Oneinfo implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private FoodModel model;
	private JLabel jLabel1,jLabel2,jLabel3;
	private JPanel jPanel;
	public Oneinfo(FoodModel pm) {
		this.model = pm;
		init();
		dealAction();
	}
	
	@Override
	public void init() {
		jFrame = new JFrame("查询食物信息");
		jFrame.setSize(800, 450);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		
		jLabel1 = new JLabel("",JLabel.CENTER);
		jLabel1.setBounds(0, 0, 800, 130);
		jLabel1.setFont(warningTopicfont);
		jLabel1.setText("食物编号:   "+model.getNumber());
		container.add(jLabel1);
		
		jLabel2 = new JLabel("",JLabel.CENTER);
		jLabel2.setBounds(0, 140, 800, 130);
		jLabel2.setFont(warningTopicfont);
		jLabel2.setText("名字:   "+model.getName());
		container.add(jLabel2);
		
		jLabel3 = new JLabel("",JLabel.CENTER);
		jLabel3.setBounds(0, 280, 800, 130);
		jLabel3.setFont(warningTopicfont);
		jLabel3.setText("数量/Kg:   "+model.getAmount());
		container.add(jLabel3);
	}

	@Override
	public void dealAction() {	
	}

	@Override
	public void showView() {
		jFrame.setVisible(true);
	}

	@Override
	public void exitView() {
		
	}

}
