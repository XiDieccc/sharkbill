package test;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SimpleTset {
			
	public static void main(String[] args) {
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		CircleProgressBar bar=new CircleProgressBar();
		//bar.setBackground(ColorUtil.blueColor);
		p.add(bar,BorderLayout.CENTER);
		GUIUtil.showPanel(p);
	}

}
