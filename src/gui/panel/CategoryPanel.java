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
	
	public JButton bAdd=new JButton("����");
	public JButton bEdit = new JButton("�༭");
    public JButton bDelete = new JButton("ɾ��");
    
    public JTable t=new JTable(new CategoryTableModel());
	
    public CategoryPanel() {
		GUIUtil.setColor(ColorUtil.deepBlue, bAdd,bEdit,bDelete);
		t.setForeground(ColorUtil.deepBlue);
		//����ѡ�еı���ɫ
		t.setSelectionBackground(ColorUtil.goldColor);
		//���ñ�ͷ
		t.getTableHeader().setForeground(ColorUtil.deepBlue);//������ɫ
		t.getTableHeader().setReorderingAllowed(false);//�����϶�
		t.getTableHeader().setResizingAllowed(false);//��ͷ��������
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
