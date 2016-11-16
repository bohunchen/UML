package Mode;

import java.awt.event.MouseEvent;

import BasicObject.ClassObj;
import BasicObject.Shape;
import UML_Editor.MyCanvas;

/**
 * Created by NiHao on 2016/10/24.
 */
public class ClassMode extends Mode{
    private Shape classObj;
    public ClassMode(){
        //System.out.println("ClassMode");
    }
    public void showMode(){
        System.out.println("ClassMode");
    }
    public void mouseClicked(MouseEvent e){
        System.out.println("ClassMode mouseClicked");
        classObj = new ClassObj( e.getX(), e.getY() );
        MyCanvas.getInstance().addShape(classObj);
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
}
