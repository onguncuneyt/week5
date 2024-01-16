import java.util.List;

public class NoteBook extends Product{

    private int ram;
    private double screenSize;
    private int storage;

    public NoteBook(String name, double price, double discount, int stock, Brand brand,int ram,double screenSize,int storage) {
        super( name, price, discount, stock, brand);

        this.ram = ram;
        this.screenSize = screenSize;
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }


    public void list() {

        System.out.format("%-9d%-25s%-15.2f%-11s%-15d%-14.1f%-7d",
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getBrand().getName(),
                this.getStorage(),
                this.getScreenSize(),
                this.getRam());

        System.out.println();


    }

    public static void addNotebook(List<NoteBook> noteBooks,List<Brand> brands) {
        String name,brand;
        int stock,ram,storage;
        double price,discount,screenSize;

        try{
            scanner.nextLine();
            System.out.println("Ürün adı");
            name = scanner.nextLine();
            System.out.println("Marka");
            brand = scanner.nextLine();
            System.out.println("Fiyat");
            price = scanner.nextDouble();
            System.out.println("İndirim Oranı");
            discount = scanner.nextDouble();
            System.out.println("Stok");
            stock = scanner.nextInt();
            System.out.println("Ram");
            ram = scanner.nextInt();
            System.out.println("Ekran Boyutu");
            screenSize = scanner.nextDouble();
            System.out.println("Depolama");
            storage = scanner.nextInt();

            String brandUpper = brand.substring(0, 1).toUpperCase() + brand.substring(1);

            noteBooks.add(new NoteBook(name,price,discount,stock,
                    brands.stream().filter(b -> b.getName().equals(brandUpper)).findFirst().orElse(null),
                    ram,screenSize,storage));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

    public static void notebookMenu(List<NoteBook> noteBooks,List<Brand> brands) {
        System.out.println("-----Notebook Menüsü-----");
        System.out.println("Lütfen aşağıdan yapmak istediğiniz işlemi seçin");
        boolean loopBreak = true;
        while (loopBreak){
            System.out.println("1 - Tüm Ürünleri Listele");
            System.out.println("2 - Ürün Ekle");
            System.out.println("3 - Ürün Sil");
            System.out.println("4 - Markaya Göre Listele");
            System.out.println("5 - Çıkış yap");
            int secim = scanner.nextInt();

            switch (secim){
                case 1:
                    System.out.format("%2s%15s%22s%15s%14s%12s%12s","ID","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Ram");
                    System.out.println();
                    noteBooks.forEach(NoteBook::list);
                    System.out.println();
                    break;
                case 2:
                    addNotebook(noteBooks,brands);
                    break;
                case 3:
                    System.out.println("Lütfen silmek istediğiniz ürünün id'sini girin");
                    int choosedId = scanner.nextInt();
                    noteBooks.removeIf(n->n.getId() == choosedId);
                    System.out.println();

                    System.out.format("%2s%15s%22s%15s%14s%12s%12s","ID","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Ram");
                    System.out.println();
                    noteBooks.forEach(NoteBook::list);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Lütfen filtrelemek istediğiniz markayı yazın");
                    scanner.nextLine();
                    String marka = scanner.nextLine();
                    String markaUpper = marka.substring(0, 1).toUpperCase() + marka.substring(1);
                    System.out.println();
                    List<NoteBook> filteredByBrand = noteBooks.stream()
                            .filter(n -> n.getBrand().getName().equals(markaUpper)).toList();
                    filteredByBrand.forEach(NoteBook::list);
                    System.out.println();
                    break;
                case 5:
                    loopBreak = false;
                    break;

            }
        }

    }
}
