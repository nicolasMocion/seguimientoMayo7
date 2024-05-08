

import java.util.Random;

public class P1 extends Thread {

    Hipervisor hipervisor;

    char[] characters;
    private Buffer buffer;

    public P1(char[] characters, Buffer t){

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

                if(isSpecial(random)){
                    notValid = false;
                }

            }

            buffer.lanzar(random);

            System.out.println( "P1 lanzó la letra: " + random);

            try
            {
                sleep(350);
            }
            catch( InterruptedException e )
            {
                System.out.println(e);
            }

        }


    }

    public static boolean isSpecial(char current){

        if (!Character.isDigit(current) && !Character.isLetter(current) && !Character.isWhitespace(current)) {

            return true;
        }

        else{
            return false;
        }

    }


}
