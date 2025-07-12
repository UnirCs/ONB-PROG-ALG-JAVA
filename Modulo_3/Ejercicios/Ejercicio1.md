## Ejercicio 1: Gestión de Vehículos en una Empresa de Transporte

El objetivo de este ejercicio es trabajar la definicion de funciones, clases, herencia, interfaces y excepciones en Java, aplicando conceptos de programación orientada a objetos (POO).

En una empresa de transporte se gestionan vehículos de diferentes tipos: coches, motos y bicicletas eléctricas.
Cada vehículo:

- Hereda de una clase base vehiculos.Vehiculo que contiene atributos como marca, año de fabricación, y un método revisar().
- Puede tener distintos comportamientos según el tipo, aplicando polimorfismo.
- Puede implementar interfaces como interfaces.Electrico o interfaces.Combustion, que representan capacidades.
- Debe revisarse periódicamente, lo que implica simular una serie de pasos usando bucles y estructuras de control.

Además: 

- Se lanza una excepción si el año de fabricación es anterior al 2000, por cuestiones de seguridad.
- Deben definirse funciones auxiliares para calcular si el vehículo debe cambiar aceite, batería, o si está en condiciones de circular.

Se requiere implementar los siguientes elementos:

vehiculos.Vehiculo (clase abstracta)
- Atributos: String marca, int anio
- Métodos: presentarse(), revisar() (abstracto)

Subclases:
- vehiculos.Coche (usa combustible)
- vehiculos.Moto (usa combustible)
- vehiculos.BicicletaElectrica (es eléctrica)

Interfaces:
- interfaces.Electrico con método recargarBateria()
- interfaces.Combustion con método cambiarAceite()

Excepción personalizada:
- excepciones.VehiculoAntiguoException (lanzada si el vehículo es anterior al año 2000)

Además debe crearse una clase principal donde se creen instancias de cada tipo de vehiculo y se realicen las operaciones de revisión y presentación.

