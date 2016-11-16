package Line;

import BasicObject.Port;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/27.
 */
public class ComLine extends LineObj{
    public void draw(Graphics g){
        /*if( getFrontPort()!=null && getEndPort() != null ){
            System.out.println("ComLine draw");
            g.setColor(Color.BLACK);
            x1 = getFrontPort().getX();
            y1 = getFrontPort().getY();
            x2 = getEndPort().getX();
            y2 = getEndPort().getY();

            Point p , p1, p2;
            p = getLineEndLocate(x1,y1,getFrontPort().getPortNum() );
            p1 = getTriPoint1(x1,y1,getFrontPort().getPortNum() );
            p2 = getTriPoint2(x1,y1,getFrontPort().getPortNum() );
            g.drawLine(x2, y2, (int)p.getX(), (int)p.getY());
            // Fong part
            g.drawLine((int)p1.getX(), (int)p1.getY(), x1, y1);
            g.drawLine((int)p2.getX(), (int)p2.getY(), x1, y1);
            g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p.getX(), (int)p.getY() );
            g.drawLine((int)p2.getX(), (int)p2.getY(),(int)p.getX(), (int)p.getY() );
        }*/
        super.draw(g);
        if( frontPort != null && endPort != null ){
            System.out.println("ComLine draw");
            g.setColor(Color.BLACK);
            Point p, p1, p2;
            p = getLineEndLocate( frontPort.getX(), frontPort.getY(), frontPort.getPortNum() );
            p1 = getTriPoint1( frontPort.getX(), frontPort.getY(), frontPort.getPortNum() );
            p2 = getTriPoint2( frontPort.getX(), frontPort.getY(), frontPort.getPortNum() );
            g.drawLine( endPort.getX(), endPort.getY(), (int)p.getX(), (int)p.getY());

            g.drawLine( p1.x, p1.y, frontPort.getX(), frontPort.getY());
            g.drawLine( p2.x, p2.y, frontPort.getX(), frontPort.getY());
            g.drawLine( p1.x, p1.y, p.x, p.y );
            g.drawLine( p2.x, p2.y, p.x, p.y );
        }
    }
    public Point getLineEndLocate(int x, int y, int portNum){
        int[] dir_x = { 0, 32, 0, -32};
        int[] dir_y = { -32, 0, 32, 0};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }
    public Point getTriPoint1(int x, int y, int portNum){
        int[] dir_x = { -8, 16, -8, -16};
        int[] dir_y = { -16, -8, 16, -8};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }
    public Point getTriPoint2(int x, int y, int portNum){
        int[] dir_x = { 8, 16, 8, -16};
        int[] dir_y = { -16, 8, 20, 8};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }
}
