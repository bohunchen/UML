package Mode;

import BasicObject.UseClassObj;
import BasicObject.Shape;
import UML_Editor.MyCanvas;
import java.awt.event.MouseEvent;

/**
 * Created by NiHao on 2016/10/25.
 */
public class UseClassMode extends Mode{
    private Shape classObj;
    public UseClassMode(){
        //System.out.println("UseClassMode");
    }
    public void showMode(){
        System.out.println("UseClassMode");
    }
    public void mouseClicked(MouseEvent e){
        System.out.println("UseClassMode mouseClicked");
        classObj = new UseClassObj( e.getX(), e.getY() );
        MyCanvas.getInstance().addShape(classObj);
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
}
