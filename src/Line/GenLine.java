package Line;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/27.
 */
public class GenLine extends LineObj{

    public void draw(Graphics g){
        /*if( getFrontPort()!=null && getEndPort() != null ){
            System.out.println("GenLine draw");
            g.setColor(Color.BLACK);
            Point lineP1, lineP2,triP1,triP2,triP3;

            lineP1 = new Point( getEndPort().getX(), getEndPort().getY() );
            triP3 = getConnectPoint( getFrontPort().getX(), getFrontPort().getY() , getFrontPort().getPortNum() );
            lineP2 = getLineEndLocate( triP3.x, triP3.y , getFrontPort().getPortNum() );
            triP1 = getTriPoint1( triP3.x, triP3.y , getFrontPort().getPortNum() );
            triP2 = getTriPoint2( triP3.x, triP3.y , getFrontPort().getPortNum() );
            g.drawLine( lineP1.x, lineP1.y, lineP2.x, lineP2.y );
            g.drawLine( triP1.x, triP1.y, triP2.x, triP2.y );
            g.drawLine( triP1.x, triP1.y, triP3.x, triP3.y );
            g.drawLine( triP2.x, triP2.y, triP3.x, triP3.y );
        }*/
        super.draw(g);
        if( frontPort != null && endPort != null ){
            System.out.println("GenLine draw");
            g.setColor(Color.BLACK);

            Point lineEndP,triP1,triP2,triP3;
            triP3 = getConnectPoint( frontPort.getX(), frontPort.getY() , frontPort.getPortNum() );
            lineEndP = getLineEndLocate( triP3.x, triP3.y , frontPort.getPortNum() );
            triP1 = getTriPoint1( triP3.x, triP3.y , frontPort.getPortNum() );
            triP2 = getTriPoint2( triP3.x, triP3.y , frontPort.getPortNum() );

            g.drawLine( endPort.getX(), endPort.getY(), lineEndP.x, lineEndP.y );
            g.drawLine( triP1.x, triP1.y, triP2.x, triP2.y );
            g.drawLine( triP1.x, triP1.y, triP3.x, triP3.y );
            g.drawLine( triP2.x, triP2.y, triP3.x, triP3.y );
        }
    }

    public Point getConnectPoint(int x, int y, int portNum){
        int[] dir_x = { 0, 6, 0, -6};
        int[] dir_y = { -6, 0, 6, 0};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }

    public Point getLineEndLocate(int x, int y, int portNum){
        int[] dir_x = { 0, 20, 0, -20};
        int[] dir_y = { -20, 0, 20, 0};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }

    public Point getTriPoint1(int x, int y, int portNum){
        int[] dir_x = { -8, 20, -8, -20};
        int[] dir_y = { -20, -8, 20, -8};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }
    public Point getTriPoint2(int x, int y, int portNum){
        int[] dir_x = { 8, 20, 8, -20};
        int[] dir_y = { -20, 8, 20, 8};
        Point p = new Point( x + dir_x[portNum], y + dir_y[portNum] );
        return p;
    }
}
