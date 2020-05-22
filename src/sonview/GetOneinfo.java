package sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.DataSource;
import core.Query;
import fatherview.IBKmanageView;
import model.FoodModel;

public class GetOneinfo implements IBKmanageView {
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel;
	private JLabel jLabel,jLabel1;
	private JTextField jTextField;
	private JButton jButton1,jButton2;
	
	public GetOneinfo() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("查询食物信息");
		jFrame.setSize(800, 300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("E:\\学习\\软件工程\\测试用图\\2.jpg");
                g.drawImage(icon.getImage(), 0, 0, 800,300,jFrame);
            }
		};
		jPanel.setBounds(0, 0, 800, 300);
		jPanel.setBackground(Color.red);
		jPanel.setLayout(null);
		container.add(jPanel);
		
		jLabel = new JLabel("查询食物信息",JLabel.CENTER);
		jLabel.setBounds(0,0,800,80);
		jLabel.setFont(topicFont);
		jPanel.add(jLabel);
		
		jLabel1 = new JLabel("   食物编号:  ");
		jLabel1.setBounds(50,80,400,120);
		jLabel1.setFont(topicFont1);
		jPanel.add(jLabel1);
		
		jTextField = new JTextField();
		jTextField.setBounds(240, 120, 300, 40);
		jTextField.setFont(new Font("楷体", Font.BOLD, 26));
		jPanel.add(jTextField);
		
		jButton1 = new JButton("确  定");
		jButton1.setBounds(250, 200, 100, 30);
		jButton1.setBackground(Color.PINK);
		jPanel.add(jButton1);
		
		jButton2 = new JButton("清  空");
		jButton2.setBounds(450, 200, 100, 30);
		jButton2.setBackground(Color.PINK);
		jPanel.add(jButton2);
		
	}

	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String number = jTextField.getText().toString();
				
				DataSource.initDatabase("model");			
				Query query = new Query();
				
				FoodModel info = query.get(FoodModel.class, number);
				if(info == null) {
					Error2 er = new Error2();
					er.showView();
				}
				else {
					Oneinfo view1 = new Oneinfo(info);
					view1.showView();

				}
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("");
			}
		});
	}

	@Override
	public void showView() {
		jFrame.setVisible(true);
	}

	@Override
	public void exitView() {
		
	}
	

}
