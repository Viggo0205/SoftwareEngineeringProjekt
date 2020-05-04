
public class DiverseTest {

	public static void main(String[] args) {
		/*
		System.out.println(new Dato(1,1,2019).getDeltaDag(new Dato(1,7,2020)));
		System.out.println(new Dato(1,7,2020).getDeltaDag(new Dato(1,1,2020)));
		System.out.println(new Dato(1,3,2020).getDeltaDag(new Dato(1,3,2021)));
		System.out.println(new Dato(1,1,2020).getDeltaDag(new Dato(1,1,2021)));
		System.out.println(new Dato(1,1,2021).getDeltaDag(new Dato(1,1,2020)));
		System.out.println(new Dato(1,1,2019).getDeltaDag(new Dato(1,7,2020)));
		System.out.println(new Dato(1,7,2019).getDeltaDag(new Dato(1,7,2020)));
		System.out.println(new Dato(1,1,2019).getDeltaDag(new Dato(1,7,2019)));
		System.out.println(new Dato(1,1,2021).getDeltaDag(new Dato(1,1,2020)));
		System.out.println(new Dato(1,1,2020).getDeltaDag(new Dato(1,7,2020)));
		System.out.println(new Dato(1,1,2020).getDeltaDag(new Dato(4,1,2020)));
		
		System.out.println(new Dato(7,1,2020).beregnUge());
		System.out.println(new Dato(8,1,2020).beregnUge());
		
		System.out.println(new Dato(4,2020).getFormatedDate());
		System.out.println(new Dato(4,2020).beregnUge());
		
		for (int i = 1; i < 12; i++)
			System.out.println(new Dato(i, 2020).getFormatedDate());
		System.out.println(new Dato(9, 2020).getFormatedDate());
		System.out.println(new Dato(26, 2, 2020).getFormatedDate());
		for (int i = 1; i < 30; i++)
			System.out.println(new Dato(1, 1, 2020).getDeltaDag(new Dato(i, 2, 2020)));
		System.out.println(new Dato(26, 2, 2020).beregnUge());
		System.out.println(57 / 7);
		
		System.out.println(new Dato(34, 2020).beregnUge());
		System.out.println(new Dato(52, 2020).beregnUge());
		System.out.println(new Dato(1, 1, 2020).getDeltaDag(new Dato(34, 2020)));
		System.out.println(new Dato(1, 1, 2020).getDeltaDag(new Dato(52, 2020)));
		System.out.println(new Dato(34, 2020).getFormatedDate());
		System.out.println(new Dato(52, 2020).getFormatedDate());
		*/
		/*
		for (int i = 1; i < 53; i++)
		{
			System.out.println(new Dato(i, 2020).beregnUge());
			System.out.println(new Dato(i, 2020).getFormatedDate());
			System.out.println(new Dato(1, 1, 2020).getDeltaDag(new Dato(i, 2020)));
		}
		*/
		
		Arbejdsdag test = new Arbejdsdag(new Dato(1, 1, 2020));
		test.addTid("TestProj1", "TestAkt1.1", 3);
		test.addTid("TestProj1", "TestAkt1.2", 2);
		test.addTid("TestProj1", "TestAkt1.3", 1);
		test.addTid("TestProj2", "TestAkt2.1", 5);
		System.out.println(test.getTid());
	}

}
