package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.HomePanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import gui.panel.ReportPanel;

public class ToolBarListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton b=(JButton)e.getSource();
		if(b==MainPanel.instance.bBackup)
			MainPanel.instance.workingPanel.show(BackupPanel.instance);
		if(b==MainPanel.instance.bCategory)
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
		if(b==MainPanel.instance.bConfig)
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
		if(b==MainPanel.instance.bRecord)
			MainPanel.instance.workingPanel.show(RecordPanel.instance);
		if(b==MainPanel.instance.bRecover)
			MainPanel.instance.workingPanel.show(RecoverPanel.instance);
		if(b==MainPanel.instance.bReport)
			MainPanel.instance.workingPanel.show(ReportPanel.instance);
		if(b==MainPanel.instance.bSpend)
			MainPanel.instance.workingPanel.show(HomePanel.instance);
	}
	
}
