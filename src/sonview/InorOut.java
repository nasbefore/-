package sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import model.IorOModel;

public class InorOut implements IBKmanageView {
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel;
	private JLabel jLabel,jLabel1,jLabel2;
	private JTextField jTextField,jTextField1;
	private JButton jButton1,jButton2;
	
	public InorOut() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("入库/出库");
		jFrame.setSize(800, 300);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);
		
		jPanel = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("E:\\学习\\软件工程\\测试用图\\4.png");
                g.drawImage(icon.getImage(), 0, 0, 800,300,jFrame);
            }
		};
		jPanel.setBounds(0, 0, 800, 300);
		jPanel.setBackground(Color.red);
		jPanel.setLayout(null);
		container.add(jPanel);
		
		jLabel = new JLabel("食物入库/食物出库",JLabel.CENTER);
		jLabel.setBounds(0,0,800,80);
		jLabel.setFont(topicFont);
		jPanel.add(jLabel);
		
		jLabel1 = new JLabel("   食物编号:  ");
		jLabel1.setBounds(50,75,400,80);
		jLabel1.setFont(topicFont1);
		jPanel.add(jLabel1);
		
		jTextField = new JTextField();
		jTextField.setBounds(240, 100, 300, 40);
		jTextField.setFont(new Font("楷体", Font.BOLD, 26));
		jPanel.add(jTextField);
		
		jLabel2 = new JLabel("   食物数量/Kg:  ");
		jLabel2.setBounds(50,125,400,80);
		jLabel2.setFont(topicFont1);
		jPanel.add(jLabel2);
		
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(240, 150, 300, 40);
		jTextField1.setFont(new Font("楷体", Font.BOLD, 26));
		jPanel.add(jTextField1);
		
		jButton1 = new JButton("入  库");
		jButton1.setBounds(230, 220, 100, 30);
		jButton1.setBackground(Color.PINK);
		jPanel.add(jButton1);
		
		jButton2 = new JButton("出  库");
		jButton2.setBounds(430, 220, 100, 30);
		jButton2.setBackground(Color.PINK);
		jPanel.add(jButton2);
		
	}

	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodnumber = jTextField.getText().toString();
				int amount =Integer.parseInt(jTextField1.getText()); 
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Tt = dateFormat.format(data);
				Timestamp T = Timestamp.valueOf(Tt);		
				
				DataSource.initDatabase("model");			
				Query query = new Query();
				
				FoodModel pm = query.get(FoodModel.class,foodnumber);
				if(foodnumber == null) {
					Error2 er = new Error2();
					er.showView();
				}
				else {				
					int num;
					num = pm.getAmount()+amount;
					query.updateBynumber(FoodModel.class, num, foodnumber);
					IorOModel cm = new IorOModel();
					cm.setFnumber(foodnumber);
					cm.setS("入库");
					cm.setAmount(amount);
					cm.setTime(T);
					query.save(cm);
					Success1 sc = new Success1();
					sc.showView();
				}
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String foodnumber = jTextField.getText().toString();
				int amount =Integer.parseInt(jTextField1.getText()); 
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String STtime = dateFormat.format(data);
				Timestamp T = Timestamp.valueOf(STtime);		
				
				DataSource.initDatabase("com.mec.bookmanage.model");			
				Query query = new Query();
				
				FoodModel pm = query.get(FoodModel.class,foodnumber);
				if(foodnumber == null) {
					Error2 er = new Error2();
					er.showView();
				}
				else {				
					int num;
					num = pm.getAmount()-amount;
					if (num < 0)
						{Error3 er = new Error3();
						er.showView();
						}
					else {
					query.updateBynumber(FoodModel.class, num, foodnumber);
					IorOModel cm = new IorOModel();
					cm.setFnumber(foodnumber);
					cm.setS("出库");
					cm.setAmount(amount);
					cm.setTime(T);
					query.save(cm);
					Success2 sc = new Success2();
					sc.showView();
					}
				}
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
