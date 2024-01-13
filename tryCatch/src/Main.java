import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sayilar = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Lütfen 1 ile 10 arasında yazdırmak istediğiniz elemanı giriniz");
        int secim = scanner.nextInt();

        try {
            System.out.println("Seçiminiz: " + sayilar[secim-1]);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}