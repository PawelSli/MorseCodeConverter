import org.junit.Assert;
import org.junit.Test;


import java.util.Random;

public class ApplicationConverterTest {
    String text="Pawel jest studentem.";
    String morseCode=".--. .- .-- . .-.. / .--- . ... - / ... - ..- -.. . -. - . -- .-.-.-";

    @Test
    public void checkBeforeConvertToMorseNormalText() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertTrue(applicationConverter.checkBeforeConvertToMorse("112421fsafsfs"));
    }

    @Test
    public void checkBeforeConvertToMorsePolishText() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertTrue(applicationConverter.checkBeforeConvertToMorse("Paweł Śliwa"));
    }

    @Test
    public void checkBeforeConvertToMorseForeignText() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertFalse(applicationConverter.checkBeforeConvertToMorse("ポールは22歳。"));
    }


    @Test
    public void checkBeforeConvertToEnglishCorrectCode() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertTrue(applicationConverter.checkBeforeConvertToEnglish("..--.."));
    }

    @Test
    public void checkBeforeConvertToEnglishIncorrectCode() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertFalse(applicationConverter.checkBeforeConvertToEnglish("..--..21421"));
    }


    @Test
    public void convertToMorse() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertEquals(applicationConverter.convertToMorse(text).replaceAll(" ",""),morseCode.replaceAll(" ","").replaceAll("/",""));
    }

    @Test
    public void convertToEnglish() {
        ApplicationConverter applicationConverter=new ApplicationConverter();
        Assert.assertEquals(applicationConverter.convertToEnglish(morseCode.replaceAll("/","")),text.toUpperCase());
    }

    @Test
    public void initialize() {
        Random random=new Random();
        char randomChar =(char)(random.nextInt(26) + 'A');
        boolean solution=false;
        ApplicationConverter applicationConverter=new ApplicationConverter();
        if(applicationConverter.getAlphabet().keySet().contains(new Character(randomChar)))
            solution=true;
        Assert.assertEquals(solution,true);
    }
}
