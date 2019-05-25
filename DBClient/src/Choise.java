
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

    public Choise() {
        Graphics();
    }
                      
    private void Graphics() {

        jLabel1 = new JLabel();
        CheckInsert = new JCheckBox();
        CheckSearch = new JCheckBox();
        CheckEvaluate = new JCheckBox();
        Submit = new JToggleButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("MyMusic");

        CheckInsert.setText("Insert Music");

        CheckSearch.setText("Search Music");

        CheckEvaluate.setText("Evaluate Music");

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
                        .addComponent(CheckEvaluate)))
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
                    .addComponent(CheckEvaluate))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(Submit)
                .addContainerGap())
        );

        pack();
    }     
    
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void SubmitActionPerformed(ActionEvent evt) {                                       
        if(CheckInsert.isSelected())
        {
            new Insert().setVisible(true);
            close();
        }
        else if(CheckSearch.isSelected())
        {
            new Search().setVisible(true);
        }
        else if (CheckEvaluate.isSelected())
        {
            new Evaluate().setVisible(true);
        }
        else
        {
            CheckSearch.setSelected(false);
            CheckInsert.setSelected(false);
            CheckEvaluate.setSelected(false);
            JOptionPane.showMessageDialog(this, "Something went wrong!\nPlease try again!");
        }    
    }                                      


                    
    private JCheckBox CheckEvaluate;
    private JCheckBox CheckInsert;
    private JCheckBox CheckSearch;
    private JToggleButton Submit;
    private JLabel jLabel1;                  
}
