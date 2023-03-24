package org.example;

import javax.swing.*;
import java.awt.event.*;

import static org.example.wordCount.wordsCount;

public class frmWord extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton enviarButton;
    private JButton limpiarButton;
    private JPanel panel;
    private JLabel lblResultado;
    private JTextField textField5;

    public frmWord(){
        textField5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char inputChar = e.getKeyChar();

                if (!Character.isDigit(inputChar)) {
                    e.consume(); // Consume el evento si el caracter no es un dígito
                }
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText() == null || textField1.getText().trim().isEmpty() ||
                        textField2.getText() == null || textField2.getText().trim().isEmpty() ||
                        textField3.getText() == null || textField3.getText().trim().isEmpty() ||
                        textField4.getText() == null || textField4.getText().trim().isEmpty() ||
                        textField5.getText() == null || textField5.getText().trim().isEmpty())
                    JOptionPane.showMessageDialog(null, "Por favor termina de ingresar los datos", "Mensaje", JOptionPane.WARNING_MESSAGE);
                else{
                    if(textField5.getText().matches("[0-9]+")) {
                        String[] arr = new String[4];
                        int lenght;

                        lenght = Integer.parseInt(textField5.getText());
                        arr[0] = textField1.getText();
                        arr[1] = textField2.getText();
                        arr[2] = textField3.getText();
                        arr[3] = textField4.getText();

                        lblResultado.setText("Se encontraron "+String.valueOf(wordsCount(arr,lenght))+" Cadenas de ese tamaño");

                        textField1.setEnabled(false);
                        textField3.setEnabled(false);
                        textField2.setEnabled(false);
                        textField4.setEnabled(false);
                        textField5.setEnabled(false);

                        enviarButton.setEnabled(false);
                    }else
                        JOptionPane.showMessageDialog(null, "Ingrese Solo numeros en el tamaño", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");

                textField1.setEnabled(true);
                textField3.setEnabled(true);
                textField2.setEnabled(true);
                textField4.setEnabled(true);
                textField5.setEnabled(true);

                enviarButton.setEnabled(true);
                lblResultado.setText("");
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        frmWord panel = new frmWord();
        panel.setContentPane(new frmWord().panel);
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);
        panel.pack();
    }
}
