docker run -d ^
  --name mysql ^
  -e MYSQL_ROOT_PASSWORD=root ^
  -e MYSQL_DATABASE=telecom ^
  -e MYSQL_USER=telecom ^
  -e MYSQL_PASSWORD=telecom ^
  -p 3306:3306 ^
  mysql:8.4