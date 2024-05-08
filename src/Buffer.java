public class Buffer {

    private char[] buffer = new char[10];
    private int siguiente = 0;
    private boolean estaLlena = false;
    private boolean estaVacia = true;



    public synchronized char recoger() //Consumer.java
    {
        while(estaVacia)
        {
            try {
                wait();
            } catch( InterruptedException e ) {
                ;
            }
        }
        siguiente--;
        if( siguiente == 0 )
            estaVacia = true;


        estaLlena = false;
        notify();

        return( buffer[siguiente] );
    }

    public synchronized void lanzar( char c )
    {
        while(estaLlena)
        {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch( InterruptedException e ) {
                ;
            }
        }
        buffer[siguiente] = c;
        siguiente++;
        if( siguiente == 10 )
            estaLlena = true;
        estaVacia = false;
        notify();
    }

}
