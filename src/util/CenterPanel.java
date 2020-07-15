package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	private double rate;//�������
	private boolean stretch;//�Ƿ�����
	private JComponent jc;//���Ҫ��ʾ��һ�����
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
		this.updateUI();//�ύ��swing����Զ�����this.repaint
	}
	
	/**
	 * ʵ���ϲ���������壬������������ϵ����
	 */
	public void repaint() {
		if(null!=jc) {
			Dimension containerSize=this.getSize();
			Dimension componentSize=jc.getPreferredSize();
			if(stretch) {
				jc.setSize((int)(containerSize.width*rate),(int)(containerSize.height*rate));
				//ע��Ҫ���»�ȡ�ߴ磬����Ҫ��������λ��
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
		f.setLocationRelativeTo(null);//��������Ļ����
		CenterPanel cp= new CenterPanel(0.9,true);
		//cp.setBackground(ColorUtil.blueColor);
		f.setContentPane(cp);//����z�����������
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����ʹ��System exit�����˳�exit���� ����Ӧ�ó�����ʹ�á�
		f.setVisible(true);//show f
		JButton c=new JButton("cccc");
		cp.add(c);
		cp.show(c);
		
	}
}
