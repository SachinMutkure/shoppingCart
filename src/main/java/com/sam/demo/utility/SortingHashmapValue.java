package com.sam.demo.utility;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** how to sort the value and key of hashmap 
 *  on basis of our customize sort method.
 * @author webwerks
 *
 */
public class SortingHashmapValue {

	public static boolean ASC = true;
    public static boolean DESC = false;
    
    public static void main(String[] args)
    {

        // Creating dummy unsorted map
        Map<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("B", 55);
        unsortMap.put("A", 80);
        unsortMap.put("D", 20);
        unsortMap.put("C", 70);

        System.out.println("Before sorting......");
        printMap(unsortMap);

        //Sorted Map by using value of the map
        System.out.println("After sorting ascending order......");
        Map<String, Integer> sortedMapAsc = sortByComparator(unsortMap, ASC);
        printMap(sortedMapAsc);


        System.out.println("After sorting descindeng order......");
        Map<String, Integer> sortedMapDesc = sortByComparator(unsortMap, DESC);
        printMap(sortedMapDesc);

        
        System.out.println("Sorting map by using the Key:");
        
        System.out.println("After sorting Ascending order:");
        Map<String, Integer> sortedMapAscBykey = sortByComparatorUsingKey(unsortMap, ASC);
        printMap(sortedMapAscBykey);
        
        System.out.println("After sorting Descending order:");
        Map<String, Integer> sortedMapDescBykey = sortByComparatorUsingKey(unsortMap, DESC);
        printMap(sortedMapDescBykey);
        
        
    }

    /** Method for sorted map by using Value **/
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
        	
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
            {
                if (order)
                {
                	//Ascending order sort
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                	//Descending order sort 
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    /** Method for Sorted Map by using key **/
    public static Map<String , Integer> sortByComparatorUsingKey(Map<String, Integer> unsortedMap, final boolean order){
    	
    	List<Entry<String, Integer>> list = new LinkedList<Entry<String,Integer>>(unsortedMap.entrySet());
    	
    	Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// TODO Auto-generated method stub
				if(order){
					// Ascending order
					return o1.getKey().compareTo(o2.getKey());
				}else{
					// Descending order
					System.out.println("Descending order:");
					return o2.getKey().compareTo(o1.getKey());				
				}				
			}
    		
		});
    	
    	Map<String, Integer> sortedMap = new HashMap<String, Integer>();
    	for(Entry<String, Integer> entry:list){
    		sortedMap.put(entry.getKey(), entry.getValue());
    	}    	
		return sortedMap;
    	
    }
    
    public static void printMap(Map<String, Integer> map)
    {
        for (Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}
