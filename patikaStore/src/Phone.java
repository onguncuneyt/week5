import java.util.List;

public class Phone extends Product{
    private int ram;
    private double screenSize;
    private int storage;
    private int camera;
    private double battery;
    private String color;

    public Phone(String name, double price, double discount, int stock, Brand brand,int ram,double screenSize,int storage,int camera,double battery,String color) {
        super(name, price, discount, stock, brand);

        this.ram = ram;
        this.screenSize = screenSize;
        this.storage = storage;
        this.camera=camera;
        this.battery=battery;
        this.color=color;
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

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void list() {

        System.out.format("%-9d%-25s%-15.2f%-11s%-15d%-11.1f%-15d%-12.1f%-11d%-12s",
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getBrand().getName(),
                this.getStorage(),
                this.getScreenSize(),
                this.getCamera(),
                this.getBattery(),
                this.getRam(),
                this.getColor()
        );

        System.out.println();


    }

    public static void addPhone(List<Phone> phones,List<Brand> brands) {
        String name,brand,color;
        int stock,ram,storage,camera;
        double price,discount,screenSize,battery;

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
            System.out.println("Kamera");
            camera = scanner.nextInt();
            System.out.println("Batarya");
            battery = scanner.nextDouble();
            System.out.println("Renk");
            scanner.nextLine();
            color = scanner.nextLine();

            String brandUpper = brand.substring(0, 1).toUpperCase() + brand.substring(1);

            phones.add(new Phone(name,price,discount,stock,
                    brands.stream().filter(b -> b.getName().equals(brandUpper)).findFirst().orElse(null),ram,
                    screenSize,storage,camera,battery,color));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
    public static void phoneMenu(List<Phone> phones,List<Brand> brands) {
        System.out.println("-----Telefon Menüsü-----");
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
                    System.out.format("%2s%15s%22s%15s%14s%12s%12s%12s%12s%12s","ID","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Kamera","Pil","Ram","Renk");
                    System.out.println();
                    phones.forEach(Phone::list);
                    System.out.println();
                    break;
                case 2:
                    addPhone(phones,brands);
                    break;
                case 3:
                    System.out.println("Lütfen silmek istediğiniz ürünün id'sini girin");
                    int choosedId = scanner.nextInt();
                    phones.removeIf(n->n.getId() == choosedId);
                    System.out.println();

                    System.out.format("%2s%15s%22s%15s%14s%12s%12s","ID","Ürün Adı","Fiyat","Marka","Depolama","Ekran","Ram");
                    System.out.println();
                    phones.forEach(Phone::list);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Lütfen filtrelemek istediğiniz markayı yazın");
                    scanner.nextLine();
                    String marka = scanner.nextLine();
                    String markaUpper = marka.substring(0, 1).toUpperCase() + marka.substring(1);

                    System.out.println();
                    List<Phone> filteredByBrand = phones.stream()
                            .filter(p -> p.getBrand().getName().equals(markaUpper)).toList();
                    filteredByBrand.forEach(Phone::list);
                    System.out.println();
                    break;
                case 5:
                    loopBreak = false;
                    break;

            }
        }

    }
}
