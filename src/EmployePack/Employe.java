
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Employe extends Person implements Comparable, Serializable {

    private double Salaire;
    public static int nbrEmploye = 0;

    public LinkedList<Employe> EmployeGroup;
    public LinkedList<Client> ClientList;

    public Employe() {
        // TODO Auto-generated constructor stub
    }

    public Employe(String Code, String Nom, String Prenom, int Age, double Salaire) throws MyException {
        // TODO Auto-generated constructor stub
        super(Code, Nom, Prenom, Age);
        if (Salaire < 2500) {
            throw new MyException("Salaire Invalide");
        } else {
            this.Salaire = Salaire;
        }
        //ClientList = new LinkedList<Client>();
        EmployeGroup = new LinkedList<Employe>();
        this.nbrEmploye++;
    }

    public double getSalaire() {
        return Salaire;
    }

    public void setSalaire(double salaire) {
        Salaire = salaire;
    }

    public LinkedList<Employe> getEmployeGroup() {
        return this.EmployeGroup;
    }

    public void setEmployeGroup(LinkedList<Employe> EmployeGroup) {
        this.EmployeGroup = EmployeGroup;
    }

    public static void SaveEmploye(LinkedList<Employe> E) {
        try {

            FileOutputStream file = new FileOutputStream("Employe.ser");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            //while(file.available() > 0) {e=(Employe)ois.readObject();}
            oos.writeObject(E);
            oos.flush();
            oos.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Employe> LoadEmploye() {
        LinkedList<Employe> e = null;
        try {
            e = new LinkedList<Employe>();

            FileInputStream file = new FileInputStream("Employe.ser");
            ObjectInputStream ois = new ObjectInputStream(file);

            e = (LinkedList<Employe>) ois.readObject();
            ois.close();

            //return e;
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            return e;
        }
    }

    public void addEmployeInGroup(Employe E) {
        if (EmployeGroup == null) {
            EmployeGroup = new LinkedList<Employe>();
        }
        EmployeGroup.add(E);
    }

    public void PrintEmployeGroup() {
        Iterator<Employe> it = this.EmployeGroup.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Override
    public String toString() {
        return "\nEmploye\n----------\n" + super.toString() + "\nSalaire		: " + Salaire;
    }

    @Override
    public void Print() {
        // TODO Auto-generated method stub
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        Employe e = (Employe) o;
        double res = this.Salaire - e.Salaire;
        if (res > 0) {
            return 1;
        } else if (res == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public Employe Search(String id) {

        for (Employe e : this.EmployeGroup) {
            if (e.getCode().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public Employe r_Search(String id, LinkedList<Employe> list) {

        if (!list.isEmpty()) {
            for (Employe x : list) {
                if (x.getNom().equals(id)) {
                    return x;
                } //else if(!x.EmployeGroup.isEmpty())  return r_Search(id, x.EmployeGroup);
                else if (!x.EmployeGroup.isEmpty()) {
                    for (Employe y : x.EmployeGroup) {
                        if (y.getNom().equals(id)) {
                            return y;
                        } else if (!y.EmployeGroup.isEmpty()) {
                            for (Employe z : y.EmployeGroup) {
                                if (z.getNom().equals(id)) {
                                    return z;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    
    }
    
    public void setAnonyme() {
        this.setCode("Anonyme");
        this.setNom("Anonyme");
        this.setPrenom("Anonyme");
        this.setAge(0);
        this.setSalaire(0);
    }
    
    public static boolean remove_employe(LinkedList<Employe> list, String id) {
        if (!list.isEmpty()) {
            for(Employe e : list) {
                if(e.getNom().equals(id)){
                    if(e.EmployeGroup.isEmpty()) {list.remove(e); return true;}
                    else e.setAnonyme();
                }
                else if (!e.EmployeGroup.isEmpty()) {
                    for(Employe x : e.EmployeGroup) {
                        if(x.getNom().equals(id)){
                            if(x.EmployeGroup.isEmpty()) {e.EmployeGroup.remove(x); return true;}
                            else x.setAnonyme();
                        }
                        else if (!x.EmployeGroup.isEmpty()) {
                            for(Employe y : x.EmployeGroup) {
                                if(y.getNom().equals(id)){
                                    if(y.EmployeGroup.isEmpty()){x.EmployeGroup.remove(y); return true;}
                                    else y.setAnonyme();
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
void add(DefaultMutableTreeNode defaultMutableTreeNode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}