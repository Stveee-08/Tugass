import java.util.ArrayList;
import java.util.List;

public class SewaMotorApp {

    public static void main(String[] args) {
        PenyewaanSewaMotor sewa = new PenyewaanSewaMotor();

        // Data motor tersedia
        sewa.tambahMotor(new Motor("Honda", "Vario 160", 2024));
        sewa.tambahMotor(new Motor("Yamaha", "NMAX", 2023));
        sewa.tambahMotor(new Motor("Suzuki", "Satria F150", 2022));

        System.out.println("=== DAFTAR MOTOR SEWA ===");
        sewa.tampilkanSemuaMotor();

        // Contoh transaksi sewa
        System.out.println("\n=== TRANSAKSI SEWA ===");
        Transaksi t1 = sewa.sewaMotor(0, 3); // motor index 0 disewa 3 hari
        System.out.println(t1);

        Transaksi t2 = sewa.sewaMotor(1, 5);
        System.out.println(t2);

        System.out.println("\n=== STATUS MOTOR ===");
        sewa.tampilkanSemuaMotor();
    }
}

class PenyewaanSewaMotor {

    private final List<Motor> daftarMotor = new ArrayList<>();

    public void tambahMotor(Motor motor) {
        daftarMotor.add(motor);
    }

    public void tampilkanSemuaMotor() {
        for (int i = 0; i < daftarMotor.size(); i++) {
            Motor m = daftarMotor.get(i);
            System.out.println("[" + i + "] " + m.detail());

        }
    }

    public Transaksi sewaMotor(int index, int jumlahHari) {
        if (index < 0 || index >= daftarMotor.size()) {
            throw new IllegalArgumentException("Index motor tidak valid.");
        }
        if (jumlahHari <= 0) {
            throw new IllegalArgumentException("Jumlah hari harus lebih dari 0.");
        }

        Motor motor = daftarMotor.get(index);
        if (!motor.isTersedia()) {
            throw new IllegalStateException("Motor sedang tidak tersedia.");
        }

        int total = motor.getHargaPerHari() * jumlahHari;
        motor.setTersedia(false);
        return new Transaksi(motor, jumlahHari, total);
    }
}

class Transaksi {
    private final Motor motor;
    private final int jumlahHari;
    private final int totalBiaya;

    public Transaksi(Motor motor, int jumlahHari, int totalBiaya) {
        this.motor = motor;
        this.jumlahHari = jumlahHari;
        this.totalBiaya = totalBiaya;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "motor=" + motor.detail() +
                ", jumlahHari=" + jumlahHari +
                ", totalBiaya=" + totalBiaya +
                '}';
    }
}

