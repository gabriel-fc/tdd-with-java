package stringexercises;

import java.util.*;

public class WordCount {
    Map<String, Integer> map;

    public Set<Map.Entry<String, Integer>> count(String foo){
        IterableString iterableString = new IterableString(foo);
        Iterator it = iterableString.iterator();
        while(it.hasNext()){
            String key = ((String)it.next()).toLowerCase();
            if (map.containsKey(key)) map.replace(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        return map.entrySet();
    }

    public boolean contains(String word){
        return map.containsKey(word);
    }

    public int getIncidence(String word){
        if (contains(word)) return map.get(word);
        return 0;
    }

    public WordCount(){
        map = new HashMap<>();
    }



    private class IterableString implements Iterable<String>{
        private String string;

        public IterableString(String string){
            this.string = string;
        }

        @Override
        public Iterator<String> iterator() {
            return new WordCountIterator(string);
        }
    }

    private class WordCountIterator implements Iterator<String>{
        private String string;
        private int index;
        public WordCountIterator(String string){
            this.string = string;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return getNextValid(index) < string.length();
        }

        @Override
        public String next() {

            //if (!hasNext()) return "";
            int head = getNextValid(index), tale = getNextInvalid(head);
            index = tale;
            return string.substring(head, tale);
        }

        private int getNextValid(int i){
            while(!isValidIndex(i) && i < string.length()) i++;
            return i;
        }
        private int getNextInvalid(int i){
            while(isValidIndex(i)) i++;
            return i;
        }

        private boolean isValidIndex(int i){
            return i < string.length() && ((string.charAt(i) > 64 && string.charAt(i) < 91) ||
                    (string.charAt(i) > 96 && string.charAt(i) < 123));
        }
    }

}
