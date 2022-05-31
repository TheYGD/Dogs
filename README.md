# Dogs
This is web applicaiton with backend made with Spring
** (FRONT-END IN PROGRESS) **

It is supposed to store dogs in database (currently in memory),
it allows to add dogs, update their information and delete it,
which is not implemented into frontend part yet.

The main class is pl\fidiym\demo\DemoApplication.java


List of HTTP Request Methods:
- GET /api/v1/dogs - returns list of dogs
- GET /api/v1/dogs/{id} - returns dog of given id
- GET /api/v1/dogs/names - returns list of dogs' basics (dog's id, name and image)
- POST /api/v1/dogs - adds dog of the given requestbody
- PUT /api/v1/dogs/{id} - updates details of the dog with given id
- DELETE /api/v1/dogs{id} - deletes dog with given id

Requests with "/cards" prefix are not completed yet.
