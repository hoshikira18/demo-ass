
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author ADMIN
 */
public class Main {

 

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in, "UTF-8");

        DBContext db = new DBContext();

        int choice = 0;
        while (choice < 4) {
            System.out.println("====================================");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien");
            System.out.println("4. Thoat chuong trinh");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Nhap ten sinh vien ------------");
                    String name = scanner.nextLine();
                    System.out.println("Nhap ma so sinh vien ------------");
                    String mssv = scanner.nextLine();
                    Student s = new Student();
                    s.setName(name);
                    s.setMssv(mssv);
                    db.insert(s);
                    break;
                case 2:
                    System.out.println("----------------------------");
                    db.displayAllStudent();
                    System.out.println("----------------------------");
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Nhap ma so sinh vien can tra cuu");
                    String ms = scanner.nextLine();
                    Student student = db.read(ms);
                    System.out.println("Ten sinh vien: " + student.getName());
                    break;
            }
        }
        System.out.println("End");
    }
}
