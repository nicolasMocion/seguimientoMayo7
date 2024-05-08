import java.io.IOException;
import java.util.ArrayList;

public class Consumer extends Thread {

    private Buffer buffer;
    String word;

    int initial;

    public char[] wordA;

    boolean isNotFull = true;

    Persistencia persistencia;

    private ArrayList<Character> aux = new ArrayList<>();


    public Consumer(Buffer t, String word, int initial, char[] wordA)
    {
        buffer = t;
        this.word = word;
        this.initial = initial;
        this.wordA = wordA;
    }



    public void run() {


        char c;

        while(isNotFull){

            for(int i = 0; i < 3 && isNotFull; i++ )
            {

                c = buffer.recoger();
                System.out.println( "Recogido el caracter "+ c );

                if(isInword(word, c)){
                    int index = findIndex(c, word ,wordA);
                    wordA[index] = c;
                    isNotFull = isNotFullyCompleted(wordA);

                }
                else{
                    aux.add(c);
                    try {
                        Hipervisor.guardarLetraSobrante(aux);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            try {
                sleep( 300 );
            }
            catch( InterruptedException e )
            {
                ;
            }

        }

        System.out.println("Done");
        Hipervisor.printArray(wordA);
        Hipervisor.printArrayList(aux);
        Persistencia.guardarRegistroLog("Palabra completada!", 1, "Notificación ","src/LogApp.txt");

    }

    public boolean isInword(String word, char current){

        String charAsString = String.valueOf(current);

        if(word.contains(charAsString)){

            return true;
        }

        else{

            return false;
        }

    }
    
    public int findIndex(char current, String word, char[] wordA){

        int index = -1;

        for (int i = 0; i < word.length() ; i++) {

            if(word.charAt(i) == current){

                if(wordA[i] == ' '){
                    index = i;
                    return index;
                }

                else if(wordA[i] == current){
                    index = i;
                }

            }
        }
        return index;
        
    }

    public boolean isNotFullyCompleted(char[] array) {
        for (char element : array) {
            if (element == ' ') { // Check for default value
                return true;
            }
        }
        return false;
    }

}