var http = require("http");

var arithmetic = require("./Addition");
console.log("Hello NodeJs");

console.log(arithmetic.sum(10,20));
console.log(arithmetic.sub(10,20));
console.log(arithmetic.mul(10,20));
console.log(arithmetic.div(10,20));

let a = new arithmetic.AdditionClass(100,20);
console.log(a.add());

let p = new arithmetic.Person("Pritesh Patel");
p.display();
/*
http.createServer(function (request, response) {
    // Send the HTTP header 
    // HTTP Status: 200 : OK
    // Content Type: text/plain
    response.writeHead(200, {'Content-Type': 'text/plain'});
    
    // Send the response body as "Hello World"
    response.end('Hello World\n');
 }).listen(8081);
 
 // Console will print the message
 console.log('Server running at http://127.0.0.1:8081/');
*/

let users = [
    {id: 1, firstName: "Pritesh", lastName: "Patel", email: "pritesh@gmail.com"},
    {id: 2, firstName: "Krish", lastName: "Lee", email: "krish@gmail.com"},
    {id: 3, firstName: "Racks", lastName: "Jacson", email: "racks@gmail.com"},
    {id: 4, firstName: "Denial", lastName: "Roast", email: "denial@gmail.com"}
]

const port = process.env.PORT || 8082

const server = http.createServer((req, res) => {
    if (req.method !== 'GET') {
        res.end(`{"error": "${http.STATUS_CODES[405]}"}`)
    } else {
        if (req.url === '/') {
            res.end("<h1>Hello World</h1>")
        }
        if (req.url === '/hello') {
            res.write("<h1>Hello</h1>")
            res.end()
        }

        if (req.url === '/users') {
            res.setHeader('Content-Type', 'application/json;charset=utf-8');
            return res.end(JSON.stringify(users))
        }
    }
    res.end(`{"error": "${http.STATUS_CODES[404]}"}`)
})

server.listen(port, () => {
    console.log(`Server listening on port ${port}`);
})