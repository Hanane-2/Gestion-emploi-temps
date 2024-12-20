/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionemploiv2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class UserPage { 
     public UserPage() {
       
   JFrame frame = new JFrame("User-Page");
JPanel panel = new JPanel();
JMenuBar menuBar = new JMenuBar();
JMenu insertion = new JMenu("Gestion des Seance");
JMenu modification = new JMenu("Modifier Profile");
JMenuItem pInsertion = new JMenuItem("Insertion d'une Seance");
JMenuItem pfModification = new JMenuItem("Modifier d'une Seance");
JMenuItem pModification = new JMenuItem("Modifier votre mot de pass");
JMenuItem pSuppression = new JMenuItem("Suppression d'une Seance");
JMenuItem pExport = new JMenuItem("Export-List des Seances");

// Add ActionListener to pModification JMenuItem
pModification.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame passwordFrame = new JFrame("Modifier votre mot de passe");
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new GridBagLayout());
        JLabel oldPasswordLabel = new JLabel("Old Password:");
        JPasswordField oldPasswordField = new JPasswordField(20);
        JLabel newPasswordLabel = new JLabel("New Password:");
        JPasswordField newPasswordField = new JPasswordField(20);
        JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password:");
        JPasswordField confirmNewPasswordField = new JPasswordField(20);
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(oldPasswordField.getPassword());
                String newPassword = new String(newPasswordField.getPassword());
                String confirmNewPassword = new String(confirmNewPasswordField.getPassword());
                
                oldPasswordField.setText("");
                newPasswordField.setText("");
                confirmNewPasswordField.setText("");
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        passwordPanel.add(oldPasswordLabel, gbc);
        gbc.gridx = 1;
        passwordPanel.add(oldPasswordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        passwordPanel.add(newPasswordLabel, gbc);
        gbc.gridx = 1;
        passwordPanel.add(newPasswordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        passwordPanel.add(confirmNewPasswordLabel, gbc);
        gbc.gridx = 1;
        passwordPanel.add(confirmNewPasswordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        passwordPanel.add(confirmButton, gbc);
        passwordFrame.add(passwordPanel);
        passwordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        passwordFrame.setSize(400, 300);
        passwordFrame.setLocationRelativeTo(null);
        passwordFrame.setVisible(true);
    }
});

insertion.add(pInsertion);
insertion.add(pfModification);
insertion.add(pSuppression);
insertion.add(pExport);
modification.add(pModification);
frame.setLayout(new GridLayout(7, 1));
menuBar.add(insertion);
menuBar.add(modification);
frame.setJMenuBar(menuBar);
frame.add(panel);
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 300);
frame.setVisible(true);
    
}
}