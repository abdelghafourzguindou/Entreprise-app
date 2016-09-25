
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;


public class Credit implements Serializable {
	
	public double Amount;
	public int Mensuality;
        public int Num;
        public String client;
        public String produit;
        public double payee;
        public double credit;
        public static int nbrCredit = 0;
	
	public Credit(int amount) {
		// TODO Auto-generated constructor stub
		this.Amount     = amount;
		this.Mensuality = 0;
	}
        
        public Credit(String c, String p, double pr, double cr) {
            this.client = c;
            this.produit = p;
            this.payee = pr;
            this.credit = cr;
            this.Num = nbrCredit++;
        }

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount += amount;
	}

	public int getMensuality() {
		return Mensuality;
	}

	public void setMensuality(int mensuality) {
		Mensuality -= mensuality;
	}
	
	public boolean isReimbursed() {
		if(this.Mensuality == 0) return true;
		return false;
	}
	
        public static void SaveCredit(LinkedList<Credit> E) {
        try {

            FileOutputStream file = new FileOutputStream("Credit.ser");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            //while(file.available() > 0) {e=(Employe)ois.readObject();}
            oos.writeObject(E);
            oos.flush();
            oos.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Credit> LoadCredit() {
        LinkedList<Credit> e = null;
        try {
            e = new LinkedList<Credit>();

            FileInputStream file = new FileInputStream("Credit.ser");
            ObjectInputStream ois = new ObjectInputStream(file);

            e = (LinkedList<Credit>) ois.readObject();
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

    public static Credit SearchCredit(LinkedList<Credit> list, int num) {
        for(Credit x : list){
            if(x.Num == num) return x;
        }
        return null;
    }
    
}
