package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	private double rate;//拉伸比例
	private boolean stretch;//是否拉伸
	private JComponent jc;//面板要显示的一个组件
	/**
	 * Create the panel.
	 */
	public CenterPanel(double rate,boolean stretch) {
		this.rate=rate;
		this.stretch=stretch;
		this.setLayout(null);
	}

	public void show(JComponent p) {
		this.jc=p;
		Component[] cs =this.getComponents();
		for(Component c:cs)
			this.remove(c);
		this.add(p);
		this.updateUI();//会交由swing框架自动调用this.repaint
	}
	
	/**
	 * 实际上不是拉伸面板，而是拉伸面板上的组件
	 */
	public void repaint() {
		if(null!=jc) {
			Dimension containerSize=this.getSize();
			Dimension componentSize=jc.getPreferredSize();
			if(stretch) {
				jc.setSize((int)(containerSize.width*rate),(int)(containerSize.height*rate));
				//注意要重新获取尺寸，后面要设置中心位置
				componentSize=jc.getSize();
			}
			else
				jc.setSize(componentSize);
			
			jc.setLocation(containerSize.width / 2 - componentSize.width / 2, containerSize.height / 2 - componentSize.height / 2);
		}
		super.repaint();
	}
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setSize(400, 400);
		f.setLocationRelativeTo(null);//窗口在屏幕中心
		CenterPanel cp= new CenterPanel(0.9,true);
		//cp.setBackground(ColorUtil.blueColor);
		f.setContentPane(cp);//设置z内容面板属性
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置使用System exit方法退出exit程序。 仅在应用程序中使用。
		f.setVisible(true);//show f
		JButton c=new JButton("cccc");
		cp.add(c);
		cp.show(c);
		
	}
}
