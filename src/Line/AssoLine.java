package Line;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/25.
 */
public class AssoLine extends LineObj{
    public void draw(Graphics g){
        /*if( getFrontPort()!=null && getEndPort() != null ){
            g.setColor(Color.BLACK);
            g.drawLine( getFrontPort().getX(),getFrontPort().getY(),getEndPort().getX(),getEndPort().getY());
        }*/
        super.draw(g);
        if( frontPort != null && endPort != null ){
            System.out.println("AssoLine draw");
            g.setColor(Color.BLACK);
            g.drawLine( frontPort.getX(), frontPort.getY(), endPort.getX(), endPort.getY() );
        }
    }
}
