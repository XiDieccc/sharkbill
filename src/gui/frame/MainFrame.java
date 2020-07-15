package gui.frame;
 
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import gui.panel.MainPanel;
import util.GUIUtil;
 
public class MainFrame extends JFrame{
    public static MainFrame instance = new MainFrame();
     
    private MainFrame(){
        this.setSize(600, 600);
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);// ��������Ļ����
		//����һ������ͼ�꣬�������ô
		this.setIconImage(new ImageIcon(new File(GUIUtil.imageFolder,"sharklogo.jpg").getAbsolutePath()).getImage());
		this.setTitle("Shark Bill");
		//���ɸı��С
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
     
    public static void main(String[] args) {
        instance.setVisible(true);
    }
     
}