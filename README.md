innova4b-daw-modulo7-empresaReparto
===================================

Proyecto: empresas de reparto

Tres perfiles en maven:
dev: para desarrollo (por defecto)
integration-test: para tests de integración
prod: para producción

En perfil de integration-test: se ejecutan los tests de integración
En los otros perfiles: se ejecutan los tests unitarios

Ejecución de tests unitarios: mvn clean test
Ejecución de tests de integración: mvn clean verify -P integration-test

Los tests unitarios están en la carpeta: src/test
Los tests de integración están en la carpeta: src/integration-test

En perfil de desarrollo:
La base de datos se crea y popula al arrancar la aplicación
Se muestran las querys de hibernate
Nivel de logueo: debug

En perfil de producción:
Se valida la base de datos al arrancar la aplicación
No se muestran las querys de hibernate
Nivel de logueo: error

Uso de plugin de maven de jetty como contenedor de servlets:
Configuración de Reload: manual
Arrancar la aplicación en perfil desarrollo: mvn jetty:run
Arrancar la aplicación en perfil prod: mvn jetty:run -P prod

Si el jetty finaliza mal, hay que "matar el proceso": 
	- En una terminal ejecutar: netstat -ap | grep 9999
	- matar el proceso que está en el puerto 9999

Los logs se guardan en el directorio del proyecto. Hay 3 ficheros diferentes:
	- hibernate.log: logueo de hibernate
	- spring.log: logueo de clases de Spring
	- empresaReparto.log: logueo de clases propias de la aplicación


