package training.design_pattern.strategy;

public class Test {

	public static void main(String[] args) 
	{
		// Verhalten "Umschalten" durch neues Objekt
		
		Sorter sorter = new Sorter(new BubbleSort());
		sorter.sort();
		sorter.setSort(new QuickSort());
		sorter.sort(); // QuickSort ...
		
		
				
		
	}

}
