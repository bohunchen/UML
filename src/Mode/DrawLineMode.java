package Mode;

import BasicObject.BasicObject;
import Line.LineObj;
import UML_Editor.MyCanvas;
import BasicObject.Port;
import BasicObject.Shape;
import java.awt.event.MouseEvent;

/**
 * Created by NiHao on 2016/10/25.
 */
public class DrawLineMode extends Mode{
    private Shape frontObj;
    private Shape endObj;
    protected LineObj lineObj;

    @Override
    public void showMode() {
        System.out.println("DrawLineMode");
    }
    public void mouseClicked(MouseEvent e){
    }
    /* find the frontObjIdx locating in ( e.X, e.Y)
    * If    find ,lineObj.setFrontPort and lineObj.setEndPort
    * Else  add the lineObj into shapList
    * */
    public void mousePressed(MouseEvent e){
        System.out.println("DrawLineMode mousePressed");
        System.out.println("(X,Y) "+e.getX()+" "+e.getY() );
        int frontObjIdx = MyCanvas.getInstance().findObj(e.getX(),e.getY());
        if( frontObjIdx != -1 ){
            System.out.println("Idx "+ frontObjIdx );
            frontObj = MyCanvas.getInstance().getShapeByIdx(frontObjIdx);
            frontObj.showPorts(true);
            Port p  = frontObj.findPort(e.getX(),e.getY());
            if( p != null ){
                lineObj.obj1 = (BasicObject) frontObj ;
                /*lineObj.setFrontPort( p );
                lineObj.setEndPort(p);
                p.setConnected( true );*/
            }
        }
        MyCanvas.getInstance().addShape(lineObj);
    }
    /* find the endObjIdx locating in ( e.X, e.Y)
    * If    find ,setEndPort
    * Else  del the last lineObj produced by mousePressed function
    * */
    public void mouseReleased(MouseEvent e){
        System.out.println("DrawLineMode mouseReleased");
        System.out.println("(X,Y) "+e.getX()+" "+e.getY() );
        int endObjIdx = MyCanvas.getInstance().findObj(e.getX(),e.getY());
        if( endObjIdx != -1 ){
            System.out.println("Idx "+ endObjIdx );
            endObj = MyCanvas.getInstance().getShapeByIdx(endObjIdx);
            endObj.showPorts(true);
            Port p  = endObj.findPort(e.getX(),e.getY());
            if( p != null){
                lineObj.obj2 = (BasicObject) endObj ;
                /*lineObj.setEndPort( p );
                p.setConnected( true );*/
            }
        }
        else {
            MyCanvas.getInstance().delLastShape();
        }
    }
    public void mouseDragged(MouseEvent e){

    }
}
