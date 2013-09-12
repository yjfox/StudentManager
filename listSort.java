//********************************************************************
//	 listSort.java		Based on Lewis / Loftus
//	 Sorts arrays
//  Shell for Assignment 3
//********************************************************************

public class listSort
{
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	public static void maopaoSort(Comparable[] list)
	{
		Comparable temp;
		for(int i=0;i<list.length;i++)
		{
			int p=i;
			for(int j=i+1;j<list.length;j++)
			{
				if(list[i].compareTo(list[j])>0)
				{
					temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
	}
	public static void selectionSort(Comparable[] list)
	{
		int min;
		Comparable stuTemp;
		
		for(int i=0; i<list.length-1;i++)
		{
			min=i;
			for(int s=i+1;s<list.length;s++)
				if(list[s].compareTo(list[i])<0)
					min=s;
			stuTemp=list[min];
			list[min]=list[i];
			list[i]=stuTemp;
		}
	}
	public static void insertionSort(Comparable[] list)
	{
		for(int i=1;i<list.length;i++)
		{
			Comparable temp=list[i];
			int p=i;
			while(p>0&&temp.compareTo(list[p-1])<0)
			{
				list[p]=list[p-1];
				p--;
			}
			list[p]=temp;
		}
	}
		
} // end of listSort class 
//-----------------------------------------------------------------
