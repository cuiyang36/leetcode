package Exercise;

import java.util.ArrayList;

    //public interface Intervals {
    /**
     * Adds an interval [from, to] into internal structure.
     */
    //void addInterval(int from, int to);
    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
     * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
     *
     */
    //int getTotalCoveredLength();


public class AddIntervals {
	
	public class Interval{
		
		public int start;
		public int end;
		public int getLength(){
			return end - start;
		}
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	private ArrayList<Interval> list;
	
	public AddIntervals(){
		list = new ArrayList<Interval>();
	}
	
	public void addInterval(int from, int to){
		Interval insert = new Interval(from, to);
		ArrayList<Interval> newList = new ArrayList<Interval>();
		int index = 0;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).end < insert.start){
				newList.add(list.get(i));
				index = i + 1;
			}else if (list.get(i).start > insert.end){
				newList.add(list.get(i));
			}else{
				insert.start = Math.min(list.get(i).start, insert.start);
				insert.end = Math.max(list.get(i).end, insert.end);
			}
		}
		newList.add(index, insert);
		list = newList;
	}
	
	public int getTotalCoveredLength(){
		int rst = 0;
		for (Interval i: list){
			rst += i.getLength();
		}
		return rst;
	}
	
	public static void main(String[] args){
		AddIntervals a = new AddIntervals();
		a.addInterval(3, 6);
		a.addInterval(8, 9);
		a.addInterval(1, 5);
		int rst = a.getTotalCoveredLength();
		System.out.println(rst);
	}

}
