package BasicObject;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/24.
 */
public class ClassObj extends BasicObject {
    private final int W = 80;
    private final int H = 120;

    public ClassObj(){
    }
    public ClassObj(int x,int y){
        super(x,y,80,120);
        System.out.println("ClassObj constr");
    }
    public void draw(Graphics g){
        System.out.println("BasicObject draw");
        g.setColor(Color.WHITE);
        g.fillRect( getX(), getY(), getWidth(), getHeight() );
        g.setColor(Color.BLACK);
        g.drawString( getObjName(), getX()+getWidth()/4+10, getY()+25);
        g.drawRect( getX(), getY(), getWidth(), getHeight() );
        g.drawLine( getX(), getY()+ H/3, getX()+getWidth(), getY() + H/3);
        g.drawLine( getX(), getY()+ H/3*2, getX()+getWidth(), getY() + H/3*2);
        super.draw(g);
    }
}
