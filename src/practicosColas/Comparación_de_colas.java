/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicosColas;

import java.util.Scanner;

/**
 * Programa que compara dos colas para ver si son idénticas
 * @author Carlos Emanuel Valentino Martínez
 * @author 1224100580.cevm@gmail.com
 */
public class Comparación_de_colas {
    
    // Clase para la cola q
    static class Cola<T> {
        
        // Clase nodo para la cola
        class Nodo {
            T dato;
            Nodo siguiente;
            
            Nodo(T dato) {
                this.dato = dato;
                this.siguiente = null;
            }
        }
        
        private Nodo frente;
        private Nodo fin;
        private int tamaño;
        
        public Cola() {
            this.frente = null;
            this.fin = null;
            this.tamaño = 0;
        }
        
        // Método para agregar elemento
        public void encolar(T dato) {
            Nodo nuevo = new Nodo(dato);
            
            if (estaVacia()) {
                frente = nuevo;
                fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
            tamaño++;
        }
        
        // Método para sacar elemento
        public T desencolar() {
            if (estaVacia()) {
                throw new RuntimeException("La cola esta vacia");
            }
            
            T dato = frente.dato;
            frente = frente.siguiente;
            tamaño--;
            
            if (frente == null) {
                fin = null;
            }
            
            return dato;
        }
        
        // Ver si está vacía
        public boolean estaVacia() {
            return frente == null;
        }
        
        // Saber cuántos elementos hay
        public int tamaño() {
            return tamaño;
        }
        
        // Método para hacer copia
        public Cola<T> copiar() {
            Cola<T> copia = new Cola<>();
            Cola<T> temporal = new Cola<>();
            
            // Copiar elementos
            while (!this.estaVacia()) {
                T elemento = this.desencolar();
                temporal.encolar(elemento);
                copia.encolar(elemento);
            }
            
            // Regresar los elementos a la original
            while (!temporal.estaVacia()) {
                this.encolar(temporal.desencolar());
            }
            
            return copia;
        }
        
        // Para mostrar la cola
        @Override
        public String toString() {
            if (estaVacia()) return "[]";
            
            StringBuilder sb = new StringBuilder("[");
            Nodo actual = frente;
            while (actual != null) {
                sb.append(actual.dato);
                if (actual.siguiente != null) sb.append(", ");
                actual = actual.siguiente;
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    // Método para comparar dos colas
    public static <T> boolean sonIdenticas(Cola<T> cola1, Cola<T> cola2) {
        // Si son de diferente tamaño, no son iguales
        if (cola1.tamaño() != cola2.tamaño()) {
            return false;
        }
        
        // Usar copias para no dañar las originales
        Cola<T> copia1 = cola1.copiar();
        Cola<T> copia2 = cola2.copiar();
        boolean sonIguales = true;
        
        // Comparar cada elemento
        while (!copia1.estaVacia()) {
            T elemento1 = copia1.desencolar();
            T elemento2 = copia2.desencolar();
            
            if (!elemento1.equals(elemento2)) {
                sonIguales = false;
                break;
            }
        }
        
        return sonIguales;
    }
    
    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== COMPARADOR DE COLAS ===");
        System.out.println("Voy a comparar dos colas para ver si son iguales");
        
        // Primera cola
        Cola<Integer> cola1 = new Cola<>();
        System.out.println("\n--- PRIMERA COLA ---");
        System.out.print("¿Cuantos numeros quieres en la primera cola? ");
        int n1 = sc.nextInt();
        
        System.out.println("Dame " + n1 + " numeros:");
        for (int i = 0; i < n1; i++) {
            System.out.print("Numero " + (i+1) + ": ");
            cola1.encolar(sc.nextInt());
        }
        
        // Segunda cola
        Cola<Integer> cola2 = new Cola<>();
        System.out.println("\n--- SEGUNDA COLA ---");
        System.out.print("¿Cuantos numeros quieres en la segunda cola? ");
        int n2 = sc.nextInt();
        
        System.out.println("Dame " + n2 + " numeros:");
        for (int i = 0; i < n2; i++) {
            System.out.print("Numero " + (i+1) + ": ");
            cola2.encolar(sc.nextInt());
        }
        
        // Mostrar lo que ingresé
        System.out.println("\n--- MIS COLAS ---");
        System.out.println("Cola 1: " + cola1);
        System.out.println("Cola 2: " + cola2);
        
        // Comparar
        System.out.println("\n--- RESULTADO ---");
        boolean resultado = sonIdenticas(cola1, cola2);
        
        if (resultado) {
            System.out.println("¡Si son iguales las colas!");
        } else {
            System.out.println("NO son iguales las colas");
        }
        
        // Ver que no se modificaron
        System.out.println("\n--- VERIFICACION ---");
        System.out.println("Cola 1 despues: " + cola1);
        System.out.println("Cola 2 despues: " + cola2);
        
        sc.close();
    }
}