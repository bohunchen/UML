package Btn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Mode.*;
import UML_Editor.MyCanvas;

/**
 * Created by NiHao on 2016/10/25.
 */
public class BtnPanel extends JPanel{

    private ArrayList<Btn> btnArrayList;
    private String[] btnNameList = {"selectBtn","associateLineBtn","genLineBtn",
            "compositionBtn","classBtn","useClassBtn"};
    private String[] iconList = {"/BtnPics/select.png","/BtnPics/association.png","/BtnPics/generalization.png",
            "/BtnPics/composition.png","/BtnPics/class.png","/BtnPics/useclass.png"};
    private int lastBtnIdx;

    public BtnPanel(){
        btnArrayList = new ArrayList<Btn>();
        setLayout(new GridBagLayout());
        setBackground(Color.pink);
        createBtns();
        addBtnIntoPanel();
        addModeIntoBtns();
        addBtnsListener();
        lastBtnIdx = 0;
    }
    public void createBtns(){
        System.out.println("BtnPanel createBtns");
        for (int i = 0; i < 6; i++) {
            Btn btn = new Btn();
            btn.setName( btnNameList[i] );
            ImageIcon img = new ImageIcon("src" + iconList[i]);
            btn.setIcon( img );
            btnArrayList.add(btn);
        }
    }
    public void addBtnIntoPanel(){
        System.out.println("BtnPanel addBtnIntoPanel");
        for (int i = 0; i < btnNameList.length ; i++) {
            GridBagConstraints gridBag = new GridBagConstraints();
            gridBag.gridx = 0;
            gridBag.gridy = i*2;
            gridBag.gridwidth = 2;
            gridBag.gridheight = 2;
            gridBag.fill = GridBagConstraints.BOTH;
            gridBag.anchor = GridBagConstraints.CENTER;
            add( btnArrayList.get(i), gridBag);
        }
    }
    public void addModeIntoBtns(){
        btnArrayList.get(0).setMode( new SelectMode()
        );
        btnArrayList.get(1).setMode( new AssoMode() );
        btnArrayList.get(2).setMode( new GenMode() );
        btnArrayList.get(3).setMode( new ComMode() );
        btnArrayList.get(4).setMode( new ClassMode() );
        btnArrayList.get(5).setMode( new UseClassMode() );
    }
    public void addBtnsListener(){
        for (Btn b: btnArrayList ) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    b.getMode().showMode();
                    MyCanvas.getInstance().setCurrentMode( b.getMode() );
                    /* mode switch */
                    btnArrayList.get( lastBtnIdx ).setIcon( new ImageIcon("src" + iconList[lastBtnIdx]));
                    b.setIcon( new ImageIcon("src/BtnPics/black.png") ) ;
                    lastBtnIdx = btnArrayList.indexOf( b );
                }
            });
        }
    }
}
