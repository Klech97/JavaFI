import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField nameField, emailField;
    JRadioButton maleRadio, femaleRadio;
    JCheckBox checkBox;

    public ContactForm() {
        super("Contact Form");
        this.setBounds(100, 100, 450, 300); //where will be form
        super.setDefaultCloseOperation(EXIT_ON_CLOSE); //what happen when window close

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2,2));

        JLabel name = new JLabel("Write name:");
        nameField = new JTextField("",1);

        JLabel email = new JLabel("email:");
        emailField = new JTextField("@",1);

        container.add(name);
        container.add(nameField);
        container.add(email);
        container.add(emailField);

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        checkBox = new JCheckBox("Ready?");
        JButton okButton = new JButton("OK");

        maleRadio.setSelected(true);

        container.add(maleRadio);
        container.add(femaleRadio);
        container.add(checkBox);
        container.add(okButton);

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);

        okButton.addActionListener(new ButtonEventManager());

    }
    private class ButtonEventManager implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String isMale = "Male";
            if (!maleRadio.isSelected()) {
                isMale = "Female";
            }

            boolean ready = checkBox.isSelected();

            JOptionPane.showMessageDialog(null,"\nEmail: "+email +
                    "\nSex: "+ isMale+
                    "\nReady? "+ ready,"Hello,"+
                    name,JOptionPane.PLAIN_MESSAGE);
        }
    }
}
