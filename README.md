# Blog Spring-Boot

## Guidelines

Run the blog application

- Clone this repository

```
git clone https://github.com/kostikroverist/Order.git
```

## Postman

- First url POST http://localhost:5001/saveOrders  
  in this url we can save Order
 ```
 {
  {
       
"items" : [
{
"name": "antena",
"quantity":1,
"price":160.00
},
{
"name": "apple",
"quantity":1,
"price":121.00
}
]
}

 }
 ```


```
 Total price 441.0
 ```
- Other url:

"Get all Item  by name and lowest price"

http://localhost:5001/findAllByName/( name item)

###Bonuses

the order is valid for 10 minutes and after 15 minutes it is removed from the DB



