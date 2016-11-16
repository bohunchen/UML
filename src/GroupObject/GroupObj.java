package GroupObject;

import BasicObject.BasicObject;
import BasicObject.Shape;
import BasicObject.Port;
import UML_Editor.MyCanvas;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by NiHao on 2016/10/29.
 */
public class GroupObj extends BasicObject{

    private ArrayList<Shape> container;

    public GroupObj(){

        System.out.println("GroupObj constr");
        container = new ArrayList<Shape>();
    }

    public void objMove(int moveX,int moveY){
        setLocate(getX()+moveX, getY()+moveY);
        for ( Shape s : container ) {
            BasicObject obj = (BasicObject)s;
            obj.objMove(moveX,moveY);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor( Color.WHITE );
        g.drawRect( getX(),getY(),getWidth(),getHeight()) ;
        for ( Shape s : container ) {
            System.out.println(s);
            s.draw(g);
        }
    }

    public ArrayList<Shape> getContainer() {
        return container;
    }
    public void addShapeIntoList( Shape s ){
        container.add(s);
    }
    public void showPorts(boolean choose){
    }
    public void recomputeLocate(){
        int minX = 9999;
        int minY = 9999 ;
        for (Shape s : container) {
            minX = Math.min( minX, s.getX() );
            minY =  Math.min( minY, s.getY() );
        }
        setLocate( minX-10, minY-10 );
    }
    public void recomputeSize(){
        int maxX = -1;
        int maxY = -1 ;
        for (Shape s : container) {
            maxX = Math.max( maxX, s.getX() + s.getWidth() );
            maxY =  Math.max( maxY, s.getY() + s.getHeight() );
        }
        maxX += 10;
        maxY += 10;
        setSize( maxX- getX(), maxY-getY() );
    }
}
