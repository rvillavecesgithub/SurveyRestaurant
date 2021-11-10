# SurveyRestaurant
Aplicación de diligenciamiento de encuesta de satisfacción a restaurantes

Documentación de servicios REST : http://localhost:8080/swagger-ui.html

El diagrama de la BD esta sobre la raiz del projecto llamado : ERD de SurveyRestaurant.jpeg

La conexion a la base de datos se determina por el archivo application.properties ya sea directamente a una BD en mysql o por base de datos hsqldb

la ejecucion del proyecto se realiza por los siguiente comandos:
-mvn install = para compilar y ejecucion de pruebas unitarias
-mvn spring-boot:run = para iniciar el proyecto