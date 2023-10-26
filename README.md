# Cesare-Forza-Bruta
Scrivere un programma per la crittazione e decrittazione mediante l'algoritmo di Cesare.
Il programma ha in ingresso:
nome del file di testo da crittare
chiave (di quanti caratteri spostare il testo)
Il programma ha in uscita (attacco a forza bruta):
tutti i possibili testi che si possono ottenere per sostituzione dal testo crittato salvandoli su file diversi
l'indicazione del file ch epotrebbe essere verosimilmente quello originale (utilizza un metodo empirico basato sulla frequenza delle lettere della lingua italiana, per ogni file decrittato esegue la statistica sulla frequenza delle lettere e poi ne calcola la distanza in valore assoluto rispetto a quelle della lingua italiana, il testo con la distanza più breve viene considerato quello originale)
Ricordo:
il testo da crittare deve avere tutte le lettere maiuscole (o minuscole)
non vi devono  essere segni di interpunzione (virgole, punti e virgola, punti escalamativi, ...)
a vostra scelta se eliminare o meno gli spazi (va scelta una tabella di frequenze delle lettere opportuna)
