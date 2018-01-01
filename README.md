# Learn Spring Boot REST Based WebServices that use Many-to-Many relationships

## Run the application
    ./gradlew bootRun
    
## Get a specific Book
    cURL -XGET http://localhost:8080/books/isbn/978-0743246264
#### Output:
    {
       "id":4,
       "name":"Book 4",
       "isbn":"978-0743246264",
       "publishers":[
          {
             "id":1,
             "name":"Publisher 1",
             "description":"Description - 1"
          }
       ],
       "owners":[
          {
             "id":3,
             "name":"Owner 3"
          }
       ]
    }
    
## Get ALL Books
    cURL -XGET http://localhost:8080/books
#### Output:
    [
       {
          "id":1,
          "name":"Book 1",
          "isbn":"978-0743246261",
          "publishers":[
             {
                "id":1,
                "name":"Publisher 1",
                "description":"Description - 1"
             },
             {
                "id":2,
                "name":"Publisher 2",
                "description":"Description - 2"
             }
          ],
          "owners":[
             {
                "id":1,
                "name":"Owner 1"
             }
          ]
       },
       {
          "id":2,
          "name":"Book 2",
          "isbn":"978-0743246262",
          "publishers":[
             {
                "id":4,
                "name":"Publisher 4",
                "description":"Description - 4"
             },
             1,
             {
                "id":3,
                "name":"Publisher 3",
                "description":"Description - 3"
             }
          ],
          "owners":[
             {
                "id":2,
                "name":"Owner 2"
             },
             {
                "id":3,
                "name":"Owner 3"
             },
             1
          ]
       },
       {
          "id":3,
          "name":"Book 3",
          "isbn":"978-0743246263",
          "publishers":[
             4,
             2
          ],
          "owners":[
             2
          ]
       },
       {
          "id":4,
          "name":"Book 4",
          "isbn":"978-0743246264",
          "publishers":[
             1
          ],
          "owners":[
             3
          ]
       }
    ]