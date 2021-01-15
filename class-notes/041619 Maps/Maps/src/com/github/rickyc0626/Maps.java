package com.github.rickyc0626;

import java.util.*;

public class Maps
{
    public static void mapTest()
    {
        Map<String, String> phonebook = new TreeMap<>();

        // is this person in my phonebook?
        System.out.println(phonebook.containsKey("name"));

        // is this number in my phonebook?
        System.out.println(phonebook.containsValue(123));

        // print the book
        for(Map.Entry<String, String> e : phonebook.entrySet())
        {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        // what is bob's phone number?
        System.out.println(phonebook.get("Bob"));

        // returns default value if key does not contain value
        String n = phonebook.getOrDefault("Bob", "999999999");

        // only works if null is not a legal value
        String m = phonebook.get("Bob");
        if(m == null) m = "999999999";

        // twice as long as getOrDefault()
        String o = phonebook.containsKey("Bob") ? phonebook.get("Bob") : "999999999";

        // print out all names in phonebook
        for(String k : phonebook.keySet())
        {
            System.out.println(k);
        }

        // add new contact
        phonebook.put("Jane", "2352345");

        // update Jane's number
        String oldNumber = phonebook.put("Jane", "46094864");

        // add new contact, but do not overwrite if they're already in the phonebook
        phonebook.putIfAbsent("Jane", "7509854");

        /* overwrite phone number if contact is already in phonebook,
           but do not add if they're not already in

           putIfAbsent + replace = put
         */
        phonebook.replace("Jane", "46564345");

        if(!phonebook.containsKey("Jane")) phonebook.put("Jane", "35344536");

        // remove Jane from phonebook
        phonebook.remove("Jane");

        // print out all phone numbers in map
        for(String v : phonebook.values())
        {
            System.out.println(v);
        }

        // map course names to how many students are enrolled
        Map<String, Integer> courseMap = new TreeMap<>();

        // insert a new course into courseMap. If it's already in the map,
        // update its value.
        Integer previous = courseMap.put("CISC.3130", 40);
        // how many people were in it previously?
        System.out.println(previous);

        // remove CISC 2210 from map
        courseMap.remove("CISC.2210");

        // print out a list of courses
        for(String k : courseMap.keySet())
        {
            System.out.println(k);
        }

        // find average enrollment per class
        Collection<Integer> c = courseMap.values();
        int sum = 0;
        for(Integer v : c)
        {
            sum += v;
        }
        float average = sum / c.size();

        // how many students are enrolled in 3620
        int e = courseMap.get("CISC.3620");

        // is 3115 listed in the map?
        boolean listed = courseMap.containsKey("CISC.3115");

        // find which courses have fewer than 15 students enrolled
        List<String> tooLow = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : courseMap.entrySet())
        {
            if(entry.getValue() < 15) tooLow.add(entry.getKey());
        }
    }

    // count words
    public static Map<String, Integer> countWords(List<String> document)
    {
        Map<String, Integer> m = new TreeMap<>();
        for(String w : document)
        {
            Integer count = m.get(w);

            if(count == null) m.put(w, 1);
            else m.put(w, count + 1);
        }
        return m;
    }

    // concordance
    public static Map<String, Set<Integer>> buildConcordance(List<String> document)
    {
        Map<String, Set<Integer>> m = new TreeMap<>();
        int index = 0;
        for(String w : document)
        {
            m.putIfAbsent(w, new TreeSet<>());
            m.get(w).add(index);
            index++;
        }
        return m;
    }

    public static void printConcordance(Map<String, Set<Integer>> c)
    {
        for(Map.Entry<String, Set<Integer>> e : c.entrySet())
        {
            System.out.println(e.getKey() + "\t");

            for(Integer i : e.getValue())
            {
                System.out.print(i + ", ");
            }
        }
    }

    public static Map<String, Boolean> multipleWords(List<String> words)
    {
        Map<String, Boolean> m = new TreeMap<>();
        for(String s : words)
        {
            if(m.containsKey(s))
                m.put(s, true);
            else
                m.put(s, false);
        }
        return m;
    }

    public <E> List<E> highestGPA(Set<E> awarded, List<E> highGPA)
    {
        List<E> awardees = new ArrayList<>();

        for(E e : highGPA)
        {
            if(!awarded.contains(e)) awardees.add(e);
        }
        return awardees;
    }

    public static String[] swap(String[] strings)
    {
        Map<Character, Integer> m = new TreeMap<>();
        for(int i = 0; i < strings.length; i++)
        {
            char c = strings[i].charAt(0);
            Integer index = m.get(c);
            if(index == null)
                m.put(c, i);
            else
            {
                String temp = strings[i];
                strings[i] = strings[index];
                strings[index] = temp;
                m.remove(c);
            }
        }
        return strings;
    }

    // given a map: if exactly one of the keys "a" or "b" has a
    // value in the map (but not both), set the other to have
    // the same value in the map
    public void sameValues(Map<String, String> m)
    {
        String aval = m.get("a");
        if(aval != null) m.putIfAbsent("b", aval);
        else
        {
            String bval = m.get("b");
            if(bval != null) m.put("a", bval);
        }
    }

    public static void main(String[] args)
    {
        String test = "(4-16)";
        test.replace("(", "");
        test.replace(")", "");
        String[] arr = test.split("-");
        int parent = Integer.valueOf(arr[0]);
        int child = Integer.valueOf(arr[1]);
    }
}
