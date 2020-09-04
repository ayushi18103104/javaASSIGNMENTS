import java.util.*;
public class solution{
    public static void main(String[] args)
{
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the maximum limit for the universe starting from 0: ");
        int universe_max = obj.nextInt();

        System.out.print("Enter no of elements in set a and b: ");
        int a = obj.nextInt(), b = obj.nextInt();

        ArrayList<Integer> a1 = new ArrayList<Integer>(), a2 = new ArrayList<Integer>();

        System.out.println("Given elements to add in set (Anything outside universe will be replaced by 0): ");
        ArrayList<Integer> universe = new ArrayList<Integer>();
        for(int i=0;i<=universe_max;i++){
            System.out.print(i+" ");
            universe.add(i);
        }
        System.out.println();

        System.out.print("Enter elements of set a: ");
        int temp;
        boolean is_present;
        for(int i=0;i<a;i++)
           {
            temp = obj.nextInt();
            if(temp<0 || temp>universe_max)
           {
                temp = 0;
            }
            is_present = false;
            for(int j=0;j<a1.size();j++){
                if(a1.get(j)==temp){
                    is_present = true;
                }
            }
            if(!is_present){
                a1.add(temp);
            }
        }

        System.out.print("Enter elements of set b: ");
        for(int i=0;i<b;i++){
            temp = obj.nextInt();
            if(temp<0 || temp>universe_max){
                temp = 0;
            }
            is_present = false;
            for(int j=0;j<a2.size();j++){
                if(a2.get(j)==temp){
                    is_present = true;
                }
            }
            if(!is_present){
                a2.add(temp);
            }
        }

 // Using Arrays
        System.out.println("\nUsing Arrays");

// Union
        long start_time = System.nanoTime();
        ArrayList<Integer> union = new ArrayList<Integer>();
        for(int i=0;i<a1.size(); i++){
            is_present = false;
            for(int j=0;j<union.size();j++){
                if(a1.get(i)==union.get(j)){
                    is_present = true;
                    break;
                }
            }
            if(!is_present){
                union.add(a1.get(i));
            }
        }
        for(int i=0;i<a2.size(); i++){
            is_present = false;
            for(int j=0;j<union.size();j++){
                if(a2.get(i)==union.get(j)){
                    is_present = true;
                    break;
                }
            }
            if(!is_present){
                union.add(a2.get(i));
            }
        }
        System.out.print("Union of a and b: ");
        for(int i=0;i<union.size();i++){
            System.out.print(union.get(i)+" ");
        }
        System.out.println("");
        long time_dur = System.nanoTime() - start_time;
        System.out.println("Time for union with arrays: " + time_dur);

// Intersection
        start_time = System.nanoTime();
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for(int i=0;i<a1.size(); i++){
            is_present = false;
            for(int j=0;j<a2.size();j++){
                if(a1.get(i)==a2.get(j)){
                    is_present = true;
                    break;
                }
            }
            if(is_present){
                intersection.add(a1.get(i));
            }
        }
        System.out.print("\nIntersection of a and b: ");
        for(int i=0;i<intersection.size();i++){
            System.out.print(intersection.get(i)+" ");
        }
        System.out.println("");
        time_dur = System.nanoTime() - start_time;
        System.out.println("Time for intersection with arrays: " + time_dur);

// Set Difference
        start_time = System.nanoTime();
        ArrayList<Integer> difference1 = new ArrayList<Integer>();
        for(int i=0;i<universe.size(); i++){
            is_present = false;
            for(int j=0;j<a1.size();j++){
                if(a1.get(j)==universe.get(i)){
                    is_present = true;
                    break;
                }
            }
            if(!is_present){
                difference1.add(universe.get(i));
            }
        }
        System.out.print("\nSet difference of a: ");
        for(int i=0;i<difference1.size();i++){
            System.out.print(difference1.get(i)+" ");
        }
        System.out.println("");

        ArrayList<Integer> diff2 = new ArrayList<Integer>();
        for(int i=0;i<universe.size(); i++){
            is_present = false;
            for(int j=0;j<a2.size();j++){
                if(a2.get(j)==universe.get(i)){
                    is_present = true;
                    break;
                }
            }
            if(!is_present){
                diff2.add(universe.get(i));
            }
        }
        System.out.print("Set difference of b: ");
        for(int i=0;i<diff2.size();i++){
            System.out.print(diff2.get(i)+" ");
        }
        System.out.println("");
        time_dur = System.nanoTime() - start_time;
        System.out.println("Time for union with arrays: " + time_dur);

 // Using sets
        System.out.println("\n\nUsing sets");
        Set<Integer> universe_set = new HashSet<Integer>(), s1 = new HashSet<Integer>(), s2 = new HashSet<Integer>();
        universe_set.addAll(universe);
        s1.addAll(a1);
        s2.addAll(a2);

        // Union
        start_time = System.nanoTime();
        Set<Integer> union_set = new HashSet<Integer>(a);
        union_set.addAll(s2);
        System.out.print("\nUnion of a and b: ");
        System.out.println(union);
        time_dur = System.nanoTime() - start_time;
        System.out.println("Time for union with sets: " + time_dur);

// Intersection
        start_time = System.nanoTime();
        Set<Integer> intersection_set = new HashSet<Integer>(a);
        union_set.retainAll(s2);
        System.out.print("\nIntersection of a and b: ");
        System.out.println(intersection);
        time_dur = System.nanoTime() - start_time;
        System.out.println("Time for intersection with sets: " + time_dur);

// Set Difference
        start_time = System.nanoTime();
        Set<Integer> difference1_set = new HashSet<Integer>(universe_set), difference2_set = new HashSet<Integer>(universe_set);
        difference1_set.removeAll(s1);
        System.out.print("\nSet difference of a");
        System.out.println(difference1_set);

        difference2_set.removeAll(s2);
        System.out.print("Set difference of b");
        System.out.println(difference2_set);
        time_dur = System.nanoTime() - start_time;
        System.out.println("Time for set difference with sets: " + time_dur);

// Result
        System.out.println("Time Complexity of sets < Time Complexity of arrays");
    }
}
