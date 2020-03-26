import javax.swing.*;

public class ReadJOptionpane
{
    public static void main(String[] args)
    {
        String name;
        String surname;
        name= JOptionPane.showInputDialog("Please input your name: ");
        surname=JOptionPane.showInputDialog("Please input your surname: ");
        JOptionPane.showMessageDialog(parentComponent :null, message name + " " + surname);
        //JOptionPane.showMessageDialog();
    }
}