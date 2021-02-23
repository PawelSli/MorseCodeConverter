import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApplicationView {

    private JFrame jFrame;
    private JScrollPane jScrollPane;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea;
    private JTextArea jTextArea1;
    private JLabel buttonOne;
    private JLabel buttonTwo;
    private JLabel buttonThree;
    private boolean clicked=false;


    public JFrame getjFrame() {
        return jFrame;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public JLabel getButtonThree() {
        return buttonThree;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void addConversionListener(MouseListener mouseListener){
        buttonThree.addMouseListener(mouseListener);
    }


    public ApplicationView(){

        jFrame=new JFrame("MorseCodeConverter");
        jFrame.setSize(940,650);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel=new JPanel();
        jPanel.setBackground(new Color(36,37,38));
        jFrame.add(jPanel);
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.PAGE_AXIS));

        //Welcome text:
        JPanel jPanel3=new JPanel();
        JLabel jLabel=new JLabel();
        jPanel3.setBackground(new Color(36,37,38));
        jLabel.setFont(new Font("ItalicC", 1, 12)); // NOI18N
        jLabel.setFont(new Font(Font.DIALOG,Font.ITALIC,32));
        jLabel.setForeground(new Color(228, 229, 236));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setText("Morse Code Converter");
        jPanel3.setMaximumSize(new Dimension(jFrame.getWidth(),0));
        jPanel3.add(jLabel);
        jPanel.add(jPanel3);

        // Input text:
        JPanel jPanel2=new JPanel();
        jPanel2.setBackground(new Color(36,37,38));
        jScrollPane=new JScrollPane();
        jTextArea=new JTextArea();

        DefaultStyledDocument doc=new DefaultStyledDocument();
        doc.setDocumentFilter(new CharacterRestrictedFilter(5000));
        jTextArea.setDocument(doc);

        jScrollPane.setBackground(new Color(58, 59, 60));
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextArea.setBackground(new Color(58, 59, 60));
        jTextArea.setColumns(80);
        jTextArea.setFont(new Font(Font.DIALOG,Font.PLAIN,14));
        jTextArea.setForeground(new Color(228, 229, 236));
        jTextArea.setLineWrap(true);
        jTextArea.setRows(11);
        jTextArea.setBorder(null);
        jTextArea.setDisabledTextColor(new Color(255, 255, 255));
        jScrollPane.setViewportView(jTextArea);

        jPanel2.add(jScrollPane);
        jPanel2.setMaximumSize(new Dimension(jFrame.getWidth(),0));
        jPanel.add(jPanel2);


        //First separator:
        JPanel separatorPanel=new JPanel();
        separatorPanel.setLayout(new BoxLayout(separatorPanel,BoxLayout.LINE_AXIS));
        JPanel line=new JPanel();
        line.setBackground(new Color(36,37,38));
        line.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));

        separatorPanel.add(new Box.Filler(new Dimension(20,0),new Dimension(20,0),new Dimension(21,0)));
        separatorPanel.add(line);
        separatorPanel.add(new Box.Filler(new Dimension(20,0),new Dimension(20,0),new Dimension(22,0)));

        separatorPanel.setBackground(new Color(36,37,38));
        separatorPanel.setMaximumSize(new Dimension(jFrame.getWidth(),1));
        jPanel.add(separatorPanel);

        //Buttons:
        JPanel jpanel4=new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.LINE_AXIS));

        jpanel4.setPreferredSize(new Dimension(jFrame.getWidth(),54));





        buttonOne=new JLabel("Convert: Text",SwingConstants.CENTER);
        buttonOne.setMaximumSize(new Dimension((jFrame.getWidth()-40)/3,80));
        buttonOne.setBackground(new Color(36, 37, 38));
        buttonOne.setOpaque(true);
        buttonOne.setForeground(new Color(228, 229, 236));

        ChangeModeListener changeModeListener=new ChangeModeListener();
        buttonOne.addMouseListener(changeModeListener);


        buttonTwo=new JLabel("Clear",SwingConstants.CENTER);
        buttonTwo.setMaximumSize(new Dimension((jFrame.getWidth()-40)/3,80));
        buttonTwo.setBackground(new Color(36, 37, 38));
        buttonTwo.setForeground(new Color(228, 229, 236));
        buttonTwo.setOpaque(true);
        ClearListener clearListener=new ClearListener(jTextArea,buttonTwo);
        buttonTwo.addMouseListener(clearListener);



        buttonThree=new JLabel("Convert",SwingConstants.CENTER);
        buttonThree.setMaximumSize(new Dimension((jFrame.getWidth()-40)/3,80));
        buttonThree.setBackground(new Color(36, 37, 38));
        buttonThree.setForeground(new Color(228, 229, 236));
        buttonThree.setOpaque(true);

        jpanel4.add(new Box.Filler(new Dimension(20,0),new Dimension(20,0),new Dimension(20,0)));
        jpanel4.add(buttonOne);
        jpanel4.add(buttonTwo);
        jpanel4.add(buttonThree);
        jpanel4.add(new Box.Filler(new Dimension(20,0),new Dimension(20,0),new Dimension(20,0)));

        //First button:



        jpanel4.setBackground(new Color(36,37,38));
        jPanel.add(jpanel4);

        //Second separator:

        JPanel secondSeparator=new JPanel();
        secondSeparator.setLayout(new BoxLayout(secondSeparator,BoxLayout.LINE_AXIS));
        JPanel line1=new JPanel();
        line1.setBackground(new Color(36,37,38));
        line1.setBorder(BorderFactory.createMatteBorder(1,0,0,0,new Color(255,255,255)));

        secondSeparator.add(new Box.Filler(new Dimension(20,0),new Dimension(20,0),new Dimension(21,0)));
        secondSeparator.add(line1);
        secondSeparator.add(new Box.Filler(new Dimension(20,0),new Dimension(20,0),new Dimension(22,0)));

        secondSeparator.setBackground(new Color(36,37,38));
        secondSeparator.setMaximumSize(new Dimension(jFrame.getWidth(),1));
        jPanel.add(secondSeparator);





        //Output text:

        JPanel jPanel6=new JPanel();
        jPanel6.setBackground(new Color(36,37,38));
        jScrollPane1=new JScrollPane();
        jTextArea1=new JTextArea();

        jScrollPane1.setBackground(new Color(58, 59, 60));
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jTextArea1.setBackground(new Color(58, 59, 60));
        jTextArea1.setColumns(80);
        jTextArea1.setFont(new Font(Font.DIALOG,Font.PLAIN,14));
        jTextArea1.setForeground(new Color(228, 229, 236));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(11);
        jTextArea1.setBorder(null);
        jTextArea1.setDisabledTextColor(new Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel6.add(jScrollPane1);
        jPanel6.setMaximumSize(new Dimension(jFrame.getWidth(),0));
        jPanel.add(jPanel6);

        JPanel testPanel=new JPanel();
        testPanel.setBackground(new Color(36,37,38));
        jPanel.add(testPanel);


        jTextArea.setToolTipText(setToolTip());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width / 2 - jFrame.getSize().width / 2, dim.height / 2 - jFrame.getSize().height / 2);
        jFrame.setResizable(false);


    }

    public String  setToolTip(){
            if(clicked){
                 return "Enter any text consisting of Latin characters, numbers or special characters.";
            }else {
                return "Wprowadź kod Morse'a składający się ze z kropek i kresek.";
            }
    }

    public class ChangeModeListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {
            clicked=!clicked;
            if(clicked){
                buttonOne.setText("Convert: Mourse Code");
            }else {
                buttonOne.setText("Convert: Text");
            }

        }
        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            buttonOne.setBackground(new Color(59,60,60));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            buttonOne.setBackground(new Color(36,37,38));
        }
    }


}
