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

> Ejecutar la creacion de usario con info fake

 ````
 gradle :test --tests "TwoTest.createEmployeeFake"
````
> Ejecutar la creacion de usario masculino

 ````
 gradle :test --tests "TwoTest.createEmployeeMale"
````
 
> Run test by Env
>Para el ambiente Local
 ````
gradle :test --tests "TwoTest.createEmployeeNew" -Denv=test
````
````
gradle :test --tests "TwoTest.createEmployeeFake" -Denv=test
 ````
 ````
 gradle :test --tests "TwoTest.createEmployeemale" -Denv=test
 ````
 
