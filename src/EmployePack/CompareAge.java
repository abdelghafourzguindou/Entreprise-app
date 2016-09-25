import java.util.Comparator;


public class CompareAge implements Comparator<Employe> {

	public CompareAge() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Employe e1, Employe e2) {
		// TODO Auto-generated method stub
		if(e1.getAge() > e2.getAge()) return 1;
		else if(e1.getAge() < e2.getAge()) return -1;
		else return 0;
	}

}
