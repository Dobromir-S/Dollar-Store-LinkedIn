The project uses Spring for backend, PostgreSQL for RDB and reactJS for the UI.

The entire deployment process is fully automated, with docker containers deploying the Database with the appropriate schema and the backend, which in turn delivers the frontend at port 8088

Compiled react files are within the static directory of spring.

JPA is responsible for the connection with the database, establishing schema and all.

The REST API exposes 3 main resources - Employer, JobOffer and Employee, that can be accessed via /jobs, /employee, /employer,
they support the standard CRUD operations, such as create, update, delete, get, getall etc..

The functional part is essentially the Employer's ability to post job offers and the employee part of applying to them.

Every job offer knows about its Employer, the relationship being one to many, and has a list of applicants for the current offer.

Jobs can also be filtered per field and per employer.

The JSON is supposed to look like:
