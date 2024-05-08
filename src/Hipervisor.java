import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hipervisor {


    public static void main(String[] args) {

        char[] allCharacters = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']', '{', '}', ';', ':', ',', '.', '<', '>', '/', '?'
        };

        String word = "progr@macion_3#2023%";

        Persistencia persistencia;

        Buffer t = new Buffer();

        char[] target = createCharArrayWithSpaces(word.length());

        P1 p1 = new P1(allCharacters, t);
        P2 p2 = new P2(allCharacters, t );
        P3 p3 = new P3(allCharacters, t );
        P4 p4 = new P4(allCharacters, t );

        Consumer c = new Consumer( t, word, word.length(), target);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c.start();

    }



    public static char randomSelect(char[] characters){

        Random rand = new Random();
        int randomNumber = rand.nextInt(characters.length);

        char random = characters[randomNumber];

        return random;
    }

    public static char[] createCharArrayWithSpaces(int length) {
        char[] charArray = new char[length];

        // Fill the array with black spaces
        for (int i = 0; i < length; i++) {
            charArray[i] = ' ';
        }

        return charArray;
    }

    public static void printArray(char[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    public static void printArrayList(ArrayList<Character> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void guardarLetraSobrante(ArrayList<Character> sobrantes) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (Character sobrante : sobrantes) {
            contenido.append(sobrante).append(' ');
        }
        Persistencia.guardarArchivo("src/letrasSobrantes.txt", contenido.toString(),  false);
    }

}
