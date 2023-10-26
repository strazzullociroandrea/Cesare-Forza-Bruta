/**
 *
 * @author Strazzullo Ciro Andrea
 * @version 1.0
 * @date 26/10/2023
 *
 */

public class CifrarioCesare {
    private String info;
    private char chiave;
    private final String alfabeto = "ABCDEFGHILMNOPQRSTUVZ";
    private int indexKey;
    /**
     * Costruttore
     * @param info Stringa che contiene il testo da criptare
     * @param chiave Stringa che permette di criptare il file
     */
    public CifrarioCesare(String info, char chiave){
        this.info = maiuscola(replaceCaratteriInterpunzione(info));
        this.chiave = chiave;
        this.indexKey = alfabeto.indexOf(this.chiave) + 1;// tiene conto che l'array parte da indice 1 e non 0
    }

    /**
     * Metodo privato per eliminare i caratteri di interpunzione e il carattere spazio
     *
     * @param stringa Stringa da modificare
     * @return Stringa modificata
     */
    private String replaceCaratteriInterpunzione(String stringa) {
        return stringa.replaceAll("[\\p{Punct}\\s]", "");
    }

    /**
     * Metodo privato per rendere la stringa maiuscola per poi criptarla
     *
     * @param stringa Stringa da modificare
     * @return Stringa modificata
     */
    private String maiuscola(String stringa) {
        return stringa.toUpperCase();
    }


    /**
     * Metodo utilizzato per crittare la stringa passata come parametro al costruttore insieme alla chiave
     *
     * @return Stringa crittata
     */
    public String critta() {
        String total = "";
        for(int i=0;i<this.info.length();i++){
            int index = alfabeto.indexOf(this.info.charAt(i)) + 1;// indice char [i]
            int sommaPosizioni = index + indexKey; //posizione finale
            if(sommaPosizioni > alfabeto.length() )
                total += (alfabeto.charAt(sommaPosizioni-alfabeto.length()-1));
            else
                total += (alfabeto.charAt(sommaPosizioni-1));
        }
        return total;
    }

    /**
     * Funzione pubblica per decrittare una stringa crittata con il cifrario di Cesare
     *
     * @param crittata stringa crittata
     * @param key chiave per decrittare la stringa
     * @return stringa crittata
     */
    public static String decritta(String crittata, String key){
        String finale = "";
        key = key.toUpperCase();
        String alfabeto = "ABCDEFGHILMNOPQRSTUVZ";
        int indexKey = alfabeto.indexOf(key.charAt(0)) + 1;//indice chiave passata come parametro
        for(int i=0;i<crittata.length();i++){
            int index = alfabeto.indexOf(crittata.charAt(i)) + 1;// indice char [i]
            int sottrazione = index - indexKey; //posizione finale
            if(sottrazione > 0)
                finale += alfabeto.charAt(sottrazione - 1);
            else
                finale += alfabeto.charAt((sottrazione + alfabeto.length() - 1));
        }
        return finale;
    }

}
