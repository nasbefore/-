package sonview;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fatherview.IBKmanageView;

public class Success2 implements IBKmanageView {
	private JFrame jFrame;
	private JLabel jLabel;
	
	public Success2() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("成功");
		jFrame.setSize(300,200);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		jLabel = new JLabel("出库成功！",JLabel.CENTER);
		jLabel.setLocation(130, 40);
		jLabel.setFont(TextTopicfont);
		jLabel.setForeground(Color.RED);
		jFrame.add(jLabel);
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
