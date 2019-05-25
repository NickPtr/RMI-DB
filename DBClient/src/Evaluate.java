
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
public class Evaluate extends JFrame {

    public Evaluate() {
        Graphics();
    }
                          
    private void Graphics() {

        jLabel1 = new JLabel();
        jLabel4 = new JLabel();
        Rating = new JTextField();
        jLabel5 = new JLabel();
        Name = new JTextField();
        jLabel2 = new JLabel();
        Search = new JTextField();
        jScrollPane1 = new JScrollPane();
        Result = new JTextArea();
        SearchButton = new JToggleButton();
        SubmitButton = new JToggleButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Evaluate Song");

        jLabel4.setText("Name : ");

        jLabel5.setText("Rating : ");

        jLabel2.setText("Search by Title : ");

        Result.setEditable(false);
        Result.setColumns(20);
        Result.setRows(5);
        jScrollPane1.setViewportView(Result);

        SearchButton.setText("Search");
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Name, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Rating, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addComponent(SubmitButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Search, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(SubmitButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }                                                            

    private void SearchButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void SubmitButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

                  
    private JTextField Name;
    private JTextField Rating;
    private JTextArea Result;
    private JTextField Search;
    private JToggleButton SearchButton;
    private JToggleButton SubmitButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;                  
}
