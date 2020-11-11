import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class form1 extends JFrame {
    public JFrame a = new JFrame();
    public JPanel panel1, panel2;

    JLabel []text = new JLabel[6];
    JTextField []textInp = new JTextField[6];
    JButton button;

    public form1(){
        //Creating a Layout for panel1
        panel1 = new JPanel(new GridLayout(7, 2, 5, 10));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Inicijalizacija

        button = new JButton("START");

        for (int i=0;i<6;i++){
            textInp[i] = new JTextField();
        }

        for (int i=0;i<6;i++){
            text[i] = new JLabel();
        }

        //Setting Value of Text

        text[0].setText("Br. Djece");
        text[1].setText("Br. Odraslih Osoba");
        text[2].setText("Br. Starih Osoba");
        text[3].setText("Br. Kuca");
        text[4].setText("Br. Kontrolnih Punktova");
        text[5].setText("Br. Ambulantnih Vozila");

        //Inputing components into panel1

        panel1.add(new JLabel(""));panel1.add(button);
        panel1.add(text[0]);panel1.add(textInp[0]);
        panel1.add(text[1]);panel1.add(textInp[1]);
        panel1.add(text[2]);panel1.add(textInp[2]);
        panel1.add(text[3]);panel1.add(textInp[3]);
        panel1.add(text[4]);panel1.add(textInp[4]);
        panel1.add(text[5]);panel1.add(textInp[5]);

        //Frame
        a.setTitle("CSim");
        a.add(panel1);
        a.setMinimumSize(new Dimension(400, 300));
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theHandler handler = new theHandler();
        button.addActionListener(handler);

        //Hndler for button of panel1

        mouseHandler mHandler = new mouseHandler();
        button.addMouseListener(mHandler);

        //Design.Panel1

        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        for (JTextField i : textInp){
            i.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
    }

    public class theHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) throws NumberFormatException{
            try {
                if (e.getSource() == button) {
                    System.out.println(textInp[0]);
                    int youngP = Integer.parseInt(textInp[0].getText());
                    int middleP = Integer.parseInt(textInp[1].getText());
                    int oldP = Integer.parseInt(textInp[2].getText());
                    int houseS = Integer.parseInt(textInp[3].getText());
                    int controlP = Integer.parseInt(textInp[4].getText());
                    int ambulanceV = Integer.parseInt(textInp[5].getText());

                    if (houseS > 0 && controlP > 0 && ambulanceV > 0 && (youngP + middleP + oldP) > 0) {
                        if ( middleP + oldP == 0 ) {
                            JOptionPane.showMessageDialog(null, "Sa brojem osoba nije oguce izvrsiti simulaciju!!!\nPOKUSAJTE PONOVO!!!");
                        }else if ( houseS > 896 - controlP ){
                            JOptionPane.showMessageDialog(null, "Broj kuca je veci nego sto moze se postaviti na matricu!!!\nPOUSAJTE PONOVO!!!");
                        } else {
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Niste unijeli dobre vrijednosti!!!\nAko vam nije jasno procitajte dokumantaciju!!!");
                    }
                }
            } catch (NumberFormatException numberFormatException) {
                //numberFormatException.printStackTrace();
                System.out.println("Pokusaj 1!!!");
            }
        }
    }

    private class mouseHandler implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e){
            if ( e.getSource() == button ){
                button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if ( e.getSource() == button ){
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            }
        }
    }

    public static void main(String[] args) {
        form1 ins = new form1();
    }
}
