package gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.model.CategoryTableModel;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends JPanel{
	static {
		GUIUtil.useLNF();
	}
	
	public static CategoryPanel instance=new CategoryPanel();
	
	public JButton bAdd=new JButton("新增");
	public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    
    public JTable t=new JTable(new CategoryTableModel());
	
    public CategoryPanel() {
		GUIUtil.setColor(ColorUtil.deepBlue, bAdd,bEdit,bDelete);
		t.setForeground(ColorUtil.deepBlue);
		//设置选中的背景色
		t.setSelectionBackground(ColorUtil.goldColor);
		//设置表头
		t.getTableHeader().setForeground(ColorUtil.deepBlue);//字体颜色
		t.getTableHeader().setReorderingAllowed(false);//不可拖动
		t.getTableHeader().setResizingAllowed(false);//表头不可缩放
		JScrollPane sp=new JScrollPane(t);
		JPanel south=new JPanel();
		south.add(bAdd);
		south.add(bEdit);
		south.add(bDelete);
		
		this.setLayout(new BorderLayout());
		this.add(south,BorderLayout.SOUTH);
		this.add(sp,BorderLayout.CENTER);
	}
    
	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);

	}

}
