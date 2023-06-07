package databasedemo;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;

public class login  extends  javax.swing.JFrame{
    private JButton Login;
    private JPanel panel1;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JLabel loginLabel;


    public  login (){
        initComponents();


    }
     public void initComponents(){
        this.setContentPane(panel1);
        panel1.setMinimumSize(new Dimension(400, 300));
        panel1.setPreferredSize(new Dimension(400, 300));
        panel1.setMaximumSize(new Dimension(400, 300));


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "Login", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18)));

        Login.addActionListener(e -> {

            String username = usernameTextField.getText();
            String password = passwordPasswordField.getText();
            ResultSet resultSet = null;
            Statement statement = null;
            Connection connection = null;

            if(username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                return;
            }

            try {



                connection=DB.connect(username,password);
                statement=connection.createStatement();
                if(username.equals("BDDAdmin")) {
                    this.setVisible(false);
                    new mainForm().setVisible(true);
                    dispose();

                }
                if(username.equals("Etudiant")){
                    this.setVisible(false);
                    new studentform().setVisible(true);
                    dispose();
                }if(username.equals("Enseignant")){
                    this.setVisible(false);
                    new teacherform().setVisible(true);
                    dispose();
                }


            }catch (SQLException ex){
                ex.printStackTrace();
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");

            }

            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                System.out.println(ex);

                ex.printStackTrace();}
            finally{
                try {
                    if(resultSet != null)
                        resultSet.close();
                    if(statement != null)
                        statement.close();
                    if(connection != null)
                        connection.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }



        });
     }
}
