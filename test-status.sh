http_code= curl -s -w "%{http_code}" localhost:8080/v1/health

if [[ $http_code -eq "200"  ]]; then
  echo "`date` - Status is lookin' good!" >> monitoring.txt
else
  echo "`date` - Status code is NOT 200. I repeat, status code is NOT 200!" >> monitoring.txt
fi