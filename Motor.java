public class Motor {
    private String merk;
    private String tipe;
    private int tahun;

    // properti tambahan untuk kebutuhan sewa
    private boolean tersedia;
    private int hargaPerHari;

    public Motor() {
        System.out.println("Data motor baru dibuat");
        this.tersedia = true;
        this.hargaPerHari = 100_000;
    }

    public Motor(String merk, String tipe, int tahun) {
        this.merk = merk;
        this.tipe = tipe;
        this.tahun = tahun;
        this.tersedia = true;
        this.hargaPerHari = hitungHargaPerHari();
    }

    private int hitungHargaPerHari() {
        int base = 150_000;
        int bonusTahun = (tahun - 2020) * 25_000;
        return Math.max(100_000, base + bonusTahun);
    }

    public String getMerk() {
        return merk;
    }

    public String getTipe() {
        return tipe;
    }

    public int getTahun() {
        return tahun;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public int getHargaPerHari() {
        return hargaPerHari;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
        this.hargaPerHari = hitungHargaPerHari();
    }

    public void info() {
        System.out.println(detail());
    }

    public String detail() {
        return "Motor{" +
                "merk='" + merk + '\'' +
                ", tipe='" + tipe + '\'' +
                ", tahun=" + tahun +
                ", tersedia=" + tersedia +
                ", hargaPerHari=" + hargaPerHari +
                '}';
    }

    @Override
    public String toString() {
        return detail();
    }
}



class MainMotor {
    public static void main(String[] args) {

        Motor motor1 = new Motor();
        motor1.setMerk("Honda");
        motor1.setTipe("Vario 160");
        motor1.setTahun(2024);
        motor1.info();

        Motor motor2 = new Motor();
        motor2.setMerk("Yamaha");
        motor2.setTipe("NMAX");
        motor2.setTahun(2023);
        motor2.info();

        Motor motor3 = new Motor();
        motor3.setMerk("Suzuki");
        motor3.setTipe("Satria F150");
        motor3.setTahun(2022);
        motor3.info();
    }
}
