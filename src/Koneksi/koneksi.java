package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class koneksi {
    // Variabel untuk koneksi database
    private static final String DATABASE_URL = "jdbc:sqlite:inventaris_perpustakaan.db";

    // Method untuk membuat koneksi ke database
    public static Connection connect() {
        Connection conn = null;
        try {
            // Membuat koneksi ke database
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Koneksi ke database berhasil!");
        } catch (Exception e) {
            System.out.println("Gagal terhubung ke database: " + e.getMessage());
        }
        return conn;
    }

    // Method untuk membuat tabel secara otomatis
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS buku (" +
                     "id TEXT PRIMARY KEY, " +
                     "judul TEXT NOT NULL, " +
                     "pengarang TEXT NOT NULL, " +
                     "genre TEXT NOT NULL, " +
                     "penerbit TEXT NOT NULL, " +
                     "tahun_terbit INTEGER NOT NULL, " +
                     "jumlah INTEGER NOT NULL" +
                     ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabel 'buku' berhasil dibuat atau sudah ada.");
        } catch (Exception e) {
            System.out.println("Gagal membuat tabel: " + e.getMessage());
        }
    }

    // Main method untuk pengujian
    public static void main(String[] args) {
        // Memastikan koneksi berhasil dan tabel dibuat
        connect();
        createTable();
    }
}
