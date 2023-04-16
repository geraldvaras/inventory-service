# Inventory Service
This application is part of the Project Warehouse Receiving and provides the functionality for managing
the products in the Inmaculada catalog. The project is the foundation of the Cloud Strategy at 
Inmaculada Group.

#REST API
|Endpoint            |Method        | Req. body      | Status 

|     Endpoint	      | Method   | Req. body | Status |  Resp. body  | Description    		   	                        |
|:------------------:|:--------:|:---------:|:------:|:------------:|:---------------------------------------------|
|    `/products`     | `GET`    |           | 200    |  Product[]   | Get all the products in the catalog.         |
|    `/products`     | `POST`   |  Product  | 201    |   Product    | Add a new product to the catalog.            |
|                    |          |           | 422    |              | A product with the same code already exists. |
| `/products/{code}` | `GET`    |           | 200    |   Product    | Get the product with the given code.         |
|                    |          |           | 404    |              | No product with the given code exists.       |
| `/products/{code}` | `PUT`    |  Product  | 200    |   Product    | Update the product with the given code.      |
|                    |          |           | 201    |   Product    | Create a product with the given code.        |
| `/products/{code}` | `DELETE` |           | 204    |              | Delete the product with the given code.      |

## Useful Commands

| Gradle Command	         | Description                                   |
|:---------------------------|:----------------------------------------------|
| `./gradlew bootRun`        | Run the application.                          |
| `./gradlew build`          | Build the application.                        |
| `./gradlew test`           | Run tests.                                    |
| `./gradlew bootJar`        | Package the application as a JAR.             |
| `./gradlew bootBuildImage` | Package the application as a container image. |

After building the application, you can also run it from the Java CLI:

```bash
java -jar build/libs/inventory-service-0.0.1-SNAPSHOT.jar
```

## Running a MSSQLServer Database

Run MSSqlServer as a Docker container

```bash
docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=G@briel@123" -p 1433:1433 --name inventory-mssqlserver-catalog -d mcr.microsoft.com/mssql/server:2019-latest
```
We need to create manually the database due to the absence of a parameter for creating the database.
### Container Commands

|                Docker Command	                | Description       |
|:---------------------------------------------:|:-----------------:|
|  `docker stop inventory-mssqlserver-catalog`  | Stop container.   |
| `docker start inventory-mssqlserver-catalog`  | Start container.  |
| `docker remove inventory-mssqlserver-catalog` | Remove container. |

### Database Commands

Start an interactive sqlcmd:

```bash
docker exec -it inventory-mssqlserver-catalog /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P G@briel@123
```
Create database
```bash
CREATE DATABASE INVENTORYDB
GO
```
|                               PSQL Command	                                |          Description           |
|:--------------------------------------------------------------------------:|:------------------------------:|
|                           `sqlcmd Sp_databases`                            |      List all databases.       |
|          `sqlcmd -S servername -d INVENTORYDB -U sa -P G@briel@`           | Connect to specific database.  |
| `sqlcmd -S localhost -d INVENTORYDB -U sa -P G@briel@ -Q "EXEC sp_tables"` |        List all tables.        |
|                                  `QUIT;`                                   | Quit interactive psql console. |