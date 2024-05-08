

import java.util.Random;

public class P3 extends Thread {

    char[] characters;
    private Buffer buffer;

    public P3(char[] characters, Buffer t){

        this.characters = characters;
        buffer = t;
    }


    @Override
    public void run() {

        boolean running = true;

        while(running){

            char random = 0;

            boolean notValid = true;

            while (notValid){

                random = Hipervisor.randomSelect(characters);

                if(isConsonant(random)){
                    notValid = false;
                }

            }

            buffer.lanzar(random);

            System.out.println( "P3 lanzó la letra: " + random);

            try
            {
                sleep(150);
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }

        }


    }


    public static boolean isConsonant(char current){

        if (((current == 'a') || (current == 'e') || (current == 'i') || (current == 'o') || (current == 'u'))) {

            return false;
        }

        else{
            return true;
        }

    }


}
