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
> Ejecutar la creacion de post usario masculino

 ````
 gradle :test --tests "TwoTest.createEmployeeMale"
````
 
> Run test by Env
>Para el ambiente de producción
 ````
gradle :test --tests "TwoTest.createEmployeeNew" -Denv=prod
````

>Para el ambiente de pruebas
````
gradle :test --tests "TwoTest.createEmployeeFake" -Denv=test
 ````