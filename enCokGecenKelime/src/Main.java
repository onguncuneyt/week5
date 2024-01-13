import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String,Integer> words = new HashMap<String, Integer>();


        System.out.println("Lütfen metni girin");
        String metin = scanner.nextLine().toLowerCase();

        String[] parts = metin.split("[\\s\\p{Punct}]+");

        for (String w:parts) {
            if (words.containsKey(w)){
                words.put(w,words.get(w)+1);
            }else{
                words.put(w,1);
            }
        }

        String dpWord = Collections.max(words.entrySet(), Map.Entry.comparingByValue()).getKey();
        int num = Collections.max(words.entrySet(), Map.Entry.comparingByValue()).getValue();

        System.out.println("Metinde en çok tekrar eden kelime " + dpWord + ". " +num+" kere tekrar ediyor");


    }
}