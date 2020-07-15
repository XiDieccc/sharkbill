package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.panel.MainPanel;

public class GUIUtil {
	public static String imageFolder = "E:\\projects\\Java projects\\sharkbill\\img";
	//"E:\\2020ChenLiang\\eclipse_project\\sharkbill\\img";
	/**
	 * ��Button����ͼ�꣬�ı�����ʾ����
	 * @param b ��Button
	 * @param fileName ͼ����ļ���
	 * @param tip ��ʾ����
	 */
	public static void setImageIcon(JButton b, String fileName,String tip) {
		ImageIcon i=new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		int width=45,height=45;//ͼƬ�������õĿ�ȸ߶�
		i.setImage(i.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		
		b.setIcon(i);
		b.setPreferredSize(new Dimension(width,height+20));//�ı�Ҳ�и߶�, +20
		b.setToolTipText(tip);
		
		//���ı���ʾ��ͼ�����·�
		b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        //�����ı���ʽ
        Font f=new Font("����",Font.BOLD,12);//΢���źڣ����壬12
        b.setFont(f);
        //�����ı���ɫ������ɫ
        b.setForeground(ColorUtil.deepBlue);
        b.setText(tip);
	}
	
	/**
	 * ʹ��һ��ˮ��Ƥ������ʼƤ��̫tm����
	 */
	public static void useLNF() {
	    try {
	        javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	/**
	 * ���ܶ������ͬһ����ɫ��ǰ����ɫ
	 * ������Ҫ�Ǹ�HomePanel��JLable�ı���ɫ
	 * @param color
	 * @param jcs
	 */
	public static void setColor(Color color,JComponent... jcs) {
		for(JComponent jc:jcs)
			jc.setForeground(color);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ��ʱ��һ����ʾ���幦��
	 * @param p
	 */
	public static void showPanel(JPanel p) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);// ��������Ļ����
		//����һ������ͼ�꣬�������ô
		f.setIconImage(new ImageIcon(new File(imageFolder,"sharklogo.jpg").getAbsolutePath()).getImage());
		f.setTitle("Shark Bill");
		CenterPanel cp = new CenterPanel(0.9, true);//stretch=0.9
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	
	public static boolean checkEmpty(JTextField tf, String input) {
	    String text = tf.getText().trim();
	    if (0 == text.length()) {
	        JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
	        tf.grabFocus();
	        return false;
	    }
	    return true;
	 
	}
	
	public static boolean checkNumber(JTextField tf, String input) {
	    if (!checkEmpty(tf, input))
	        return false;
	    String text = tf.getText().trim();
	    try {
	        Integer.parseInt(text);
	        return true;
	    } catch (NumberFormatException e1) {
	        JOptionPane.showMessageDialog(null, input + " ��Ҫ������");
	        tf.grabFocus();
	        return false;
	    }
	}
	
	public static boolean checkZero(JTextField tf, String input) {
	    if (!checkNumber(tf, input))
	        return false;
	    String text = tf.getText().trim();
	 
	    if(0==Integer.parseInt(text)){
	        JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
	        tf.grabFocus();
	        return false;
	    }
	    return true;
	 
	}
}
