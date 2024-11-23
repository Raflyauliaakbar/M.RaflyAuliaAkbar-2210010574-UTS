import csv

# Data buku
data_buku = [
    [1, "The Catcher in the Rye", "J.D. Salinger", "Drama", "Brown and Company", 1951, 12],
    [2, "To Kill a Mockingbird", "Harper Lee", "Fiksi", "J.B. Lippincott & Co.", 1960, 15],
    [3, "1984", "George Orwell", "Fiksi Ilmiah", "Secker & Warburg", 1949, 20],
    [4, "The Hobbit", "J.R.R. Tolkien", "Fantasi", "Allen & Unwin", 1937, 18],
    [5, "The Da Vinci Code", "Dan Brown", "Misteri", "Doubleday", 2003, 25],
    [6, "Think and Grow Rich", "Napoleon Hill", "Motivasi", "The Ralston Society", 1937, 22],
    [7, "The Alchemist", "Paulo Coelho", "Fiksi", "HarperOne", 1988, 14],
]

# Path untuk menyimpan file CSV
file_path = r"C:\Users\SSD TURBO_BC\Documents\NetBeansProjects\UTSPbo2\importData.csv"

# Membuat file CSV sesuai format tabel
try:
    with open(file_path, "w", newline="", encoding="utf-8") as file:
        writer = csv.writer(file, delimiter=',')
        # Menulis header
        writer.writerow(["ID", "Judul", "Pengarang", "Genre", "Penerbit", "Tahun Terbit", "Jumlah"])
        # Menulis data
        writer.writerows(data_buku)
    print(f"File CSV berhasil disimpan di: {file_path}")
except Exception as e:
    print(f"Terjadi kesalahan: {e}")
