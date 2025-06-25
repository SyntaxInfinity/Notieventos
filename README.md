# NotiEventos – Sistema de Gestión de Participantes

**Autor:** Alex Ponce  
**Asignatura:** Patrones de Diseño  
**Profesor:** Giovanni Caceres  

---

## Descripción General

**NotiEventos** es un sistema de consola desarrollado en Java estándar, que permite gestionar participantes de un evento. Su funcionalidad incluye:

- Registrar participantes nuevos.
- Agregar participantes desde un sistema antiguo (legacy).
- Imprimir credenciales en formato simple.
- Notificar eventos importantes automáticamente.
- Recorrer la lista de participantes sin exponer su estructura interna.

Este proyecto integra **cuatro patrones de diseño GoF** de forma práctica y justificada, aplicados en un sistema modular, funcional y extensible.

---

## Patrones de Diseño Aplicados

### 1. **Adapter** (Estructural)

Permite adaptar un sistema antiguo (`SistemaAntiguo`) que solo entrega un nombre, transformándolo en un objeto `Participante` válido mediante la clase `AdaptadorAntiguo`, sin modificar el código legado.

> **Ubicación:** `adapter/AdaptadorAntiguo.java`  
> **Uso:** Opción 3 del menú – Agregar desde sistema antiguo

---

### 2. **Bridge** (Estructural)

Separa la lógica de impresión (`Impresora`) del formato visual de las credenciales (`FormatoSimple`). Aunque originalmente se planteó el uso de múltiples estilos, en esta versión final se mantiene un único formato fijo para simplificar la ejecución y asegurar compatibilidad con NetBeans.

> **Ubicación:** `bridge/Impresora.java`, `bridge/FormatoSimple.java`  
> **Uso:** Cada vez que se imprime una credencial

---

### 3. **Observer** (Comportamiento)

Implementa notificaciones automáticas al usuario cuando se registra un nuevo participante. La clase `NotificadorCorreo` responde con un mensaje visible en consola.

> **Ubicación:** `observer/NotificadorCorreo.java`  
> **Uso:** Cada vez que se agrega un nuevo participante

---

### 4. **Iterator** (Comportamiento)

Permite recorrer todos los participantes sin exponer directamente la estructura interna de la colección. Se implementa un iterador propio a través de `ParticipanteCollection` y `ParticipanteIterator`.

> **Ubicación:** `model/ParticipanteCollection.java`  
> **Uso:** Opción 2 del menú – Mostrar participantes

---

## Instrucciones de Compilación y Ejecución

### Estructura del proyecto

/NotiEventos
├── /src
│ ├── adapter/
│ ├── bridge/
│ ├── model/
│ ├── observer/
│ └── notieventos/ 

### Compilar y ejecutar

Ubicado dentro del directorio raíz del proyecto:

```bash
javac -d out src/**/*.java
java -cp out notieventos.Notieventos
````

````Ejemplo de uso
--- Menú NotiEventos ---
1. Agregar participante nuevo
2. Mostrar todos los participantes
3. Agregar desde sistema antiguo (Adapter)
0. Salir
Elige una opción: 1

Nombre: Juan Pérez
RUT: 12345678-9
Rol: Expositor
[Notificación] Nuevo participante agregado: Juan Pérez
````

### Posibles mejoras futuras
Agregar nuevos formatos de impresión (Bridge).

Persistencia de datos con archivos o base de datos.

Autenticación de usuarios para registrar participantes.

imprimir credenciales con código QR.

### Justificación General
Este proyecto demuestra la aplicación práctica de patrones GoF en un sistema funcional, enfocado en modularidad, 
reutilización y bajo acoplamiento. Cada patrón cumple un propósito real dentro del flujo de interacción del usuario, 
permitiendo escalar o modificar el sistema sin romper su estructura base.

### Ejemplo de ejecución en consola

![imgmenuconsola](https://github.com/user-attachments/assets/981c39c3-9f03-4590-aac1-85a9d426bedd)
