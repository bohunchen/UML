package Container;

import java.awt.*;

/**
 * Created by NiHao on 2016/10/29.
 */
public abstract class Container {

    private String objName;

    public abstract void draw(Graphics g);

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

}
