import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Brand> brands = new ArrayList<>();

        brands.add(new Brand(1,"Samsung"));
        brands.add(new Brand(2,"Lenovo"));
        brands.add(new Brand(3,"Apple"));
        brands.add(new Brand(4,"Huawei"));
        brands.add(new Brand(5,"Casper"));
        brands.add(new Brand(6,"Asus"));
        brands.add(new Brand(7,"HP"));
        brands.add(new Brand(8,"Xiaomi"));
        brands.add(new Brand(9,"Monster"));

        brands.stream().sorted((object1, object2) -> object1.getName().compareTo(object2.getName()));

        List<NoteBook> noteBooks = new ArrayList<NoteBook>();

        noteBooks.add(new NoteBook("HUAWEI Matebook 14",7000.0,0.0,100,
                brands.stream().filter(brand -> brand.getName().equals("Huawei")).findFirst().orElse(null),
                16,14.0,512));

        noteBooks.add(new NoteBook("LENOVO V14 IGL",3699.0,0.0,150,
                brands.stream().filter(brand -> brand.getName().equals("Lenovo")).findFirst().orElse(null),
                8,14.0,1024));

        noteBooks.add(new NoteBook("ASUS Tuf Gaming",8199.0,0.0,200,
                brands.stream().filter(brand -> brand.getName().equals("Asus")).findFirst().orElse(null),
                32,15.6,2048));

        List<Phone> phones = new ArrayList<Phone>();

        phones.add(new Phone("SAMSUNG GALAXY A51",3199.0,0.0,100,
                brands.stream().filter(brand -> brand.getName().equals("Samsung")).findFirst().orElse(null),6,
                6.5,128,32,4000.0,"Siyah"));

        phones.add(new Phone("iPhone 11 64 GB",7370.0,0.0,150,
                brands.stream().filter(brand -> brand.getName().equals("Apple")).findFirst().orElse(null),6,
                6.1,64,5,3046.0,"Mavi"));

        phones.add(new Phone("Redmi Note 10 Pro 8GB",4012.0,0.0,200,
                brands.stream().filter(brand -> brand.getName().equals("Xiaomi")).findFirst().orElse(null),12,
                6.5,128,35,4000.0,"Beyaz"));






        boolean MainLoopBreak = true;
        while (MainLoopBreak){
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Çıkış Yap");

            System.out.println();

            int choice = scanner.nextInt();

            System.out.println();

            switch (choice){
                case 1:
                   NoteBook.notebookMenu(noteBooks,brands);
                    break;
                case 2:
                    Phone.phoneMenu(phones,brands);
                case 3:
                    MainLoopBreak = false;
                    break;

            }

        }

    }
}