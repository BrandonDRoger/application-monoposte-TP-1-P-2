package org.example.applicationmonopostetp1p2;

import java.util.List;

public class AfficheListe {

    public void afficherItem(List<String> liste, ItemCallback itemCallBack){
        for(String item : liste){
            itemCallBack.affiche(item);
        }
    }
}
