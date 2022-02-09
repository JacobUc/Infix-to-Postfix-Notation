package ADA3;


import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        //Instanceamos un scanner para leeer el nombre del archivo
        Scanner scanner = new Scanner(System.in);
        //Creamos un nuevo ArchivoTxt
        ArchivoTxt nuevoArchivo = new ArchivoTxt();

        //Hacemos la lectura del nombre del archivo
        System.out.println("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        //Leemos el contenido del ArchivoTxt
        nuevoArchivo.leerArchivo(nombreArchivo);

        //Pasamos las expresiones leidas al ArrayList operaciones
        ArrayList <String> operacionesAritmeticas = new ArrayList <String> (); 
        nuevoArchivo.getExpresiones(operacionesAritmeticas);

        
        
        //Aplicamos el cambio a expresiones postfijas a todas las operacionesAritmeticas
        NotacionPostfija exp;
        //Guardamos las operaciones convertidas a postfijas en operacionesPostfijas
        ArrayList <String> operacionesPostfijas = new ArrayList <String> ();
        //Guardamos las evaluaciones en operacionesEvaluadas
        ArrayList <String> operacionesEvaluadas = new ArrayList <String> ();
        for(String a: operacionesAritmeticas){
            exp = new NotacionPostfija(a);
            operacionesPostfijas.add(exp.convertirInfijaAPostfija());
            operacionesEvaluadas.add(exp.evaluarExpresionPostfija());
        }
        
        //Exportamos el archivo txt
        nuevoArchivo.exportarArchivo(operacionesPostfijas, operacionesEvaluadas);
        
        scanner.close();
    }
    
}
