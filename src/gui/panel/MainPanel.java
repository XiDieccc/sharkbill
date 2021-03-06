package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel {

	static {
		GUIUtil.useLNF();
	}
	public static MainPanel instance = new MainPanel();
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();

	public CenterPanel workingPanel;

	private MainPanel() {
		GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
		GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
		GUIUtil.setImageIcon(bCategory, "category.png", "消费分类");
		GUIUtil.setImageIcon(bReport, "report.png", "月消费表");
		GUIUtil.setImageIcon(bConfig, "config.png", "设置");
		GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
		GUIUtil.setImageIcon(bRecover, "recover.png", "恢复");

		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);

		tb.setFloatable(false);// 用户不可拖动工具栏
		workingPanel = new CenterPanel(0.85, true);
		this.setLayout(new BorderLayout());
		this.add(tb, BorderLayout.NORTH);
		this.add(workingPanel, BorderLayout.CENTER);	
		
		addListener();
	}

	//对工具栏添加事件监听，来实现切换面板
	private void addListener() {
		ToolBarListener listener=new ToolBarListener();
		
		bSpend.addActionListener(listener);
		bRecord.addActionListener(listener);
		bCategory.addActionListener(listener);
		bReport.addActionListener(listener);
		bConfig.addActionListener(listener);
		bBackup.addActionListener(listener);
		bRecover.addActionListener(listener);
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance);
	}

}
