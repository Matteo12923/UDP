/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientudp;

/**
 *
 * @author hp
 */
public class Dipendente {
    private String nome;
    private String cognome;
    private int id;
    
    public Dipendente(String nome,String cognome,int id){
    
        this.nome=nome;
        this.cognome=cognome;
        this.id=id;
    }
    
    public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome=nome;
}
public String getCognome(String cognome){
return cognome;
}
public void setcognome(){
this.cognome=cognome;
}


}
