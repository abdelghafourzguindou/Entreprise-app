
import java.io.Serializable;
import java.io.*;
import java.util.*;

public abstract class Person implements Serializable {
    
    public int Num;
    public String Code;
    String Nom;
    private String Prenom;
    public int Age;
    public static int _nbrPerson = 0;

    public Person(String Code, String Nom, String Prenom, int Age) {
        // TODO Auto-generated constructor stub
        this._nbrPerson++;
        this.Code=Code;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Age = Age;
        this.Num = this._nbrPerson;
    }

    public Person() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return  "Num		: " + Num
                +"\nCode		: " + Code
                +"\nNom		: " + Nom
                + "\nPrenom		: " + Prenom
                + "\nAge		: " + Age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    
    public abstract void Print();

}
