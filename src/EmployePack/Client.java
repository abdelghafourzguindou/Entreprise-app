import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;


public class Client extends Person implements Comparable {
	
	public String DomInter;
	public static int nbrClient = 0;
	public LinkedList<Credit> ListCredit = new LinkedList<Credit>();
       
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(String Code, String Nom, String Prenom, int Age, String DomInter) {
		// TODO Auto-generated constructor stub
		super(Code, Nom, Prenom, Age);
		this.DomInter = DomInter;
		this.nbrClient++;
	}

	public String getDomInter() {
		return DomInter;
	}

	public void setDomInter(String domInter) {
		DomInter = domInter;
	}

	@Override
	public String toString() {
		return  "\nClient\n----------\n" + super.toString() + "\nDomInter	: " + DomInter;
	}
	
	public void Achat(int prix) {
		Credit newCr = new Credit(prix); 
		ListCredit.add(newCr);
	}
	
	public void Paye(int prix) {
		ListCredit.get(0).setAmount(prix);
	}
	
	@Override
	public void Print() {
		// TODO Auto-generated method stub
		System.out.println(this.toString());
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Client c = (Client)o;
		int lastCmp = this.getNom().compareTo(c.getNom());
		if(lastCmp == 0)
			lastCmp = this.getPrenom().compareTo(c.getPrenom());
		return lastCmp;
        }
        
        public static Client SearchClient(LinkedList<Client> ClientList, String thiscode) throws MyException{
            
            Client x = null;
            for(Client c : ClientList)
            {
                if(c.getCode().equals(thiscode)) x = c;
            }
            //if(x==null)throw new MyException("Client n'exist pas");
            return x;
        }
	
        
    public static void SaveClient(LinkedList<Client> E) {
        try {

            FileOutputStream file = new FileOutputStream("Client.ser");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            //while(file.available() > 0) {e=(Employe)ois.readObject();}
            oos.writeObject(E);
            oos.flush();
            oos.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Client> LoadClient() {
        LinkedList<Client> e = null;
        try {
            e = new LinkedList<Client>();

            FileInputStream file = new FileInputStream("Client.ser");
            ObjectInputStream ois = new ObjectInputStream(file);

            e = (LinkedList<Client>) ois.readObject();
            ois.close();

            //return e;
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }finally {
            return e;
        }
    }

}
