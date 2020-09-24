let msg = require("./Message.js")
let http = require("http")
console.log("Welcome to NodeJS Programming")
console.log(msg.collegeName)

console.log(msg.welcome)
msg.greeting("Nick")
msg.testFunction("Test works")

http.createServer((request, response) =>
{
    response.end("<h1>Welcome to my first web app</h1>")
    response.end()
}).listen(8081)

console.log("http://localhost:8081")