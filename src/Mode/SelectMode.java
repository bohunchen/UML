package Mode;

import BasicObject.Port;
import BasicObject.SelectBox;
import Line.ComLine;
import UML_Editor.MyCanvas;
import BasicObject.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by NiHao on 2016/10/27.
 */
public class SelectMode extends Mode{
    private boolean gotObj;
    private Shape preesedObj;
    private Point lastP;

    @Override
    public void showMode() {
        System.out.println("SelectMode");
        gotObj = false;
        preesedObj = null;
        //lastP = new Point();
    }
    public void mouseClicked(MouseEvent e){
        int idx  = MyCanvas.getInstance().findObj(e.getX(),e.getY());
        if( idx != -1 ){
            MyCanvas.getInstance().getShapeByIdx(idx).showPorts(true);
        }else {
            cleanAllPorts();
        }
    }
    public void mousePressed(MouseEvent e){
        preesedObj = null;
        cleanAllPorts();
        MyCanvas.getInstance().setPressedPoint( new Point(e.getX(),e.getY()) );
        int idx  = MyCanvas.getInstance().findObj(e.getX(),e.getY());
        if( idx != -1 ){
            preesedObj = MyCanvas.getInstance().getShapeByIdx(idx);
            lastP = new Point( e.getX(), e.getY() );
        }
        else {
            //cleanAllPorts();
            SelectBox sBox = new SelectBox();
            sBox.setLocate(e.getX(),e.getY());
            MyCanvas.getInstance().addShape( sBox );
        }
    }
    public void mouseReleased(MouseEvent e){
        MyCanvas.getInstance().setReleasedPoint(new Point( e.getX(),e.getY()));
        int idx  = MyCanvas.getInstance().findObj( MyCanvas.getInstance().getPressedPoint().x,
                MyCanvas.getInstance().getPressedPoint().y);
        if( preesedObj == null ){
            ArrayList<Shape> list;
            Shape sBox = MyCanvas.getInstance().getLastShape();
            MyCanvas.getInstance().delLastShape();
            Point p = MyCanvas.getInstance().getPressedPoint();

            /* select box part */
            sBox.setLocate( (int)p.getX(), (int)p.getY());
            if( sBox.getX() <= e.getX() && sBox.getY() <= e.getY()){
                list = MyCanvas.getInstance().findGroupObj( sBox.getX(),sBox.getY(),e.getX(),e.getY());
            }
            else {
                list = MyCanvas.getInstance().findGroupObj( e.getX(),e.getY(),sBox.getX(),sBox.getY() );
            }

            for ( Shape s : list ) {
                s.showPorts(true);
            }
        }
        preesedObj = null;

    }
    public void mouseDragged(MouseEvent e){
        if( preesedObj != null ){
            int difX;
            int difY;
            difX = e.getX() - lastP.x;
            difY = e.getY() - lastP.y;
            lastP.x = lastP.x + difX;
            lastP.y = lastP.y + difY;
            preesedObj.objMove(difX,difY);
        }
        else {
            Shape sBox = MyCanvas.getInstance().getLastShape();
            Point p = MyCanvas.getInstance().getPressedPoint();
            int x = (int) p.getX();
            int y = (int) p.getY() ;
            sBox.setSize( Math.abs(x-e.getX()), Math.abs(y-e.getY()));
            if( sBox.getX() > e.getX() && sBox.getY() > e.getY()) {
                sBox.setLocate( e.getX(), e.getY() );
            }
        }
    }
    public void cleanAllPorts(){
        for (int i = 0; i < MyCanvas.getInstance().getShapeListSize() ; i++) {
            MyCanvas.getInstance().getShapeByIdx(i).showPorts(false);
        }
    }
}
