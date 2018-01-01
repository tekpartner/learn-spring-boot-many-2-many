# Learn Spring Boot REST Based WebServices that use Many-to-Many relationships

## Run the application
    ./gradlew bootRun
    
## Get a specific Book
    cURL -XGET http://localhost:8080/books/isbn/978-0743246264
    
## Get ALL Books
    cURL -XGET http://localhost:8080/books