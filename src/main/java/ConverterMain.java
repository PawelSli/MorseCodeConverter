public class ConverterMain {

    public static void main(String[] args){

        ApplicationConverter applicationConverter=new ApplicationConverter();
        ApplicationView applicationView=new ApplicationView();
        ApplicationController applicationController=new ApplicationController(applicationView,applicationConverter);

    }
}
