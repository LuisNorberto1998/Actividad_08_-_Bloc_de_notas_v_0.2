package models;

import java.io.*;

/**
 *
 * @author Norberto
 */
public class ModelBlocDeNotas {

    private String text;
    private String path;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void fileRead(String path) {
         try{
            String row;
            String txt="";
            try(FileReader file = new FileReader(path)){
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while((row = bufferedReader.readLine()) != null){
                    txt=txt+"\n"+row;
                    System.out.println(row);
                } 
                this.setText(txt);
                bufferedReader.close();
            }catch(FileNotFoundException e){
                System.out.println("File Not Found "+ e.getMessage());   
            }
            }catch(IOException e){
                System.out.println("Error " + e.getMessage());
        }
    }

    public void writeFile(String path, String text) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(text);
                printWriter.close();
            }
        } catch (IOException err) {
            System.err.println("error " + err.getMessage());
        }
    }
}
