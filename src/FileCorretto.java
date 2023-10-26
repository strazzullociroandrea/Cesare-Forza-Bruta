/**
 *
 * @author Strazzullo Ciro Andrea
 * @version 1.0
 * @date 26/10/2023
 *
 */


public class FileCorretto {

    //attributi di istanza
    private final String lettere =
            "ABCDEFGHILMNOPQRSTUVZ";
    private final double[] frequenze = {
            10.65,0.92,4.50,3.73,11.79,0.95,1.64,1.54,11.28,6.51,
            2.51,6.88,9.83,3.05,0.51,6.37,4.98,5.62,3.01,2.10,0.49
    };

    /**
     * Metodo utilzzato per verificare le occorrenze di una lettera in un file
     *
     * @param path path al file da leggere
     * @return  array di double contenenti le occorrenze delle lettere
     * @throws Exception eccezione lanciata se non è stato possibile leggere il file
     */
    public double[] verificaOccorrenze(String path) throws Exception {
        double occorrenze[] = new double[lettere.length()];
        String file = File.leggiDaFile(path);
        file = file.toUpperCase(); // Normalizza in maiuscolo
        for (int i = 0; i < file.length(); i++) {
            char carattere = file.charAt(i);
            // Ricerca l'indice
            int indexCarattere = lettere.indexOf(carattere);
            if (indexCarattere != -1)  // Controlla se il carattere è una lettera valida
                occorrenze[indexCarattere]++;// Somma

        }
        //genero le frequenze rispetto alla grandezza della stringa del file
        for(int i=0;i<occorrenze.length;i++)
            occorrenze[i] = occorrenze[i] / file.length();
        return occorrenze;
    }


    /**
     * Metodo per creare il confronto tra le frequenze delle lettere nella lingua italiana e un array double
     * passato come parametro
     *
     * @param d array di double da confrontare con l'array delle frequenze delle lettere nella lingua italiana
     * @return array di double con il confronto
     */
    private double[] confrontoConAlfabeto(double[] d){
        double[] s = new double[d.length];
        for(int i=0;i<d.length;i++)
            s[i] = Math.abs(frequenze[i] - d[i]);
        return s;
    }

    /**
     * Metodo privato per ricercare l'array contenente i valori minimi
     *
     * @param arrayDiArray (file x => valori x)
     * @return indice dell'array con valori minori
     */
    public int trovaIndiceArrayConValoriMinimi(double[][] arrayDiArray) {
        double[] somme = new double[arrayDiArray.length];
        //riduco l'array in un array più facile
        for(int i=0;i<arrayDiArray.length;i++){
            double somma = 0;
            for(int j=0;j<arrayDiArray[i].length;j++)
                somma += arrayDiArray[i][j];
            somme[i] = somma / arrayDiArray[i].length;
        }

        double sommaMinima = Double.MAX_VALUE;//valore massimo di double
        int posMinima = 0;
        //ricerco dell'indice del valore minimo basandosi sulla posizione della somma minore
        for(int i=0;i<somme.length;i++){
            System.out.println(i+" somma "+somme[i]);
            if (somme[i] < sommaMinima) {
                sommaMinima = somme[i];
                posMinima = i;
            }
        }
        return posMinima;
    }


    /**
     * Metodo per ricercare l'indice del file corretto
     *
     * @param matrice array di array (file x => valori x), gli array devono essere double
     * @return  intero, l'indice del file corretto
     */
    public int indicePossibileOriginale(double[][] matrice){
        int index = -1;
        double[][] temp = new double[matrice.length][];
        for(int i=0;i<matrice.length;i++)
            temp[i] = this.confrontoConAlfabeto(matrice[i]);
        index = trovaIndiceArrayConValoriMinimi(temp);
        return index;
    }
}
