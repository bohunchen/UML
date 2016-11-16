package BasicObject;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/25.
 */
public class UseClassObj extends BasicObject{
    public UseClassObj(){
    }
    public UseClassObj(int x,int y){
        super(x,y,120,80);
        System.out.println("UseClassObj constr");
    }
    public void draw(Graphics g){
        System.out.println("UseClassObj draw");
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawOval( getX(), getY(), getWidth(), getHeight() );
        g.drawString(getObjName(), getX()+ getWidth()/2-getObjName().length()*3, getY()+getHeight()/2 + 3 );
        super.draw(g);
    }
}
