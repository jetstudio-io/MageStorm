package com.peopleincrowd.magestorm.guis;

import com.peopleincrowd.magestorm.process.CreateModuleProcess;

import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class CreateModuleForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton communityRadioButton;
    private JRadioButton localRadioButton;
    private JTextField companyNameTextField;
    private JTextField moduleNametextField;
    private JCheckBox blockCheckBox;
    private JCheckBox modelCheckBox;
    private JCheckBox helperCheckBox;
    private JCheckBox setupCheckBox;

    protected String projectDir;

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    public CreateModuleForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        CreateModuleProcess createModuleProcess = new CreateModuleProcess();

        String codePool = "local";
        if (communityRadioButton.isSelected()) {
            codePool = "community";
        }

        try {
            createModuleProcess.setProjectDir(this.projectDir);
            createModuleProcess.setCodePool(codePool);
            createModuleProcess.setCompany(companyNameTextField.getText());
            createModuleProcess.setModule(moduleNametextField.getText());

            if (blockCheckBox.isSelected()) {
                createModuleProcess.setHasBlock(true);
            }

            if (modelCheckBox.isSelected()) {
                createModuleProcess.setHasModel(true);
            }

            if (helperCheckBox.isSelected()) {
                createModuleProcess.setHasHelper(true);
            }

            if (setupCheckBox.isSelected()) {
                createModuleProcess.setHasSetup(true);
            }

            createModuleProcess.process();
        } catch (FileNotFoundException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String projectDir) {
        CreateModuleForm dialog = new CreateModuleForm();
        dialog.setProjectDir(projectDir);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
