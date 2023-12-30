
# Produra

Aplicación para gestionar las compras en supermercado, saber que comprar y cuando, sugerir productos según los productos que se tienen en la despensa del usuario.

## Arquitectura

- model
  - Modelos de la aplicación
- useCase
  - Casos de uso e interfaces de repositorios o viewModels
- di
  - Objetos para la inyección de dependencias
- utils
  - utilidades
- infrastructure
  - Implementación de agentes externos (repositorios o viewModels)
- presentation
  - Vistas y ViewModels

## Tecnologías

- Base de datos
Por el momento todo será en local en el dispositivo por lo que se utilizará SQLite para alvergar las información de productos.

- Configuracion
Se utilizará SharedPreferences para almacenar configuraciones del sistema.

## Planes a futuro

- Conexión a internet para guardar los datos, tal vez almacenar en alguna nube de preferencia o utilizar un plan en firebase.