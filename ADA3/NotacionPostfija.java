package ADA3;

import java.util.Stack;

public class NotacionPostfija {

    private String expresion; //Sera el string que no pasen para apilar
    private String expresionFinal;//Sera la cadena de la expresion en postfija
    private Stack <Character> pila; //pila que nos servira para realizar la transformacion a postfija
    private Stack <String> pilaExpPostfija;//pila que nos servira para evaluar las opearaciones aritmeticas

    public NotacionPostfija(String expresion){
        this.expresion = expresion;
        this.expresionFinal = "";
        this.pila = new Stack<Character>();
        this.pilaExpPostfija = new Stack<String>();
    }
    
    public String convertirInfijaAPostfija(){
        /*Para realizar esta operacion haremos los siguientes pasos:
        Recorremos toda la cadena
            Si es numero->Lo llevamos a la expresionFinal
            Si es operador->Lo apilamos
            Si es parentesos cerrado')'->sacamos 1 solo operador (pop)
        */

        for(int i = 0; i < this.expresion.length(); i++){
            //Las desigualdades son por el codigo ASCII
            
             //Vemos si el caracter es un numero
            if(this.expresion.charAt(i) >= '0' && this.expresion.charAt(i) <= '9'){
                this.expresionFinal = this.expresionFinal + this.expresion.charAt(i);
            }

            //Vemos si el caracter es un operador
            if(this.expresion.charAt(i) == '+' || this.expresion.charAt(i) == '-' || this.expresion.charAt(i) == '*' ||
                this.expresion.charAt(i) == '/' || this.expresion.charAt(i) == '^'){
                this.pila.push(this.expresion.charAt(i));
            }

            //Vemos si el caracter en un parentesis cerrado
            if(this.expresion.charAt(i) == ')'){
                this.expresionFinal = this.expresionFinal + this.pila.pop();
            }
        }

        /*Cuando se termine de recorrer la cadena, pueden quedar operadores dentro
        la pila, asi que los sacamos y los concatenamos a la expresionFinal
        */
        while(!this.pila.isEmpty()){
            this.expresionFinal = this.expresionFinal + this.pila.pop();
        }

        //hacer una funcion para darle formato con espacio entre numeros pal archivo
        
        //System.out.println(this.expresionFinal);
        return this.expresionFinal;
    }

    
    //Evaluamos la expresionFinal
    public String evaluarExpresionPostfija(){
        String expresionEvaluada = "";

        for(int i = 0; i < this.expresionFinal.length(); i++){
            
            if(this.expresionFinal.charAt(i) == '+'){
                sumar();
            }else
            if(this.expresionFinal.charAt(i) == '-'){
                restar();
            }else
            if(this.expresionFinal.charAt(i) == '*'){
                multiplicar();
            }else
            if(this.expresionFinal.charAt(i) == '/'){
                dividir();
            }else
            if(this.expresionFinal.charAt(i) == '^'){
                nPotencia();
            }
            else{
                this.pilaExpPostfija.push(String.valueOf(this.expresionFinal.charAt(i)));
            }

        }
        
        //System.out.println("Expr: " + this.expresionFinal + "; Eval: " + pilaExpPostfija.pop());
        expresionEvaluada = pilaExpPostfija.pop();

        return  expresionEvaluada;
    }

    
    private void sumar(){
        int num1 = Integer.valueOf(this.pilaExpPostfija.pop());      
        int num2 = Integer.valueOf(pilaExpPostfija.pop());
                
        this.pilaExpPostfija.push(String.valueOf(num2 + num1));
    }
    
    public void restar(){
        int num1 = Integer.valueOf(this.pilaExpPostfija.pop());       
        int num2 = Integer.valueOf(this.pilaExpPostfija.pop());
        
        this.pilaExpPostfija.push(String.valueOf(num2 - num1));
    }

    public void multiplicar(){
        int num1 = Integer.valueOf(this.pilaExpPostfija.pop());       
        int num2 = Integer.valueOf(this.pilaExpPostfija.pop());
        
        this.pilaExpPostfija.push(String.valueOf(num2 * num1));
    }

    public void dividir(){
        int num1 = Integer.valueOf(this.pilaExpPostfija.pop());       
        int num2 = Integer.valueOf(this.pilaExpPostfija.pop());
        
        this.pilaExpPostfija.push(String.valueOf(num2 / num1));
    }

    public void nPotencia(){
        int num1 = Integer.valueOf(this.pilaExpPostfija.pop());       
        int num2 = Integer.valueOf(this.pilaExpPostfija.pop());
        
        this.pilaExpPostfija.push(String.valueOf(Math.pow(num2, num1)));
    }
    
}
