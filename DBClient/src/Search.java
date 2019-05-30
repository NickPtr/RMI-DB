/*Nikos Potaris
  icsd15173*/

import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Search extends JFrame {

    //arxikopoihsi twn metablitwn "look_op" kai "repeats" kai ekxorisei timwn se autes meso tou constructor
    Interface look_op;
    int repeats;
    public Search(Interface look_op, Integer repeats) {
        this.look_op=look_op;
        this.repeats=repeats;
        Graphics();//emfanisi twn grafikwn
    }
    //sunartisi gia ta grafika      
    private void Graphics() {

        jLabel1 = new JLabel();
        TitleSearch = new JTextField();
        SearchTitle = new JToggleButton();
        jLabel2 = new JLabel();
        SingerSearch = new JTextField();
        SearchSinger = new JToggleButton();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Search a Song ");

        SearchTitle.setText("Search");
        SearchTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchTitleActionPerformed(evt);
            }
        });

        jLabel2.setText("Search by Title");

        SearchSinger.setText("Search");
        SearchSinger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchSingerActionPerformed(evt);
            }
        });

        jLabel3.setText("Search by Singer");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitleSearch)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchTitle, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(SingerSearch)
                            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(SearchSinger, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(SearchTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TitleSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(SearchSinger))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SingerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }
    
    //sunartisi gia to klisimo tis trexon selidas kata tin metafora stin epomeni
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    //Search me basi ton titlo tou tragoudiou kai metafora stin epomeni selida gia emfanisi
    private void SearchTitleActionPerformed(ActionEvent evt) {                                            
        close();
        //pername sto Result ektos tou "look_op" kai tou "repeats", tin epilogi tou xristi kathos kai ena flag
        //pou upodilonei ton tupo tis anazitisis
        new Result(look_op, TitleSearch.getText(),"title",repeats).setVisible(true); 
    }                                           

    //Search me basi to onoma tou kalitexni kai metafora stin epomeni selida gia emfanisi
    private void SearchSingerActionPerformed(ActionEvent evt) {                                             
        close();
        new Result(look_op, SingerSearch.getText(),"singer",repeats).setVisible(true);
    }                                            

                 
    private JToggleButton SearchSinger;
    private JToggleButton SearchTitle;
    private JTextField SingerSearch;
    private JTextField TitleSearch;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;                
}
