package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import gui.model.CategoryComboBoxModel;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends JPanel {
	static {
		GUIUtil.useLNF();
	}
	public static RecordPanel instance=new RecordPanel();
	
	JLabel lSpend = new JLabel("����(��)");
    JLabel lCategory = new JLabel("����");
    JLabel lComment = new JLabel("��ע");
    JLabel lDate = new JLabel("����");
	
    public JTextField tSpend=new JTextField("0");
    public JTextField tComment=new JTextField("�뱸עһ��");
    //������ģ����gui.model
    public JComboBox<String> cbCategory=new JComboBox<String>(new CategoryComboBoxModel());
    //���ڿؼ�
    public JXDatePicker datepick=new JXDatePicker(new Date());
    
    public JButton bSubmit = new JButton("��һ��");
    
    public RecordPanel() {
    	this.setLayout(new BorderLayout());
    	this.add(center(),BorderLayout.CENTER);
    	JPanel p=new JPanel();
    	GUIUtil.setColor(ColorUtil.deepBlue, bSubmit);
    	p.add(bSubmit);
    	this.add(p,BorderLayout.SOUTH);
    }
    
    private JPanel center() {
    	JPanel p=new JPanel();
    	//����϶ ��80����70������5�� ���·�����
    	p.setLayout(new GridLayout(5, 2, 80, 70));
    	p.add(lSpend);
    	p.add(tSpend);
    	p.add(lCategory);
    	p.add(cbCategory);
    	p.add(lComment);
    	p.add(tComment);
    	p.add(lDate);
    	p.add(datepick);
    	
    	//�ϵ���ɫ
    	GUIUtil.setColor(ColorUtil.deepBlue, lSpend,lCategory,lComment,lDate);
    	
    	return p;
    }
    
    
	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);

	}

}
