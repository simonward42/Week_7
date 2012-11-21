import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sward09
 */
public class MyList {
    private List<Integer> list;
    public MyList() {
        list = new ArrayList();
    } 
    public MyList(List<Integer> list) {
        this.list = new ArrayList(list);
    }
    public void add(Integer element) {
        list.add(element);
    }
    public Integer get(int index) {
        return list.get(index);
    }
    public Integer remove(int index) {
        return list.remove(index);
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public void addAll(MyList addList) {
        for(int i=0; i<addList.size(); i++)  {
            list.add(addList.get(i));
        }
    }
    public boolean binarySearch(Integer element) {
            if(list.isEmpty()) 
                return false;
            int midIndex = (int) list.size() / 2;
            if(element == list.get(midIndex))
                return true;
            else if(element < list.get(midIndex)) {
                MyList lowerHalf = new MyList(list.subList(0, midIndex));
                return lowerHalf.binarySearch(element);
            }
            else {
                MyList higherHalf = new MyList(list.subList(midIndex, list.size() - 1));
                return higherHalf.binarySearch(element);
            }
    }
    public MyList mergesort() {
        MyList result;
        if((list.size() == 0) || (list.size() == 1)) {
            result = new MyList(list);
            return result;
        }
        result = new MyList();
        int midIndex = (int) list.size() / 2;
        MyList firstHalf = new MyList(list.subList(0, midIndex));
        MyList secondHalf = new MyList(list.subList(midIndex, list.size()-1));
        firstHalf = firstHalf.mergesort();
        secondHalf = secondHalf.mergesort();
        
        while(!firstHalf.isEmpty() && !secondHalf.isEmpty())
            if(firstHalf.get(0) < secondHalf.get(0))  
                result.add(firstHalf.remove(0)); 
            else
                result.add(secondHalf.remove(0));
        while(!firstHalf.isEmpty())
            result.add(firstHalf.remove(0));
        while(!secondHalf.isEmpty()) 
            result.add(secondHalf.remove(0));
        return result;
    }
    public MyList quicksort() {
        // Initial action:
        MyList result;
        if((list.size() == 0) || (list.size() == 1)) {
            result = new MyList(list);
            return result;
        }
        result = new MyList();
        Integer pivot = list.remove(0);
        
        // Subproblem:
        MyList lower = new MyList();
        MyList higher = new MyList();
        while(!list.isEmpty()) {
            if(list.get(0) <= pivot) {
                lower.add(list.remove(0));
            }
            else {
                higher.add(list.remove(0));
            }
        }
        lower = lower.quicksort();
        higher = higher.quicksort();
        
        // Integration:
        result.addAll(lower);
        result.add(pivot);
        result.addAll(higher);
        return result;
    }
}
