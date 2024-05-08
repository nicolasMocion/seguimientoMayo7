

import java.util.Random;

public class P4 extends Thread {

    char[] characters;
    private Buffer buffer;

    public P4(char[] characters, Buffer t){

        this.characters = characters;
        buffer = t;
    }


    public void run() {

        boolean running = true;

        while(running){

            char random = 0;

            boolean notValid = true;

            while (notValid){

                random = Hipervisor.randomSelect(characters);

                if(isVowel(random)){
                    notValid = false;
                }

            }

            buffer.lanzar(random);

            System.out.println( "P4 lanzó la letra: " + random);

            try
            {
                sleep(50);
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }

        }


    }


    public static boolean isVowel(char current){

        if (((current == 'a') || (current == 'e') || (current == 'i') || (current == 'o') || (current == 'u'))) {

            return true;
        }

        else{
            return false;
        }

    }


}
