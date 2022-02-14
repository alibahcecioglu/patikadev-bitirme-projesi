## SMS SERVICE

If you want to send a text message to the customer's phone number, use this service.

#### Send SMS
```
POST http://localhost:8083/api/sms
Accept: application/json
Content-Type: application/json

{
  "creditLimit": 0,
  "creditScore": 0,
  "id": 0,
  "message": "string",
  "phone": "string",
  "salary": 0,
  "ssid": "string",
  "timestamp": 0
}

RESPONSE: HTTP 200 (Created)
```

#### List SMS Logs
```
GET http://localhost:8083/api/sms
Content-Type: application/json

RESPONSE: HTTP 200
[
  {
    "creditLimit": 0,
    "creditScore": 0,
    "id": 0,
    "message": "string",
    "phone": "string",
    "salary": 0,
    "ssid": "string",
    "timestamp": 0
  }
]
```
