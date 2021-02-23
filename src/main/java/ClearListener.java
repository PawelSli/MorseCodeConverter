import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClearListener implements MouseListener {
    private JTextArea jTextArea;
    private JLabel button;

    public ClearListener(JTextArea jTextArea, JLabel button) {
        this.jTextArea = jTextArea;
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!jTextArea.getText().equals("")){
            jTextArea.setText("");
        }else{
            final JDialog jDialog=new JDialog();
            jDialog.setBackground(new Color(40,49,180));
            jDialog.setSize(380,150);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            jDialog.setLocation(dim.width/2 -jDialog.getWidth()/2 , dim.height / 2-jDialog.getHeight()/2);

            JPanel tempPanel=new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel,BoxLayout.PAGE_AXIS));
            tempPanel.setBackground(new Color(36, 37, 38));
            jDialog.add(tempPanel);

            JPanel tempPanel2=new JPanel();
            JLabel tempLabel=new JLabel("\nNo data to be cleaned. !",SwingConstants.CENTER);
            tempLabel.setForeground(new Color(255,255,255));
            tempPanel2.add(tempLabel);
            tempPanel.add(tempPanel2);
            tempPanel2.setBackground(new Color(36, 37, 38));

            JPanel tempPanel3=new JPanel();
            final JLabel tempLabel1=new JLabel("OK",SwingConstants.CENTER);
            tempLabel1.setForeground(new Color(255,255,255));
            tempLabel1.setBackground(new Color(36,37,38));
            tempLabel1.setPreferredSize(new Dimension(75,45));
            tempLabel1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,new Color(255,255,255)));
            tempLabel1.setOpaque(true);
            tempLabel1.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jDialog.dispose();
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    tempLabel1.setBackground(new Color(59,60,60));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    tempLabel1.setBackground(new Color(36,37,38));
                }
            });
            tempPanel3.add(tempLabel1);
            tempPanel.add(tempPanel3);
            tempPanel3.setBackground(new Color(36, 37, 38));

            jDialog.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(new Color(59,60,60));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(new Color(36,37,38));
    }
}
