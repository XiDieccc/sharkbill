package gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class HomePanel extends JPanel {
	static {
		GUIUtil.useLNF();
	}
	public static HomePanel instance = new HomePanel();

	public JLabel lMonthSpend = new JLabel("本月消费");
	public JLabel lTodaySpend = new JLabel("今日消费");
	public JLabel lAvgSpendPerDay = new JLabel("日均消费");
	public JLabel lMonthLeft = new JLabel("本月剩余");
	public JLabel lDayAvgAvailable = new JLabel("日均可用");
	public JLabel lMonthLeftDay = new JLabel("距离月末");

	public JLabel vMonthSpend = new JLabel("￥2300");
	public JLabel vTodaySpend = new JLabel("￥25");
	public JLabel vAvgSpendPerDay = new JLabel("￥120");
	public JLabel vMonthAvailable = new JLabel("￥2084");
	public JLabel vDayAvgAvailable = new JLabel("￥389");
	public JLabel vMonthLeftDay = new JLabel("15天");

	public CircleProgressBar bar = new CircleProgressBar();

	public HomePanel() {
		// 设置颜色
		bar.setForeground(ColorUtil.blueColor);
		//bar.setBackground(ColorUtil.blueColor);//这个是设置背景色，但是由于使用了皮肤，所以冲突了
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
		// 设置字体
		vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

		// 设置布局，添加组件
		this.setLayout(new BorderLayout());
		this.add(this.center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}

	/**
	 * 中间的整体布局！！！禁止套娃
	 * 
	 * @return
	 */
	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(this.west(), BorderLayout.WEST);
		p.add(this.bar, BorderLayout.CENTER);
		return p;
	}

	/**
	 * 面板底部的label,布局为 2行4列 的网格布局
	 * 
	 * @return
	 */
	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));

		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);

		return p;
	}

	/**
	 * JPanel是一个可以包含其他组件的容器，两者的不同之处在于JPanel默认的Opaque（中文意思：不透明的）属性为true，
	 * 而JComponent默认的Opaque属性为false。 当Opaque属性为true时，就意味着该面板不是透明的，需要在面板的边界内绘制所有的像素，
	 * 即不能包含有透明的内容视图。因此在扩展JPanel类绘制组件时，
	 * 可以在每个面板子类的paintComponent方法中调用super.paintComponent来用背景色绘制面板
	 */
	/**
	 * 左侧4行1列 网格布局
	 * 
	 * @return
	 */
	private JPanel west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);

		return p;
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(HomePanel.instance);
	}
}
