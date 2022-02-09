package ADA3;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ArchivoTxt {

    private String partes[];


    //Falta arreglar este metodo para que pase las partes divididas por ';' al array
    public void getExpresiones(ArrayList <String> operacionesTxt){
        
        for(int i = 0; i < partes.length; i++){
            operacionesTxt.add(this.partes[i]);
        }
        
        
    }

    public void leerArchivo(String nombreArchivo){
        String linea;
        
        try {
            String direccion = "D:\\Archivos\\" + nombreArchivo + ".txt";
            BufferedReader bfReader = new BufferedReader(new FileReader(direccion));
            String temp = "";

            //Mientras haya algo por leer
            while( (linea = bfReader.readLine()) != null){
                temp = temp + linea;
            }

            //Separamos todas las operaciones y las guardamos en partes[]
            this.partes = temp.split(";");

            bfReader.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }catch(IOException e) {
            e.getMessage();
        }
    }

    public void exportarArchivo(ArrayList <String> arrayPostfijas, ArrayList <String> arrayOperacionesEvaluadas){
        
        try {
            PrintWriter writer = new PrintWriter("exp_postfijas.txt", "UTF-8");
            
            for(int i = 0; i < arrayPostfijas.size(); i++){
                writer.println("Expr: " + arrayPostfijas.get(i) + ";  Eval: " + arrayOperacionesEvaluadas.get(i));
            }
            
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
