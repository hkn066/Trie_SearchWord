import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        try {
            BufferedReader read=new BufferedReader(new FileReader("src/sozluk.txt"));

            Scanner src= new Scanner(new File("src/sozluk.txt"));  // dışardan veri listesi almak için

            Scanner scanner = new Scanner(System.in);

            System.out.println("Aramak istediğiniz kelimeyi giriniz:");

            String line=null;
            String words = scanner.nextLine();

            Trie trie = new Trie();
            boolean sonuc = trie.search(words);  //trie'de veri arama işlemi
            if (sonuc != true) {
                System.out.println("Aradığınız kelime:");
                System.out.println(words);
            }
            System.out.println("Olması muhtemel kelimeler :");
            while((line=read.readLine())!= null){
                boolean olası=line.startsWith(words);

                if(olası==true){
                    //System.out.println("Olması muhtemel kelimeler :");
                    System.out.println(line);
                }
            }
            while (src.hasNextLine()) {
                trie.insert(src.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}