/**
 *
 * @author Strazzullo Ciro Andrea
 * @version 1.0
 * @date 26/10/2023
 *
 */

import java.io.*;
public class File {
    /**
     * Funzione per leggere il contenuto di un file
     *
     * @param url url per raggiungere il file
     * @return  stringa con il contenuto del file
     * @throws Exception eccezione lanciata nel caso in cui la lettura non avviene
     */
    public static String leggiDaFile(String url) throws Exception{
        FileReader f = new FileReader(url);
        BufferedReader fIN = new BufferedReader(f);
        String s = "";
        String total = "";
        while(( s = fIN.readLine()) != null){
            total += s;
        }
        fIN.close();
        f.close();
        return total;
    }

    /**
     * Funzione per generare il file in una posizione con un contenuto
     *
     * @param path path per raggiungere il file o per sovrascrivere il file con lo stesso nome nella stessa posizione specificata nella url
     * @param testo testo da inserire nel file
     * @throws Exception eccezione lanciata nel caso in cui la scrittura non avviene
     */
    public static void generaFile(String path,String testo) throws Exception{
        FileWriter f=new FileWriter(path);
        PrintWriter fOUT = new PrintWriter(f);
        fOUT.println(testo);
        fOUT.flush();
        fOUT.close();
        f.close();
    }
}