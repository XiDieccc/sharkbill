package util;

import java.awt.Color;

public class ColorUtil {
	public static Color goldColor=new Color(237,194,51);//��ɫ92 ��ɫ����#EDC233
	public static Color deepBlue=Color.decode("#3045DE");//��ɫ90��ɫ����#3045DE
	
	//HomePanel��Բ��
	public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");
    
	/*
	 * ��ɫ�Ĺ�ʽ��:255 * rate + 51*(1 - rate) 
	 * ��ɫ�Ĺ�ʽ��:255 * (1 - rate) + 51 * rate
	 * rateԽ��,��ɫԽ��,��ɫԽ�� rateԽС,��ɫԽС,��ɫԽ��
	 */
    public static Color getByPercentage(int per) {
        if (per > 100)
            per = 100;
        int r = 51;
        int g = 255;
        int b = 51;
        float rate = per / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;
    }
}
