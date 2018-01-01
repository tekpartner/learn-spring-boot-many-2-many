# Learn Spring Boot REST Based WebServices that use Many-to-Many relationships

## Run the application
    ./gradlew bootRun
    
## Get a specific Book
    cURL -XGET http://localhost:8080/books/isbn/978-0743246264
    
## Get ALL Books
    cURL -XGET http://localhost:8080/books
    
## Need help in getting the dependent objects along with the book

#### Getting a specific book as mentioned above only retrieves the book info and not the dependent entities of Owner & Publisher. How do you get the dependent entities?