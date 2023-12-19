import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bingo extends JFrame implements ActionListener {

    JPanel jpanel = (JPanel) this.getContentPane();
    JTextField bingoNumbers = new JTextField();
    JLabel numbersLabel = new JLabel();
    JButton button = new JButton("Vai bola");
    JLabel bingoFinishedLabel = new JLabel();
    int extractions = 1;

    // Icono
    final String ABSOLUTE_PATH_TO_DIR_IMG = "C:\\DAW\\Programación\\Java2Evaluacion\\bingo\\img";
    final String IMAGE_NAME = "numerosBingo.jpg";
    final String IMAGE_PATH = ABSOLUTE_PATH_TO_DIR_IMG + "\\" + IMAGE_NAME;
    ImageIcon icon = new ImageIcon(IMAGE_PATH);
    JLabel iconLabel = new JLabel(icon);



    public Bingo(){
        setSize(800,600);
        setTitle("Bingooooooooo !!!");
        setResizable(true);

        // Disposición nula para control total de panel
        jpanel.setLayout(null);
        jpanel.setBackground(Color.magenta);

        bingoPanelBuilder();
        setVisible(true);


    }

    public void bingoPanelBuilder(){
       numbersLabel.setText("Bolas extraídas: ");
       numbersLabel.setBounds(25, 25, 100, 25);
       jpanel.add(numbersLabel);

       bingoNumbers.setBounds(new Rectangle(200, 25,800, 25));
       bingoNumbers.setEditable(false);
       bingoNumbers.setHorizontalAlignment(JTextField.CENTER);
       jpanel.add(bingoNumbers);

       button.addActionListener(this);
       button.setBounds(25, 70, 100, 75);
       jpanel.add(button);

        bingoFinishedLabel.setText("Bingo finalizado");
        bingoFinishedLabel.setBounds(25, 230, 150, 25);

        jpanel.add(iconLabel);
        iconLabel.setBounds(25, 250, 760, 760);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            turnBomb();
        }
    }

    private void turnBomb(){
        System.out.println("extractions = " + extractions);
        if(extractions > 19){
            button.setEnabled(false);
            jpanel.add(bingoFinishedLabel);
        }

        boolean repeated;
        String actuallyBalls = bingoNumbers.getText();
        int ball;

        do {
            ball = 1 + (int) (Math.random() * 90);
            repeated = actuallyBalls.contains(String.valueOf(ball));
        } while(repeated);
        ++extractions;
        bingoNumbers.setText(actuallyBalls + " " + ball);

    }

}
