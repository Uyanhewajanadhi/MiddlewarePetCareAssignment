# MiddlewarePetCareAssignment

--Clone git project and open it on Intelij (Test was done in ultimate edition)

---1. Build API
--Go to the Gradle and run build in following path
------Gradle -> petstore -> Tasks -> build -> build(run this)
--using commands
------- git clone https://github.com/Uyanhewajanadhi/MiddlewarePetCareAssignment.git
------- ./gradlew build -Dquarkus.package.type=uber-jar
------- java -jar build/petstore-runner.jar
       

--- Run API
--Run or Debug the project using run or debug icons in intelij

--use postman or similar app to test APIs
---POSTMAN run
-----Select GET,POST,PUT or DELETE method according to the api type
-----Add request url according to the path (http://localhost:8080/v1/pets)
-----Add url,query or body parameters suitable for the API
-----Click SEND button
-----All the correct API responses will be status 200

---2. Run Test suite
--Find test folder in Project ecplorer
---To test whole api(PET or PET TYPE)
----Double click and go to the class
----There's a green arrow icon in left to the class name. Right click it and click run test with coverage.
---To test methods
----There's a green arrow icon in left to the method name. Right click it and click run test with coverage.

--3. Run curl requests
---In POSTMAN on top there's a button called import. In import got to tab raw Past Raw Text.
---CURL request for GET, POST, PUT, DELETE as below

-----GET
curl http://localhost:8080/v1/petTypes
curl http://localhost:8080/v1/petTypes/1

-----POST
curl -X POST -H "Content-Type: application/json" \
    -d '{"petTypeId": 3, "name": "Bird"}' \
    http://localhost:8080/v1/petTypes

-----PUT
curl -X PUT -d petAge=12 -d petAge=l2 http://localhost:8080/v1/pets/1

-----DELETE
curl -X DELETE http://localhost:8080/v1/petTypes/1



