"# account-creation"
an API is created for opening a new “current account” of
already existing customers.
the project use the spring boot with rest controller accessed by postman.


http://localhost:8080/accounts
this post will  create account and transaction based on the initialCredit variable inserted in the body of postman
method : POST
BODY: application/JSON
    {
        "customerId": 1,
        "initialCredit": 8
    }
    NB:above is an example
    
http://localhost:8080/accounts
this endPoint will return the customer information with GET method in postman.

this project use h2 database for better/faster testing.
