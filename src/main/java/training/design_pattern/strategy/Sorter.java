package training.design_pattern.strategy;

public class Sorter
{
	private Sort sort;

	/*
	 * parameterloser Konstruktor hier nicht sinnvoll
	 */	
	
	public Sorter(Sort sort) 
	{
		this.sort = sort;
	}

	
	public Sort getSort() {
		return this.sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
	public void sort()
	{
		this.sort.sort(); // hier Polymorphie --> Quicksort, BubbleSort, ... -Object
	}
	
}
