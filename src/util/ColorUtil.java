package util;

import java.awt.Color;

public class ColorUtil {
	public static Color goldColor=new Color(237,194,51);//金色92 颜色编码#EDC233
	public static Color deepBlue=Color.decode("#3045DE");//蓝色90颜色编码#3045DE
	
	//HomePanel的圆形
	public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");
    
	/*
	 * 红色的公式是:255 * rate + 51*(1 - rate) 
	 * 绿色的公式是:255 * (1 - rate) + 51 * rate
	 * rate越大,红色越多,绿色越少 rate越小,红色越小,绿色越多
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
