package Reading_writing;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Input_output {
    public static void main(String[] args) throws IOException {
        //CharacterBufferReader();
        //StringBufferReader();
        //ArrayBufferReader();
        ReadFromFile();
        //WriteToFile();
    }

    public static void CharacterBufferReader() throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters , 'q' to quit: ");

        do{
            c = (char) br.read();
            System.out.println(c);
        } while(c!='q');
    }

    public static void StringBufferReader() throws IOException {
        String st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to exit!: ");

        do{
            st = br.readLine();
            System.out.println(st);
        } while(!st.equals("stop"));
    }

    public static void ArrayBufferReader() throws IOException {
        String str[] = new String[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to exit!: ");
        for(int i=0; i<100; i++){
            str[i] = br.readLine();
            if (str[i].equals("stop")) {break;}
        }

        System.out.println("\n The contents of your file are:");
        for(int i=0; i<100; i++){
            if (str[i].equals("stop")) {break;}
            System.out.println(str[i]);
        }
    }

    public static void ReadFromFile(){
        File F = new File("src/main/java/Reading_writing/bytes.txt");
        FileInputStream fis = null;

        try{
            fis = new FileInputStream((F));
            int content;
            while ((content = fis.read()) != -1) {
                System.out.println("Byte value: " + content + " Character value: " + (char) content);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                fis.close();
            } catch (IOException e){
                e.printStackTrace(System.out);
            }
        }
    }

    public static void WriteToFile(){
        File F = new File("src/main/java/Reading_writing/bytes.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try{
            fos = new FileOutputStream((F)); // FileOutputStream needs a File.
            bos = new BufferedOutputStream(fos); // A BufferedOutputStream needs a FileOutputStream
            for (int i=0;i<100;i++){
                bos.write(("Hello World " + i + "\n").getBytes(StandardCharsets.UTF_8));
                if (i%10 ==0){
                    bos.flush();
                    // If any bytes have been buffered for any reason.
                    // Every 10 iterations these buffered bytes will be written to the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                bos.flush(); // Final flush to ensure no data is lost from the buffer before closing
                fos.close();
            } catch (IOException e){
                e.printStackTrace(System.out);
            }
        }
    }
}
