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
	
	JLabel lSpend = new JLabel("花费(￥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");
	
    public JTextField tSpend=new JTextField("0");
    public JTextField tComment=new JTextField("请备注一哈");
    //下拉框，模型在gui.model
    public JComboBox<String> cbCategory=new JComboBox<String>(new CategoryComboBoxModel());
    //日期控件
    public JXDatePicker datepick=new JXDatePicker(new Date());
    
    public JButton bSubmit = new JButton("记一笔");
    
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
    	//表格间隙 宽80，高70，设置5行 让下方留白
    	p.setLayout(new GridLayout(5, 2, 80, 70));
    	p.add(lSpend);
    	p.add(tSpend);
    	p.add(lCategory);
    	p.add(cbCategory);
    	p.add(lComment);
    	p.add(tComment);
    	p.add(lDate);
    	p.add(datepick);
    	
    	//上点颜色
    	GUIUtil.setColor(ColorUtil.deepBlue, lSpend,lCategory,lComment,lDate);
    	
    	return p;
    }
    
    
	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);

	}

}
