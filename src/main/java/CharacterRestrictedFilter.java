import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

public class CharacterRestrictedFilter extends DocumentFilter {
    private int maxNumberOfChars;

    public CharacterRestrictedFilter(int maxNumberOfChars) {
        this.maxNumberOfChars = maxNumberOfChars;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if((fb.getDocument().getLength()+string.length())<=maxNumberOfChars){
            super.insertString(fb,offset,string,attr);
        }else{
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if((fb.getDocument().getLength()+text.length()-length)<=maxNumberOfChars){
            super.replace(fb, offset, length, text, attrs);
        }else{
            Toolkit.getDefaultToolkit().beep();
        }

    }
}