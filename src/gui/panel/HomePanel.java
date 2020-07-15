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

	public JLabel lMonthSpend = new JLabel("��������");
	public JLabel lTodaySpend = new JLabel("��������");
	public JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	public JLabel lMonthLeft = new JLabel("����ʣ��");
	public JLabel lDayAvgAvailable = new JLabel("�վ�����");
	public JLabel lMonthLeftDay = new JLabel("������ĩ");

	public JLabel vMonthSpend = new JLabel("��2300");
	public JLabel vTodaySpend = new JLabel("��25");
	public JLabel vAvgSpendPerDay = new JLabel("��120");
	public JLabel vMonthAvailable = new JLabel("��2084");
	public JLabel vDayAvgAvailable = new JLabel("��389");
	public JLabel vMonthLeftDay = new JLabel("15��");

	public CircleProgressBar bar = new CircleProgressBar();

	public HomePanel() {
		// ������ɫ
		bar.setForeground(ColorUtil.blueColor);
		//bar.setBackground(ColorUtil.blueColor);//��������ñ���ɫ����������ʹ����Ƥ�������Գ�ͻ��
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
		// ��������
		vMonthSpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("΢���ź�", Font.BOLD, 23));

		// ���ò��֣�������
		this.setLayout(new BorderLayout());
		this.add(this.center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}

	/**
	 * �м�����岼�֣�������ֹ����
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
	 * ���ײ���label,����Ϊ 2��4�� �����񲼾�
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
	 * JPanel��һ�����԰���������������������ߵĲ�֮ͬ������JPanelĬ�ϵ�Opaque��������˼����͸���ģ�����Ϊtrue��
	 * ��JComponentĬ�ϵ�Opaque����Ϊfalse�� ��Opaque����Ϊtrueʱ������ζ�Ÿ���岻��͸���ģ���Ҫ�����ı߽��ڻ������е����أ�
	 * �����ܰ�����͸����������ͼ���������չJPanel��������ʱ��
	 * ������ÿ����������paintComponent�����е���super.paintComponent���ñ���ɫ�������
	 */
	/**
	 * ���4��1�� ���񲼾�
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
