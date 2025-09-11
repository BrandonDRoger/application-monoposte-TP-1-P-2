package org.example.applicationmonopostetp1p2;

public class ResultatClass {
    public void somme(int nombre1, int nombre2, ResultCallback resultCallback){
        int resultat = nombre1 + nombre2;
        resultCallback.onResult(resultat);
    }
}
