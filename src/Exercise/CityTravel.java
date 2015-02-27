package Exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * give several cities and lots of flight tickets that transfer between cities,
 * give rst about planing a round city trip
 * 
 * @author cuiyang36
 *
 */

public class CityTravel {
	
	public static class City{
		String tag;
		City(String tag){
			this.tag = tag;
		}
	}

	public static class Ticket{
		City from;
		City to;
		Ticket(City from, City to){
			this.from = from;
			this.to = to;
		}
	}
	
	public static List<List<City>> cityTravel(List<City> cities, List<Ticket> tickets){
		if (cities == null || tickets == null){
			return null;
		}
		List<List<City>> rst = new ArrayList<List<City>>();
		List<City> solution = new ArrayList<City>();
		Set<String> set = new HashSet<String>();
		cityTravelHelper(rst, solution, tickets, cities, set);
		return rst;
	}
	
	private static void cityTravelHelper(List<List<City>> rst, List<City> solution, List<Ticket> tickets, List<City> cities, Set<String> set){
		for (int i = 0; i < tickets.size(); i++){
			if (solution.size() == cities.size() && solution.get(solution.size() - 1).tag.equals(tickets.get(i).from.tag) && tickets.get(i).to.tag.equals(solution.get(0).tag)){
				solution.add(tickets.get(i).to);
				rst.add(new ArrayList<City>(solution));
				solution.remove(solution.size() - 1);
				return;
			}else if (set.isEmpty()){
				solution.add(tickets.get(i).from);
				solution.add(tickets.get(i).to);
				set.add(tickets.get(i).from.tag);
				set.add(tickets.get(i).to.tag);
				cityTravelHelper(rst, solution, tickets, cities, set);
				set.remove(tickets.get(i).to.tag);
				set.remove(tickets.get(i).from.tag);
				solution.remove(solution.size() - 1);
				solution.remove(solution.size() - 1);
			}else{
				if ((set.contains(tickets.get(i).to.tag) || !tickets.get(i).from.tag.equals(solution.get(solution.size() - 1).tag))){
					continue;
				}
				solution.add(tickets.get(i).to);
				set.add(tickets.get(i).to.tag);
				cityTravelHelper(rst, solution, tickets, cities, set);
				set.remove(tickets.get(i).to.tag);
				solution.remove(solution.size() - 1);
			}
		}
	}
	
	
	public static void main(String[] args){
		City A = new City("A");
		City B = new City("B");
		City C = new City("C");
		City D = new City("D");
		City E = new City("E");
		City F = new City("F");
		Ticket AB = new Ticket(A, B);
		Ticket BF = new Ticket(B, F);
		Ticket CA = new Ticket(C, A);
		Ticket AD = new Ticket(A, D);
		Ticket BC = new Ticket(B, C);
		Ticket DC = new Ticket(D, C);
		Ticket EB = new Ticket(E, B);
		Ticket ED = new Ticket(E, D);
		Ticket EC = new Ticket(E, C);
		Ticket FE = new Ticket(F, E);
		List<Ticket> input = new ArrayList<Ticket>();
		input.add(AB);
		input.add(BF);
		input.add(CA);
		input.add(AD);
		input.add(BC);
		input.add(DC);
		input.add(EB);
		input.add(ED);
		input.add(EC);
		input.add(FE);
		List<City> cities = new ArrayList<City>();
		cities.add(A);
		cities.add(B);
		cities.add(C);
		cities.add(D);
		cities.add(E);
		cities.add(F);
		List<List<City>> rst = cityTravel(cities, input);
		for (List<City> list: rst){
			System.out.println();
			for (City c: list)
			System.out.print(c.tag + " ");
		}
	}
}
