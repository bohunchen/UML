package UML_Editor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

import javax.swing.*;

import BasicObject.BasicObject;
import BasicObject.Shape;
import Btn.BtnPanel;
import GroupObject.GroupObj;
import Mode.SelectMode;


/**
 * Created by NiHao on 2016/10/24.
 */
public class Uml extends JFrame{
    public JPanel contentPane;
    private JMenuBar  umlMenuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuItem editChangeName;
    private JMenuItem editGroup;
    private JMenuItem editungroup;
    private BtnPanel toolPanel;


    public Uml(){
        initialize();
    }

    public void initialize(){
        setBounds(800, 600, 800, 600);
        setTitle("UML editor");

        setBounds(800, 600, 800, 600);
        setTitle("UML editor");


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        toolPanel = new BtnPanel();

        contentPane.add(toolPanel, BorderLayout.WEST);
        contentPane.add(MyCanvas.getInstance(), BorderLayout.CENTER);


        setContentPane(contentPane);
        createMunuBar();

    }

    public void createMunuBar(){
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        editChangeName = new JMenuItem("Change Object Name");
        editGroup = new JMenuItem("Group objects");
        editungroup = new JMenuItem("UnGroup objects");
        editMenu.add(editChangeName);
        editMenu.add(editGroup);
        editMenu.add(editungroup);
        umlMenuBar = new JMenuBar();
        umlMenuBar.add(fileMenu);
        umlMenuBar.add(editMenu);
        setJMenuBar(umlMenuBar);

        editGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point pressedPoint = MyCanvas.getInstance().getPressedPoint();
                Point releasedPoint = MyCanvas.getInstance().getReleasedPoint();
                Point locatePoint = pressedPoint;
                int w = Math.abs( pressedPoint.x - releasedPoint.x );
                int h = Math.abs( pressedPoint.y - releasedPoint.y );
                ArrayList<Shape> list; // = new ArrayList<Shape>();
                GroupObj groupObj = new GroupObj();

                if( pressedPoint.x >= releasedPoint.x && pressedPoint.y >= releasedPoint.y){
                    locatePoint = releasedPoint;
                }
                list = MyCanvas.getInstance().findGroupObj( locatePoint.x, locatePoint.y
                        , locatePoint.x+w, locatePoint.y+h);

                // groupObj.size() must be greater than 1
                if( list.size() > 1 ){
                    for (Shape s:list) {
                        s.showPorts(false);
                        groupObj.addShapeIntoList( s );
                        MyCanvas.getInstance().removeShape( s );
                    }
                    // groupObj : location, Size
                    groupObj.recomputeLocate();
                    groupObj.recomputeSize();
                    MyCanvas.getInstance().addShape( groupObj );
                    MyCanvas.getInstance().repaint();
                }
            }
        });
        editungroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point pressedPoint = MyCanvas.getInstance().getPressedPoint();
                int idx = MyCanvas.getInstance().findObj(pressedPoint.x,pressedPoint.y);
                Shape s = MyCanvas.getInstance().getShapeByIdx(idx);
                if( s instanceof GroupObj ){
                    System.out.println("UML editungroup");
                    GroupObj g = (GroupObj)s;
                    ArrayList<Shape> list = g.getContainer();
                    for (Shape tmp : list) {
                        MyCanvas.getInstance().addShape(tmp);
                    }
                    MyCanvas.getInstance().removeShape(g);
                    MyCanvas.getInstance().repaint();
                }
            }
        });
        editChangeName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( MyCanvas.getInstance().getCurrentMode() instanceof SelectMode ){
                    Point p = MyCanvas.getInstance().getPressedPoint();
                    int idx = MyCanvas.getInstance().findObj( p.x, p.y );
                    if( idx != -1 ){
                        Shape s = MyCanvas.getInstance().getShapeByIdx(idx);
                        if( s instanceof BasicObject ){
                            String input = JOptionPane.showInputDialog("Plz Input Obj Name");
                            if( input != null ){
                                s.setObjName( input );
                                MyCanvas.getInstance().repaint();
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Not Select BasicObj","error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

    }

}
