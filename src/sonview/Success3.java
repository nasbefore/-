package sonview;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fatherview.IBKmanageView;
import model.FoodModel;
import model.storemodel;

public class Success3 implements IBKmanageView {
	private JFrame jFrame;
	private JLabel jLabel,jLabel1;
	private storemodel model;
	
	public Success3(storemodel pm) {
		this.model = pm;
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("成功");
		jFrame.setSize(360,200);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		jLabel = new JLabel("在"+model.getName()+"购买成功！");
		jLabel.setBounds(0, 25, 360, 50);
		jLabel.setFont(TextTopicfont1);
		jLabel.setForeground(Color.RED);
		jFrame.add(jLabel);
		
		jLabel1 = new JLabel("请等待食物送达！");
		jLabel1.setBounds(0, 175, 360, 50);
		jLabel1.setFont(TextTopicfont1);
		jLabel1.setForeground(Color.RED);
		jFrame.add(jLabel1);
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
