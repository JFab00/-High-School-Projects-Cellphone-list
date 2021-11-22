/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
@SuppressWarnings("unchecked")

public class Cellulare {
    
    public String marca;			/// Attributi della classe Cellulare
    public String modello;			///	---
    public String os;				///	---
    public String tipo;				///	---
    public String dimensioni;		///	---
    public double prezzo;			///	---
    public String immagine;			///	---
    
	/** Costruttore che prendere i valori degli attributi e gli assegna. Verra' usato nella lettura del file quando vengono assegnati gli attributi all'oggetto di tipo Cellulare (Cellulare c)
	*
	* @param marca rappresenta la marca del cellulare, per esempio Samsung o Xiaomi
	* @param modello rappresenta il modello del cellulare, per esempio Galaxy S10 (del Samsung) o Mi A2 Lite (del Xiaomi)
	* @param os rappresenta il sistema operativa del cellulare, per esempio Android o iOS
	* @param tipo rappresenta il tipo del cellulare, per esempio smartphone o non smartphone
	* @param dimensioni rappresenta le dimensioni del cellulare, width X height X thickness
	* @param prezzo rappresenta il prezzo del cellulare
	* @param immagine rappresenta l'immagine del cellulare che si trova nella directory immagine
	*/
    public Cellulare(String marca,String modello,String os,String tipo,String dimensioni,double prezzo,String immagine) {
        this.marca=marca;
        this.modello=modello;
        this.os = os;
        this.tipo = tipo;
        this.dimensioni= dimensioni;
        this.prezzo=prezzo;
        this.immagine = immagine;
        
    }
    
	/** fa esattamente la stessa cosa che fa il costruttore */
    public void set(String marca,String modello,String os,String tipo,String dimensioni,double prezzo,String immagine) {
        this.marca=marca;
        this.modello=modello;
        this.os = os;
        this.tipo = tipo;
        this.dimensioni= dimensioni;
        this.prezzo=prezzo;
        this.immagine = immagine;
        
    }
    
	/** semplice costruttore */
    public Cellulare() {
        this.marca = this.immagine= this.dimensioni = this.marca=this.os = "niente";
        this.prezzo =0.0;
    }
    
	/** Metodo che legge dal file cellulari.csv, prima di tutto prende la riga la splitta trammite le virgole che separa i vari dettagli e gli aggiunge dentro l'array di stringhe "line" che sta per linea... poi tramite il costruttore creato prima aggiunge il contenuto dell'array di stringhe nell'oggetto cellulare c, dopo tutto questo aggiunge l'oggetto dentro l'arraylist. tutto finito ritorna l'arrayList creato */
    public ArrayList leggiFile(ArrayList array) { 
        String[] line = new String[10];
        try{
            Scanner s = new Scanner(new File("cellulari.csv"));
            for (; s.hasNextLine();){
                line = s.nextLine().split(",");
                Cellulare c = new Cellulare(line[0],line[1],line[2],line[3],line[4],Double.parseDouble(line[5]),line[6]);
                array.add(c);
            }
            s.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return array;
    }
   
    public String getMarca() {
        return this.marca;
    }
    public String getModello() {
        return this.modello;
    }
    public String getOS() {
        return this.os;
    }
    public String getDimensioni() {
        return this.dimensioni;
    }
    public String getTipo() {
        return this.tipo;
    }
    public double getPrezzo() {
        return this.prezzo;
    }
    public String getImmagine() {
        return this.immagine;
    }
    
	/** Metodo usato per convertire l'oggetto in stringa */
    public String toString() {
        return ("\nMarca:"+this.marca+
                "\nModello:"+this.modello+
                "\nOS:"+this.os+
                "\nTipo:"+this.tipo+
                "\nDimensioni:"+this.dimensioni+
                "\nPrezzo:"+this.prezzo+
                "\nImmagine:"+this.immagine);
    }
    
	/**metodo usato per quando il file viene salvato*/
	public String scritturaFile(){
        return (this.marca+", "+this.modello+", "+this.os+", "+this.tipo+", "+this.dimensioni+", "+this.prezzo+", "+this.immagine);
    }

}

