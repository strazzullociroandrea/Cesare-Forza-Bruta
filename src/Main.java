/**a
 *
 *
 * @author Strazzullo Ciro Andrea
 * @version 1.0
 * @date 26/10/2023
 *
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * Funzione per scoprire se la stringa contiene una sola lettera
     *
     * @param input stringa da cntrollare
     * @return boolean: true se contiene una lettera altrimenti false
     */
    public static boolean contieneUnaLettera(String input) {
        String regex = "^[A-Za-z]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Funzione per ottenere la stringa inserita su console utilizzando l'oggetto scanner
     *
     * @return stringa inserita
     */
    public static char valueKey(){
        Scanner s = new Scanner(System.in);
        String chiave = "";
        boolean tentativoUno = true;// false se viene inserita più di una volta una stringa nel formato sbagliato
        do {
            //inizio richiesta inserimento stringa
            if(tentativoUno)
                System.out.println("Inserisci la chiave di crittazione {A-Za-z}:");
            else
                System.out.println("Errore! Inserisci la chiave di crittazione nel modo corretto {A-Za-z}:");
            if(s.hasNext()){
                chiave = s.next();
                if(!contieneUnaLettera(chiave)){
                    chiave = "";
                    tentativoUno = false;
                }
            }else
                tentativoUno = false;
        }while(chiave.equals(""));//ciclo per controllare che la stringa sia vuota o piena, se è vuota ripete la richiesta
        s.close();
        return chiave.toUpperCase().charAt(0);
    }

    public static void main(String[] args) throws Exception{
        CifrarioCesare c = new CifrarioCesare(File.leggiDaFile("src/TestoDaCrittare.txt"),valueKey());//creazione dell'oggetto CifrarioCesare

        //..... crittazione
        String crittata = c.critta();//genero la crittazione del file letto
        System.out.println("stringa crittata: "+crittata);//visualizzo la crittazione
        File.generaFile("src/crittata/crittato.txt",crittata);
        //..... fine crittazione

        String alfabeto = "abcdefghilmnopqrstuvz";//Stringa alfabeto per provare a decrittare a forza bruta il messaggio crittato con il cifrario di cesare

        //..... decrittazione
        for(int i=0;i<alfabeto.length();i++) {
            String decrittata = CifrarioCesare.decritta(crittata, String.valueOf(alfabeto.charAt(i)));
            File.generaFile("src/decrittata/decritta"+i+".txt",decrittata);
        }
        //..... fine decrittazione

        //..... ricerca occorrenze per determinare il file corretto
        FileCorretto fc= new FileCorretto();
        double[][] d = new double[alfabeto.length()][];//array che conterrà tutti gli array generati dal metodo fc.verificaOccorrenze
        for(int i=0;i<alfabeto.length();i++){
            d[i] = fc.verificaOccorrenze("src/decrittata/decritta"+i+".txt");
        }
        File.generaFile("src/possibileFileCorretto/possibileFileCorretto.txt",(
                "Il file probabilmente corretto, basandomi sui dati recuperati dal web e dai file generati " +
                        "\ndurante la decrittazione del file crittato è: 'decritta"+(fc.indicePossibileOriginale(d))+".txt' ."
                ));
        //..... fine ricerca
    }
}