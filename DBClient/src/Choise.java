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
public class Choise extends JFrame {

    //arxikopoihsi twn metablitwn "look_op" kai "repeats" kai ekxorisei timwn se autes meso tou constructor
    Interface look_op;
    int repeats;
    public Choise(Interface look_op,Integer repeats) {
        this.look_op=look_op;
        this.repeats=repeats;
        Graphics();//emfanisi twn grafikwn
    }
                     
    //sunartisi gia ta grafika
    private void Graphics() {

        jLabel1 = new JLabel();
        CheckInsert = new JCheckBox();
        CheckSearch = new JCheckBox();
        CheckEvaluate = new JCheckBox();
        CheckAverage = new JCheckBox();
        Submit = new JToggleButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("MyMusic");

        CheckInsert.setText("Insert Music");

        CheckSearch.setText("Search Music");

        CheckEvaluate.setText("Evaluate Music");
        
        CheckAverage.setText("Print Average");

        Submit.setText("Submit");
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheckInsert)
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(Submit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                        .addComponent(CheckEvaluate)
                        .addGap(177, 177, 177)
                        .addComponent(CheckAverage)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckInsert)
                    .addComponent(CheckSearch)
                    .addComponent(CheckEvaluate)
                    .addComponent(CheckAverage))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(Submit)
                .addContainerGap())
        );

        pack();
    }     
    
    //sunartisi gia to klisimo tis trexon selidas kata tin metafora stin epomeni
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    //metafora se epomeni selida analoga me tin epilogi tou xristi
    private void SubmitActionPerformed(ActionEvent evt) {                                       
        if(CheckInsert.isSelected())
        {
            new Insert(look_op,repeats).setVisible(true);
            close();
        }
        else if(CheckSearch.isSelected())
        {
            new Search(look_op,repeats).setVisible(true);
            close();
        }
        else if (CheckEvaluate.isSelected())
        {
            new Evaluate(look_op,repeats).setVisible(true);
            close();
        }
        else if (CheckAverage.isSelected())
        {
            new Average(look_op,repeats).setVisible(true);
            close();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Something went wrong!\nPlease try again!");
        }    
    }                                      

           
    private JCheckBox CheckEvaluate;
    private JCheckBox CheckInsert;
    private JCheckBox CheckSearch;
    private JCheckBox CheckAverage;
    private JToggleButton Submit;
    private JLabel jLabel1;                  
}
