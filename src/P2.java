

import java.util.Random;

public class P2 extends Thread {

    char[] characters;
    private Buffer buffer;

    public P2(char[] characters, Buffer t){

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

                if(isNumber(random)){
                    notValid = false;
                }

            }

            buffer.lanzar(random);

            System.out.println( "P2 lanzó la letra: " + random);

            try
            {
                sleep(250);
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }

        }


    }


    public static boolean isNumber(char current){

        if (Character.isDigit(current)) {

            return true;
        }

        else{
            return false;
        }

    }


}
