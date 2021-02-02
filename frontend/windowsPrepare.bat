npm run build
cd ..
del /S src\main\resources\static\*
y
Copy-item -Force -Recurse -Verbose "frontend/build/*" -Destination "src/main/resources/static/*"
mvn clean install -Dmaven.test.skip=true