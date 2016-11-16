package BasicObject;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/29.
 */
public class SelectBox extends Shape{

    @Override
    public void draw(Graphics g) {
        //System.out.print( getX()+" "+ getY()+" "+ getWidth()+" "+ getHeight() +"\n");
       // g.drawRect( getX(), getY(), getWidth(), getHeight() );
        drawDotedBox( g, getX(), getY(), getWidth(), getHeight() );
    }

    public void drawDotedBox( Graphics g, int x, int y, int w, int h){
        Point[] points = new Point[4];
        int[] dir_x = { 0, 1, 1, 0 };
        int[] dir_y = { 0, 0, 1, 1 };
        for ( int i = 0 ; i< points.length; i++ ) {
            points[i] = new Point();
            points[i].x = x + dir_x[i] * w ;
            points[i].y = y + dir_y[i] * h ;
        }
        //g.drawRect( points[0].x, points[0].y, points[2].x-points[0].x, points[2].y-points[0].y );
        for (int i = 0; i < points.length ; i++) {
            if( i != points.length -1 ){
                drawDotedLine( g, points[i],points[i+1], 30-1 );
            }
            else{
                drawDotedLine( g, points[i],points[0], 30-1 );
            }
        }
    }

    public void drawDotedLine( Graphics g, Point p1, Point p2, int intervalNum){
        Point interval = new Point();
        interval.setLocation( (p2.x - p1.x)/intervalNum, (p2.y - p1.y)/intervalNum);
        for (int i = 0; i < intervalNum; i++) {
            if( i % 2 == 0 ){
                g.drawLine( p1.x + interval.x*i, p1.y + interval.y*i, p1.x + interval.x*(i+1), p1.y + interval.y*(i+1) );
            }
        }
    }

}
