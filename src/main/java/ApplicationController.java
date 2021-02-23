import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApplicationController {

    private ApplicationView applicationView;
    private ApplicationConverter applicationConverter;

    public ApplicationController(ApplicationView applicationView, ApplicationConverter applicationConverter) {
        this.applicationView = applicationView;
        this.applicationConverter = applicationConverter;
        ConvertListener convertListener=new ConvertListener();
        this.applicationView.addConversionListener(convertListener);
        this.applicationView.getjFrame().setVisible(true);
    }

    class ConvertListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(applicationView.getjTextArea().getText().equals("")){
                final JDialog jDialog = new JDialog();
                jDialog.setBackground(new Color(40, 49, 180));
                jDialog.setSize(380, 150);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                jDialog.setLocation(dim.width / 2 - jDialog.getWidth() / 2, dim.height / 2 - jDialog.getHeight() / 2);

                JPanel tempPanel = new JPanel();
                tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.PAGE_AXIS));
                tempPanel.setBackground(new Color(36, 37, 38));
                jDialog.add(tempPanel);

                JPanel tempPanel2 = new JPanel();
                JLabel tempLabel = new JLabel("\nNo data to convert. !", SwingConstants.CENTER);
                tempLabel.setForeground(new Color(255, 255, 255));
                tempPanel2.add(tempLabel);
                tempPanel.add(tempPanel2);
                tempPanel2.setBackground(new Color(36, 37, 38));

                JPanel tempPanel3 = new JPanel();
                final JLabel tempLabel1 = new JLabel("OK", SwingConstants.CENTER);
                tempLabel1.setForeground(new Color(255, 255, 255));
                tempLabel1.setBackground(new Color(36, 37, 38));
                tempLabel1.setPreferredSize(new Dimension(75, 45));
                tempLabel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
                tempLabel1.setOpaque(true);
                tempLabel1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        jDialog.dispose();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        tempLabel1.setBackground(new Color(59, 60, 60));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        tempLabel1.setBackground(new Color(36, 37, 38));
                    }
                });
                tempPanel3.add(tempLabel1);
                tempPanel.add(tempPanel3);
                tempPanel3.setBackground(new Color(36, 37, 38));

                jDialog.setVisible(true);
            }else {
                //long start = System.nanoTime();
                if (!applicationView.isClicked()) {

                    if (!applicationConverter.checkBeforeConvertToEnglish(applicationView.getjTextArea().getText())) {
                        final JDialog jDialog = new JDialog();
                        jDialog.setBackground(new Color(40, 49, 180));
                        jDialog.setSize(380, 150);
                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                        jDialog.setLocation(dim.width / 2 - jDialog.getWidth() / 2, dim.height / 2 - jDialog.getHeight() / 2);

                        JPanel tempPanel = new JPanel();
                        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.PAGE_AXIS));
                        tempPanel.setBackground(new Color(36, 37, 38));
                        jDialog.add(tempPanel);

                        JPanel tempPanel2 = new JPanel();
                        JLabel tempLabel = new JLabel("\nUse only dots, lines and spaces. !", SwingConstants.CENTER);
                        tempLabel.setForeground(new Color(255, 255, 255));
                        tempPanel2.add(tempLabel);
                        tempPanel.add(tempPanel2);
                        tempPanel2.setBackground(new Color(36, 37, 38));

                        JPanel tempPanel3 = new JPanel();
                        final JLabel tempLabel1 = new JLabel("OK", SwingConstants.CENTER);
                        tempLabel1.setForeground(new Color(255, 255, 255));
                        tempLabel1.setBackground(new Color(36, 37, 38));
                        tempLabel1.setPreferredSize(new Dimension(75, 45));
                        tempLabel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
                        tempLabel1.setOpaque(true);
                        tempLabel1.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                jDialog.dispose();
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                tempLabel1.setBackground(new Color(59, 60, 60));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                tempLabel1.setBackground(new Color(36, 37, 38));
                            }
                        });
                        tempPanel3.add(tempLabel1);
                        tempPanel.add(tempPanel3);
                        tempPanel3.setBackground(new Color(36, 37, 38));

                        jDialog.setVisible(true);
                    } else {
                        applicationView.getjTextArea1().setText(applicationConverter.convertToEnglish(applicationView.getjTextArea().getText()));
                        //long end = System.nanoTime();
                        //System.out.println("Czas konwersji z kodu Morse'a na język angielski: " + (end - start) / Math.pow(10, 9));
                    }
                } else {
                    if (!applicationConverter.checkBeforeConvertToMorse(applicationView.getjTextArea().getText())) {
                        final JDialog jDialog = new JDialog();
                        jDialog.setBackground(new Color(40, 49, 180));
                        jDialog.setSize(380, 150);
                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                        jDialog.setLocation(dim.width / 2 - jDialog.getWidth() / 2, dim.height / 2 - jDialog.getHeight() / 2);

                        JPanel tempPanel = new JPanel();
                        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.PAGE_AXIS));
                        tempPanel.setBackground(new Color(36, 37, 38));
                        jDialog.add(tempPanel);

                        JPanel tempPanel2 = new JPanel();
                        JLabel tempLabel = new JLabel("\nUse only Latin characters, numbers and special characters !", SwingConstants.CENTER);
                        tempLabel.setForeground(new Color(255, 255, 255));
                        tempPanel2.add(tempLabel);
                        tempPanel.add(tempPanel2);
                        tempPanel2.setBackground(new Color(36, 37, 38));

                        JPanel tempPanel3 = new JPanel();
                        final JLabel tempLabel1 = new JLabel("OK", SwingConstants.CENTER);
                        tempLabel1.setForeground(new Color(255, 255, 255));
                        tempLabel1.setBackground(new Color(36, 37, 38));
                        tempLabel1.setPreferredSize(new Dimension(75, 45));
                        tempLabel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(255, 255, 255)));
                        tempLabel1.setOpaque(true);
                        tempLabel1.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                jDialog.dispose();
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                tempLabel1.setBackground(new Color(59, 60, 60));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                tempLabel1.setBackground(new Color(36, 37, 38));
                            }
                        });
                        tempPanel3.add(tempLabel1);
                        tempPanel.add(tempPanel3);
                        tempPanel3.setBackground(new Color(36, 37, 38));

                        jDialog.setVisible(true);
                    } else {
                        applicationView.getjTextArea1().setText(applicationConverter.convertToMorse(applicationView.getjTextArea().getText()));
                    }
                }
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
            applicationView.getButtonThree().setBackground(new Color(59,60,60));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            applicationView.getButtonThree().setBackground(new Color(36,37,38));
        }
    }


}
