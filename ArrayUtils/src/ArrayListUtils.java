import java.util.ArrayList;

public class ArrayListUtils {

//	Takes an ArrayList list of ordinary objects as one parameter
//	and some Object obj as the other parameter.  This method will
//	search list for all occurrences of obj and move them to the end
//	of the list without disrupting the order of the other elements.
	public static void moveToBack(ArrayList list, Object obj)
	{
//		for (int i = list.size() -1; i >=0; i--) {
//			if (list.get(i).equals(obj)){
//				list.add(list.remove(i));
//				i--;
//			}
//		}
		
		int counter = 0;
		for (int i = 0; i < list.size() - counter; i++){
			while (list.get(i).equals(obj)){
				counter++;
			}
			list.set(i, list.get(i+counter));		
		}
			
		for (int i = 0; i < counter; i++)
			list.add(obj);
		
	}
	
	
	
	public static void main(String[] args)
	{
	ArrayList<Integer> ints = new ArrayList<Integer>();
	//Set max to 10000000 for an efficiency check, or 100 for an accuracy check
	int max = 100;
	for (int i = 0; i < max; i++)
	{
	if (i % 5 == 0 || i % 17 == 0)
	ints.add(new Integer(1));
	else
	ints.add(new Integer(2));
	}
	long startTime = System.currentTimeMillis();
	ArrayListUtils.moveToBack(ints, new Integer(1));
	long totalTime = System.currentTimeMillis() - startTime;
	System.out.println("Total milliseconds for moveToBack is " + totalTime);
	boolean mistake = false;
	for (int i = 0; !mistake && i < max*6/10; i++)
	{
	if (ints.get(i).equals(new Integer(1)))
	mistake = true;
	}
	if (!mistake)
	System.out.println("Probably correct!");
	else
	System.out.println("Incorrect!");
	}
}
