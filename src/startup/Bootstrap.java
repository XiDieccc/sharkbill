package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.HomePanel;
import gui.panel.MainPanel;
import util.GUIUtil;

/**
 * �������
 * @author ��̱
 *
 */
public class Bootstrap {

	public static void main(String[] args) {
		GUIUtil.useLNF();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(HomePanel.instance);		
			}
		});

	}

}
