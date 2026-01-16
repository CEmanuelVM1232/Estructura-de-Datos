/**
 * Utiliza una pila para invertir una palabra ingresada por el usuario
 * Demuestra el uso de pilas para operaciones de reversión de texto
 * 
 * @author Carlos Emanuel Valentino Martínez
 * @author 1224100580.cevm@gmail.com
 */

import java.util.Scanner;

public class InvertirPalabra  {
    
    static class MiPilaChar {
        private Nodo tope;
        
        class Nodo {
            char letra;
            Nodo siguiente;
            
            public Nodo(char letra) {
                this.letra = letra;
                this.siguiente = null;
            }
        }
        
        public MiPilaChar() {
            this.tope = null;
        }
        
        public void push(char letra) {
            Nodo nuevo = new Nodo(letra);
            nuevo.siguiente = tope;
            tope = nuevo;
        }
        
        public char pop() {
            if (isEmpty()) {
                return ' ';
            }
            char letra = tope.letra;
            tope = tope.siguiente;
            return letra;
        }
        
        public boolean isEmpty() {
            return tope == null;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== EJERCICIO 4: INVERTIR PALABRA ===");
        
        System.out.print("Ingresa una palabra: ");
        String palabra = sc.nextLine();
        
        MiPilaChar pila = new MiPilaChar();
        
        // Mostrar proceso de apilado
        System.out.println("\nApilando letras...");
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            pila.push(letra);
            System.out.println("Apilado: '" + letra + "'");
        }
        
        // Mostrar proceso de desapilado
        System.out.println("\nDesapilando letras...");
        System.out.print("Palabra invertida: ");
        while (!pila.isEmpty()) {
            char letra = pila.pop();
            System.out.print(letra);
        }
        
        sc.close();
    }
}



