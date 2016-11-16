package Line;

import BasicObject.BasicObject;
import BasicObject.Shape;
import BasicObject.Port;
import UML_Editor.MyCanvas;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/25.
 */
public class LineObj extends Shape{
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    public BasicObject obj1;
    public BasicObject obj2;
    public Port frontPort;
    public Port endPort;

    public LineObj(){
        frontPort = endPort = null;
    }

    public void draw(Graphics g){
        double min = 999999999;
        double len;
        if( obj1 != null && obj2 != null ){
            for ( Port p : obj1.getPortArrayList() ) {
                for ( Port q : obj2.getPortArrayList() ){
                    len = Math.sqrt( (p.getX() - q.getX() ) * ( p.getX() - q.getX() )
                            + ( p.getY() - q.getY() )  * ( p.getY() - q.getY() )
                    );
                    if( len < min ){
                        min = len;
                        frontPort = p;
                        endPort = q;
                    }
                }
            }
            System.out.print( obj1 );
            System.out.println( frontPort.getX() + " " +frontPort.getY() + " "+frontPort.getPortNum() );
            System.out.print( obj2 );
            System.out.println( endPort.getX() + " " +endPort.getY() + " "+endPort.getPortNum() );
        }
    }

}
