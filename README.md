# PARCIAL CVDS - T1

Cesar Andres Borray Suarez

### ENUNCIADO

El cliente necesita un sistema de monitoreo de stock de productos, el cual le permita agregar productos nuevos y actualizar la cantidad de productos disponibles. Adicionalmente cada vez que un producto sea actualizado es necesario que se notifique a los dos agentes que serán implementados; Para los agentes es necesario tener en cuenta las siguientes características, el primero deberá escribir en el stdout las unidades disponibles y el segundo agente deberá escribir en el stdout si hay menos de 5 unidades disponibles lo cual generará una alerta. Estas funcionalidades deben ser expuestas en un servicio REST.

### PATRON DE DISEÑO IMPLEMENTADO

En la solución propuesta, se implementó el patrón de diseño Observer. Este patrón es útil en situaciones donde un objeto (el "sujeto") necesita notificar a otros objetos (los "observadores") sobre cambios en su estado.

![Ejemplo Patron](/capturas/observer.png) 

Se eligió el patrón Observer por las siguientes razones:

1. Desacoplamiento: Permite que los agentes de notificación (como LogAgent y AdvertenciaAgent) estén separados de la lógica de negocio en ProductoService, facilitando cambios sin afectar el resto del sistema.

2. Flexibilidad y Extensibilidad: Se pueden añadir nuevos agentes de notificación fácilmente sin modificar el código existente. Esto permite escalar la funcionalidad sin complicar la lógica central.

3. Notificaciones Automáticas: Los agentes son notificados automáticamente cuando hay cambios en el stock, lo que simplifica la gestión de estados y evita la necesidad de consultas adicionales.

4. Separación de Responsabilidades: Cada componente (producto, log, advertencia) se enfoca en su responsabilidad específica, lo que mejora la mantenibilidad y claridad del código.

### COBERTURA JACOCO ACLARACION

Se manejo pruebas principalmente para la clase de ServiceProduct que es la principal, donde se abarca las demas clases, por eso mismo no se tomo en cuenta tener pruebas para clases comno: Advertencia o Log

![Ejemplo Patron](/capturas/jacoco.png) 

PD: No pude abarcar mas % por el tiempo profe, no sea malito:(

