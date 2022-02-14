## APPLY SERVICE

If you want to apply for a loan based on the customer SSID, you should use this service.

####  Apply for a Loan Resource
```
GET http://localhost:8082/api/credit-apply/{ssid}
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 200 
{
  "id": 3,
  "timestamp": 1632487211077,
  "ssid": 21236552054,
  "phone": "905384557144",
  "message": "Dear Ali Bahcecioglu, the result of your loan application is positive. Your credit limit: 20000.0 ₺",
  "creditScore": 1000,
  "salary": 5000,
  "creditLimit": 20000,
  "creditStatus": true
}
RESPONSE: HTTP 400
{
  "status": 400,
  "message": "SSID: The last digit cannot be an odd number.",
  "timestamp": 1632487148767
}

RESPONSE: HTTP 400
{
  "status": 400,
  "message": "Customer with SSID({ssid}) not found!",
  "timestamp": 1632487174873
}
```
