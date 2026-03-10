import java.util.Scanner;

/*
 Proyecto: Simulador de escritura con Undo y Redo
 Autor: (JUAN GUILLERMO MONSALVE ROMAN)
 Descripción:
 Se implementa una estructura de pila manualmente para manejar
 acciones de escritura en consola con funcionalidades de
 Deshacer (Undo) y Rehacer (Redo).
*/

public class SimuladorUndoRedo {

    /*
     Clase Nodo
     Representa cada elemento de la pila
    */
    static class Nodo {
        String dato;
        Nodo siguiente;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    /*
     Clase Pila
     Implementación manual de una pila
    */
    static class Pila {

        private Nodo cima;

        public Pila() {
            cima = null;
        }

        // Insertar elemento
        public void push(String dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cima;
            cima = nuevo;
        }

        // Eliminar elemento
        public String pop() {
            if (isEmpty()) {
                return null;
            }

            String dato = cima.dato;
            cima = cima.siguiente;
            return dato;
        }

        // Ver elemento superior
        public String peek() {
            if (isEmpty()) {
                return null;
            }
            return cima.dato;
        }

        // Verificar si está vacía
        public boolean isEmpty() {
            return cima == null;
        }

        // Mostrar todos los elementos
        public void mostrar() {

            if (isEmpty()) {
                System.out.println("No hay texto escrito.");
                return;
            }

            Nodo actual = cima;

            System.out.println("\nTexto actual:");

            while (actual != null) {
                System.out.println(actual.dato);
                actual = actual.siguiente;
            }
        }

        // Vaciar pila
        public void clear() {
            cima = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Pila principal (acciones realizadas)
        Pila pilaPrincipal = new Pila();

        // Pila secundaria (acciones deshechas)
        Pila pilaRedo = new Pila();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Escriba una línea de texto: ");
                    String texto = scanner.nextLine();

                    pilaPrincipal.push(texto);

                    // Cuando se escribe algo nuevo se borra el historial de redo
                    pilaRedo.clear();

                    System.out.println("Texto agregado.");

                    break;

                case 2:

                    if (!pilaPrincipal.isEmpty()) {

                        String deshecho = pilaPrincipal.pop();
                        pilaRedo.push(deshecho);

                        System.out.println("Se deshizo: " + deshecho);

                    } else {

                        System.out.println("No hay acciones para deshacer.");
                    }

                    break;

                case 3:

                    if (!pilaRedo.isEmpty()) {

                        String rehacer = pilaRedo.pop();
                        pilaPrincipal.push(rehacer);

                        System.out.println("Se rehizo: " + rehacer);

                    } else {

                        System.out.println("No hay acciones para rehacer.");
                    }

                    break;

                case 4:

                    pilaPrincipal.mostrar();

                    break;

                case 5:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        scanner.close();
    }
}
