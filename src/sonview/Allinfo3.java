package sonview;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import core.DataSource;
import core.Query;
import fatherview.IBKmanageView;
import model.Buymodel;
import model.FoodModel;
import model.IorOModel;

public class Allinfo3 implements IBKmanageView{
	private JFrame jFrame;
	private Container container;
	private JLabel jLabel;
	private JPanel jPanel;
	private JTable jTable;
	private String snum,fnum,fn,amount,price,time;

	public Allinfo3() {
		init();
		dealAction();
	}

	@Override
	public void init() {
		jFrame = new JFrame("采购信息");
		jFrame.setSize(800, 600);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		container = jFrame.getContentPane();
		container.setLayout(null);		
		
		
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"厂商编号","食物编号","食物名称","数量/Kg","总价","采购时间"});
		
		List<Buymodel> BuyModellList = showMessage();
		for (Buymodel foodinfo2 : BuyModellList) {
			String foodAllInfo = foodinfo2.toString();	
			String[] foodAllInfoArray = foodAllInfo.split(",");
			for(int i = 0; i < foodAllInfoArray.length;i++) {
				 snum = foodAllInfoArray[0];
				 fnum = foodAllInfoArray[1];
				 fn = foodAllInfoArray[2];	
				 amount = foodAllInfoArray[3];
				 price = foodAllInfoArray[4];
				 time = foodAllInfoArray[5];
			}
			model.addRow(new Object[]{snum,fnum,fn,amount+"kg",price,time});
		}
		
		jTable=new JTable(model);
		jTable.setEnabled(false);
		jTable.setRowHeight(50);
		jTable.setFont(new Font("楷体", Font.BOLD, 17));
		jTable.setSelectionForeground(Color.red);
		
		TableColumnModel tc = jTable.getColumnModel();
		TableColumn tm0 = tc.getColumn(0);
		TableColumn tm1 = tc.getColumn(1);
		TableColumn tm2 = tc.getColumn(2);
		TableColumn tm3 = tc.getColumn(3);
		TableColumn tm4 = tc.getColumn(4);
		TableColumn tm5 = tc.getColumn(5);
		tm0.setPreferredWidth(30);
		tm1.setPreferredWidth(50);
		tm2.setPreferredWidth(80);
		tm3.setPreferredWidth(80);
		tm4.setPreferredWidth(80);
		tm5.setPreferredWidth(180);
		
		
		
		
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(0, 80, 790, 480);
		jScrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		container.add(jScrollPane);
		
		jPanel = new JPanel() {
			public void paintComponent(Graphics g) {
                ImageIcon icon =new ImageIcon("E:\\学习\\软件工程\\测试用图\\2.jpg");
                g.drawImage(icon.getImage(), 0, 0, 800,80,jFrame);
            }
		};
		jPanel.setBounds(0,0,800,80);
		container.add(jPanel);
		
		jLabel = new JLabel("采购信息",JLabel.CENTER);
		jLabel.setFont(topicFont);
		jLabel.setBounds(0,0,800,80);
		jPanel.add(jLabel);
		
		
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
	
	public List<Buymodel> showMessage() {
		DataSource.initDatabase("model");
		Query query = new Query();		
		List<Buymodel> BuyModelList = query.get(Buymodel.class);
		return BuyModelList;
	}
}
