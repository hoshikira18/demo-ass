
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class DBContext {

    protected FileInputStream fis = null;
    protected ObjectInputStream ois = null;

    protected FileOutputStream fos = null;
    protected ObjectOutputStream oos = null;

    public void addTag(Student record) throws IOException {

        String message = record.getMssv() + " " + record.getName();
        byte[] bytes = message.getBytes();
        
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        
        bytes.toString();
        String s = new String(bytes, Charset.forName("UTF-8"));
        
        System.out.println(s);
        
//        fos = new FileOutputStream("data\\index.txt", true);
//        fos.write(bytes);

        System.out.println("Done!");

    }

    public void insert(Student record) {
        try {
            fos = new FileOutputStream("data\\" + record.getMssv() + ".txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(record);
            addTag(record);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student read(String mssv) {
        try {
            fis = new FileInputStream("data\\" + mssv + ".txt");
            try {
                ois = new ObjectInputStream(fis);
            } catch (IOException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                return (Student) ois.readObject();
            } catch (IOException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void displayAllStudent() throws FileNotFoundException, IOException, ClassNotFoundException {
        File directory = new File("data");

        File[] listFiles = directory.listFiles();

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && !file.getName().equals("index.txt")) {
                    fis = new FileInputStream("data\\" + file.getName());
                    ois = new ObjectInputStream(fis);
                    Student student = (Student) ois.readObject();
                    System.out.println(student.getMssv() + ": " + student.getName());
                }
            }
        }
    }

}
