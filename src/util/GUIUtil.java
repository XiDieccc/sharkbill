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
	 * 给Button设置图标，文本，提示文字
	 * @param b 该Button
	 * @param fileName 图标的文件名
	 * @param tip 提示文字
	 */
	public static void setImageIcon(JButton b, String fileName,String tip) {
		ImageIcon i=new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		int width=45,height=45;//图片缩放设置的宽度高度
		i.setImage(i.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		
		b.setIcon(i);
		b.setPreferredSize(new Dimension(width,height+20));//文本也有高度, +20
		b.setToolTipText(tip);
		
		//让文本显示在图标正下方
		b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        //设置文本样式
        Font f=new Font("宋体",Font.BOLD,12);//微软雅黑，粗体，12
        b.setFont(f);
        //设置文本颜色，深蓝色
        b.setForeground(ColorUtil.deepBlue);
        b.setText(tip);
	}
	
	/**
	 * 使用一套水晶皮肤，初始皮肤太tm丑了
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
	 * 给很多组件上同一种颜色，前景颜色
	 * 这里主要是给HomePanel的JLable文本上色
	 * @param color
	 * @param jcs
	 */
	public static void setColor(Color color,JComponent... jcs) {
		for(JComponent jc:jcs)
			jc.setForeground(color);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 临时的一个显示矿体功能
	 * @param p
	 */
	public static void showPanel(JPanel p) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);// 窗口在屏幕中心
		//设置一个框体图标，鲨鱼记账么
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
	        JOptionPane.showMessageDialog(null, input + " 不能为空");
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
	        JOptionPane.showMessageDialog(null, input + " 需要是整数");
	        tf.grabFocus();
	        return false;
	    }
	}
	
	public static boolean checkZero(JTextField tf, String input) {
	    if (!checkNumber(tf, input))
	        return false;
	    String text = tf.getText().trim();
	 
	    if(0==Integer.parseInt(text)){
	        JOptionPane.showMessageDialog(null, input + " 不能为零");
	        tf.grabFocus();
	        return false;
	    }
	    return true;
	 
	}
}
