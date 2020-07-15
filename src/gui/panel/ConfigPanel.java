package gui.panel;
 
import java.awt.BorderLayout;
import java.awt.GridLayout;
 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import util.ColorUtil;
import util.GUIUtil;
 
public class ConfigPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();
 
    JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField("0");
     
    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");
 
    JButton bSubmit = new JButton("更新");
 
    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.deepBlue, lBudget,lMysql);
        GUIUtil.setColor(ColorUtil.deepBlue, bSubmit);
         
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        pInput.setLayout(new GridLayout(5,1,0,40));
        
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        
        pSubmit.add(bSubmit);
        this.add(pSubmit,BorderLayout.CENTER);
         
        addListener();
    }
 
    public void addListener() {
        ConfigListener l =new ConfigListener();
        bSubmit.addActionListener(l);
    }
    
    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
     
}