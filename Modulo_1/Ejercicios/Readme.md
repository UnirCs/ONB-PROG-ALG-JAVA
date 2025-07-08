## Ejercicio 1: Gestión de reservas en un restaurante

**Enunciado**  
Imagina que administras un pequeño restaurante con un número limitado de mesas (por ejemplo, 5). A lo largo del día, llegan clientes que desean hacer reservas. Se pide diseñar un **algoritmo** que:

- Reciba las solicitudes de reserva (número de personas y nombre del cliente).
- Verifique si quedan mesas disponibles.
    - Si hay al menos una mesa libre, asigna la reserva y reduce el contador de mesas disponibles en 1.
    - Si no quedan mesas, se indica al cliente que no hay disponibilidad.
- Se repite este proceso hasta que se terminen las mesas o hasta que el administrador decida cerrar el sistema de reservas (condición de parada).

**Puntos clave**
- Identificar el **bucle** para procesar reservas mientras queden mesas y mientras el administrador no termine el día.
- Incluir una **decisión** (condicional) para saber si hay mesas disponibles.
- Cada vez que se asigna una mesa, se debe decrementar el número de mesas libres.
- Al finalizar, mostrar cuántas reservas se realizaron.

---

## Ejercicio 2: Clasificación de números y conteo de pares

**Enunciado**  
Diseña un algoritmo que reciba un conjunto de números enteros e indique, para cada uno, si es **par** o **impar**. Además, al final, debe mostrar cuántos números pares se han ingresado en total. El proceso termina cuando el usuario decida no introducir más números.

**Puntos clave**
- Se utiliza un **bucle** para procesar cada número ingresado hasta que el usuario decida parar.
- Se incluye una **condición** para determinar la paridad (n % 2 == 0).
- Se incrementa un **contador** que lleve la cuenta de cuántos números son pares.

---

## Ejercicio 3: Control de inventario con actualización continua

**Enunciado**  
Crea un algoritmo para un sistema de **inventario** que maneje productos en un almacén. El sistema debe:

1. Iniciar con un inventario vacío o con ciertas existencias (por ejemplo, 3 productos).
2. Permitir al usuario **agregar** productos y actualizar así la cantidad almacenada.
3. Permitir al usuario **retirar** cierta cantidad de un producto. Si la cantidad solicitada excede la disponible, debe mostrar un mensaje de error.
4. Repetir estos pasos hasta que el usuario decida terminar el día.

**Puntos clave**
- Uso de **condiciones** para verificar si hay suficiente inventario en caso de una retirada.
- Uso de **bucles** para permitir operaciones de ingreso o retiro varias veces.
- Al final, mostrar el inventario final de cada producto.
