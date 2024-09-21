# PARCIAL CVDS - T1

Cesar Andres Borray Suarez

### ENUNCIADO

El cliente necesita un sistema de monitoreo de stock de productos, el cual le permita agregar productos nuevos y actualizar la cantidad de productos disponibles. Adicionalmente cada vez que un producto sea actualizado es necesario que se notifique a los dos agentes que serán implementados; Para los agentes es necesario tener en cuenta las siguientes características, el primero deberá escribir en el stdout las unidades disponibles y el segundo agente deberá escribir en el stdout si hay menos de 5 unidades disponibles lo cual generará una alerta. Estas funcionalidades deben ser expuestas en un servicio REST.

### PATRON DE DISEÑO IMPLEMENTADO

En la solución propuesta, se implementó el patrón de diseño Observer. Este patrón es útil en situaciones donde un objeto (el "sujeto") necesita notificar a otros objetos (los "observadores") sobre cambios en su estado.

![Ejemplo Patron](/capturas/observer.png)

`EJEMPLO CODIGO` 
