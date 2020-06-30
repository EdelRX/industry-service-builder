# industry-service-builder
Spring Boot Application with a JMS queue listener that feeds into a Spring Integration flow Rest Template

Petitions arrive through the JMS queue listener to add industry objects to a database. A transformer stage prepares the object to be added based on the input data and a 
handler stage makes a REST call to another CRUD service to which will add the item.
