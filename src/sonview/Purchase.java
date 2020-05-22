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
import model.Buymodel;
import model.FoodModel;
import model.IorOModel;
import model.pricemodel;
import model.storemodel;

public class Purchase implements IBKmanageView {
	private JFrame jFrame;
	private Container container;
	private JPanel jPanel;
	private JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4,jLabel5;
	private JTextField jTextField0,jTextField,jTextField1;
	private JButton jButton1,jButton2,jButton3;
	
	public Purchase() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("采购");
		jFrame.setSize(800, 500);
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
		jPanel.setBounds(0, 0, 800, 800);
		jPanel.setBackground(Color.red);
		jPanel.setLayout(null);
		container.add(jPanel);
		
		jLabel = new JLabel("采购信息",JLabel.CENTER);
		jLabel.setBounds(0,0,800,80);
		jLabel.setFont(topicFont);
		jPanel.add(jLabel);
		
		jLabel = new JLabel("   厂商编号:  ");
		jLabel.setBounds(50,25,400,80);
		jLabel.setFont(topicFont1);
		jPanel.add(jLabel);
		
		jTextField0 = new JTextField();
		jTextField0.setBounds(240, 50, 300, 40);
		jTextField0.setFont(new Font("楷体", Font.BOLD, 26));
		jPanel.add(jTextField0);
		
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
		
		jButton1 = new JButton("确 定");
		jButton1.setBounds(200, 220, 100, 30);
		jButton1.setBackground(Color.PINK);
		jPanel.add(jButton1);
		
		jButton2 = new JButton("清 空");
		jButton2.setBounds(400, 220, 100, 30);
		jButton2.setBackground(Color.PINK);
		jPanel.add(jButton2);
		
		jButton3 = new JButton("查看价格");
		jButton3.setBounds(600, 220, 100, 30);
		jButton3.setBackground(Color.PINK);
		jPanel.add(jButton3);
		
		jLabel3 = new JLabel("1号厂商a商店 ");
		jLabel3.setBounds(50,300,400,80);
		jLabel3.setFont(topicFont1);
		jPanel.add(jLabel3);
		
		jLabel4 = new JLabel("2号厂商b商店  ");
		jLabel4.setBounds(50,350,400,80);
		jLabel4.setFont(topicFont1);
		jPanel.add(jLabel4);
		
		jLabel5 = new JLabel("3号厂商c商店 ");
		jLabel5.setBounds(50,400,400,80);
		jLabel5.setFont(topicFont1);
		jPanel.add(jLabel5);
		
	}

	@Override
	public void dealAction() {
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String stoernumber = jTextField0.getText().toString();
				String foodnumber = jTextField.getText().toString();
				int amount =Integer.parseInt(jTextField1.getText()); 
				Calendar cd =  Calendar.getInstance();
				Date data = cd.getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String Tt = dateFormat.format(data);
				Timestamp T = Timestamp.valueOf(Tt);		
				
				DataSource.initDatabase("model");			
				Query query = new Query();
				String name = null;
				FoodModel pm = query.get(FoodModel.class,foodnumber);
				storemodel inf =query.get(storemodel.class,stoernumber);
				pricemodel pr = query.getsomething(pricemodel.class, foodnumber, stoernumber);
				if(foodnumber == null) {
					Error2 er = new Error2();
					er.showView();
				}
				else {				
					Buymodel cm = new Buymodel();
					cm.setSnumber(stoernumber);
					cm.setFnumber(foodnumber);
					cm.setFname(pm.getName());
					float x= amount*pr.getPrice();
					cm.setAmount(amount);
					cm.setPrice(x);
					cm.setTime(T);
					query.save(cm);
					Success3 sc = new Success3(inf);
					sc.showView();
				}
			}
		});
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("");
				jTextField0.setText("");
				jTextField1.setText("");
			}
		});
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sallinfo().showView();
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
