
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
public class Result extends JFrame {

    public Result() {
        Graphics();
    }
                       
    private void Graphics() {

        jLabel1 = new JLabel();
        jScrollPane2 = new JScrollPane();
        Result = new JTextArea();
        Done = new JToggleButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Results");

        Result.setEditable(false);
        Result.setColumns(20);
        Result.setRows(5);
        jScrollPane2.setViewportView(Result);

        Done.setText("Done");
        Done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Done, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(Done)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void DoneActionPerformed(ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

                  
    private JToggleButton Done;
    private JTextArea Result;
    private JLabel jLabel1;
    private JScrollPane jScrollPane2;               
}
