

import java.awt.Toolkit;
import java.awt.event.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Νίκος
 */
public class Average extends JFrame {

    ChatInterface look_op;
    Integer repeats;
    public Average(ChatInterface look_op, Integer repeats) {
        this.look_op=look_op;
        this.repeats=repeats;
        Graphics();
    }
                        
    private void Graphics() {

        jScrollPane1 = new JScrollPane();
        Result = new JTextArea();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        Avg = new JTextField();
        Go = new JToggleButton();
        Done = new JToggleButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Result.setEditable(false);
        Result.setColumns(20);
        Result.setRows(5);
        jScrollPane1.setViewportView(Result);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Print Average");

        jLabel2.setText("Set the average you want :");

        Go.setText("Go");
        Go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GoActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Avg, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Go)
                        .addGap(0, 328, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Done, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Avg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(Go))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(Done)
                .addContainerGap())
        );

        pack();
    }                    

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
    private void GoActionPerformed(ActionEvent evt) {                                   
        try {
            // TODO add your handling code here:

            Result.append(look_op.update(Avg.getText(),Integer.parseInt(Avg.getText())));
        } catch (RemoteException ex) {
            Logger.getLogger(Average.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                  

    private void DoneActionPerformed(ActionEvent evt) {                                     
        // TODO add your handling code here:
        close();
        Choise choise = new Choise(look_op,repeats);
        choise.setVisible(true);
        
    }                                    
                  
    private JTextField Avg;
    private JToggleButton Done;
    private JToggleButton Go;
    private JTextArea Result;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;                
}
