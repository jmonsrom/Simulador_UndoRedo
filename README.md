Simulador Undo/Redo en Java

Objetivo del proyecto

Desarrollar una aplicación en Java que simule la escritura de texto en consola utilizando una estructura de datos tipo pila, permitiendo realizar operaciones de **Deshacer (Undo) y Rehacer (Redo).

¿Qué es una pila?
Una pila (Stack) es una estructura de datos que funciona bajo el principio LIFO (Last In, First Out).
Esto significa que **el último elemento en entrar es el primero en salir.

Funcionamiento

1. Cuando el usuario escribe texto → se guarda en la pila principal.
2. Cuando presiona Undo → se mueve el elemento de la pila principal a la pila secundaria.
3. Cuando presiona Redo → se mueve el elemento de la pila secundaria nuevamente a la pila principal.

Operaciones implementadas

La pila fue implementada manualmente con las operaciones:

- push() → insertar elemento
- pop() → eliminar elemento
- peek() → ver elemento superior
- isEmpty() → verificar si la pila está vacía

Menú del simulador

El programa permite:

1. Escribir texto
2. Deshacer
3. Rehacer
4. Mostrar texto actual
5. Salir

Ejecución del programa

Compilar:

Participantes del proyecto:
Juan Guillermo Monsalve Román
C.C: 1020461679
IUDIGITAL DE ANTIOQUIA
