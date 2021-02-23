import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ApplicationConverter {

    private  Map<Character,String> alphabet=new LinkedHashMap<>();

    public Map<Character, String> getAlphabet() {
        return alphabet;
    }

    public void initialize(){
        //Letters:
        alphabet.put('A',".-");
        alphabet.put('B', "-...");
        alphabet.put('C', "-.-.");
        alphabet.put('D',"-..");
        alphabet.put('E',".");
        alphabet.put('F',"..-.");
        alphabet.put('G',"--.");
        alphabet.put('H',"....");
        alphabet.put('I',"..");
        alphabet.put('J',".---");
        alphabet.put('K',"-.-");
        alphabet.put('L',".-..");
        alphabet.put('M',"--");
        alphabet.put('N',"-.");
        alphabet.put('O',"---");
        alphabet.put('P',".--.");
        alphabet.put('Q',"--.-");
        alphabet.put('R',".-.");
        alphabet.put('S',"...");
        alphabet.put('T',"-");
        alphabet.put('U',"..-");
        alphabet.put('V',"...-");
        alphabet.put('W',".--");
        alphabet.put('X',"-..-");
        alphabet.put('Y',"-.--");
        alphabet.put('Z',"--..");

        //Numbers:
        alphabet.put('0',"-----");
        alphabet.put('1',".----");
        alphabet.put('2',"..---");
        alphabet.put('3',"...--");
        alphabet.put('4',"....-");
        alphabet.put('5',".....");
        alphabet.put('6',"-....");
        alphabet.put('7',"--...");
        alphabet.put('8',"---..");
        alphabet.put('9',"----.");
        //Punctuation:
        alphabet.put('.',".-.-.-");
        alphabet.put(',',"--..--");
        alphabet.put('?',"..--..");
        String temp="'";
        char temp1=temp.charAt(0);
        alphabet.put(temp1,".----.");
        alphabet.put('!',"-.-.--");
        alphabet.put('/',"-..-.");
        alphabet.put('(',"-.--.");
        alphabet.put(')',"-.--.-");
        alphabet.put('&',".-...");
        alphabet.put(':',"---...");
        alphabet.put(';',"-.-.-.");
        alphabet.put('=',"-...-");
        alphabet.put('+',".-.-.");
        alphabet.put('-',"-....-");
        alphabet.put('_',"..--.-");
        alphabet.put('"',".-..-.");
        alphabet.put('$',"...-..-");
        alphabet.put('@',".--.-.");
        alphabet.put('¿',"..-.-");
        alphabet.put('¡',"--...-");
        alphabet.put(' '," ");

        //Polish letters:
        alphabet.put('Ą',".-.-");
        alphabet.put('Ć',"-.-..");
        alphabet.put('Ę',"..-..");
        alphabet.put('Ł',".-..-");
        alphabet.put('Ń',"--.--");
        alphabet.put('Ó',"---.");
        alphabet.put('Ś',"...-...");
        alphabet.put('Ż',"--..-.");
        alphabet.put('Ź',"--..-");

    }

    public boolean checkBeforeConvertToMorse(String text){
        String temp=text.toUpperCase();
        for(char a:temp.toCharArray()){
            if(!((alphabet.containsKey(a))||(a==' ')||(a=='\n'))){
                return false;
            }
        }
        return true;
    }

    public boolean checkBeforeConvertToEnglish(String text){
        ArrayList<Character> tab=new ArrayList<Character>();
        tab.add('-');
        tab.add('.');
        tab.add(' ');
        tab.add('\n');
        tab.add('\t');
        for(char a:text.toCharArray()){
            if(!tab.contains(a)){
                return false;
            }
        }
        return true;
    }

    public String convertToMorse(String text){
        String temp=text.toUpperCase();
        String solution="";
        for(char x:temp.toCharArray()){
            for(char y:alphabet.keySet()){
                if(x==y){
                    solution+=alphabet.get(y);
                    solution+=" ";
                }
            }
        }
        return solution;
    }

    public String convertToEnglish(String text){
        text+=" ";
        String solution="";
        String decipher="";
        int i = 0;
        for (char x:text.toCharArray()){
            if(x!=' '){
                i=0;
                decipher+=x;
            }else{
                i+=1;
                if(i==2){
                    solution+=" ";
                }else{
                    for(Map.Entry<Character,String> entry:alphabet.entrySet()){
                        if(decipher.equals(entry.getValue())){
                            solution+=entry.getKey();
                            decipher="";
                        }
                    }
                }
            }
        }
        return solution;
    }

    public ApplicationConverter() {
        initialize();
    }

}
