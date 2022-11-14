# Automatizacion de pruebas API REST

## REST ASSURED

### Instalacion 

````
  gradle build
````

### Run Test
En la raiz del proyecto comando de linea.

> Ejecutar todas las pruebas

````
gradle :test --tests "TwoTest"
````

> Ejecutar la creacion de nuevo usaurio 

 ````
 gradle :test --tests "TwoTest.createEmployeeNew"

 ````

> Ejecutar la creacion de post usario con info fake

 ````
 gradle :test --tests "TwoTest.createEmployeeFake"

 ````
