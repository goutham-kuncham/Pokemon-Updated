/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongame;

/**
 *
 * @author Half_BlooD PrincE
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author Half_BlooD PrincE
 */
public class BackEnd {

    /**
     * @param args the command line arguments
     */
    static PokemonP p1,p2;
    static ArrayList<PokemonP> pokemon =new ArrayList<>();
    public BackEnd() {
        
        pokemon.add(new VenasaurP());
        pokemon.add(new CharizadP());
        pokemon.add(new BlastoiseP());
        pokemon.add(new FeraligatrP());
        pokemon.add(new TyphlosionP());
        /*pokemon.add(new MewtwoP());
        pokemon.add(new Swampert());
        pokemon.add(new Blaziken());
        pokemon.add(new Sceptile());*/
        }
    void selectPokemonP1(int x){
        p1=pokemon.get(x);
        
    }
    
    void selectPokemonP2(int x){
        p2=pokemon.get(x);
        
    }
    
    void printMoves(){
        for(int i=0;i<4;i++){
            System.out.println(p1.attacks.get(i).name);
        }
    }
}
