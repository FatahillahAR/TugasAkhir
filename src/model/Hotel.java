package model;

import entity.Kamar;
import entity.Reservasi;
import entity.Staff;
import entity.Tamu;
import util.DateString;

import java.util.ArrayList;
public class Hotel {
    public static ArrayList<Kamar> daftarKamar = new ArrayList<>();
    public static ArrayList<Staff> daftarStaff = new ArrayList<>();
    public static ArrayList<Staff> daftarAdmin = new ArrayList<>();

    public static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();

    public static void initialData(){
        initalAdmin();
        initalStaff();
        initialKamar();
    }

    public static void initialKamar() {
        daftarKamar.add(new Kamar("11", "Single Bed", 400000, true));
        daftarKamar.add(new Kamar("12", "Single Bed", 400000, true));
        daftarKamar.add(new Kamar("13", "Double Bed", 600000, true));
        daftarKamar.add(new Kamar("14", "Triple Bed", 820000, true));
    }

    public static void initalStaff() {
        daftarStaff.add(new Staff("Renal", "123", "111"));
        daftarStaff.add(new Staff("Oke", "65", "12"));
    }

    public static void initalAdmin() {
        daftarAdmin.add(new Staff("Renal", "07418", "111"));
    }

    public static Kamar cariKamar(String kode) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.kodeKamar.equals(kode)) {
                return kamar;
            }
        }
        return null;
    }

    private static void updateStatusKamar(Kamar kamar, boolean status) {
        for (Kamar kamar2 : daftarKamar) {
            if (kamar.kodeKamar.equals(kamar2.kodeKamar)) {
                kamar2.setStatus(status);
                break;
            }
        }
    }

    public static void checkIn(Tamu tamu, Kamar kamar, int malam) {
        Reservasi checkIn = new Reservasi(tamu, kamar, malam);

        updateStatusKamar(kamar, false);

        daftarReservasi.add(checkIn);
    }

    public static int cariReservasibyKodeKamar(String kodeKamar) {
        int i = -1;
        for (Reservasi reservasi : daftarReservasi) {
            i += 1;
            if (reservasi.kamar.kodeKamar.equals(kodeKamar)) {
                if (!reservasi.kamar.status) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void checkOut(int indexReservasi) {
        Reservasi reservasi = daftarReservasi.get(indexReservasi);
        reservasi.setTanggalCheckOut(DateString.now());
        Kamar kamar = reservasi.kamar;
        updateStatusKamar(kamar, true);

        daftarReservasi.set(indexReservasi, reservasi);
    }

    public static void createAccount(String nama,String nip,String password){
        Staff staff = new Staff(nama,nip,password);
        daftarStaff.add(staff);
    }

}