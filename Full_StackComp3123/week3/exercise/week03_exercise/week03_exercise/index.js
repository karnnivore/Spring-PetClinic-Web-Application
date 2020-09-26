var http = require("http");
var url = require("url");
var querystring = require("querystring");
//TODO - Use Employee Module here
var employees = require("./Employee");
console.log("Lab 03 -  NodeJs");

//TODO - Fix any errors you found working with lab exercise

//Define Server Port
const port = process.env.PORT || 8081

//Create Web Server using CORE API
const server = http.createServer((req, res) => {
    let employeearr = employees.employees;
    let param = url.parse(req.url).query;
    let qObj = querystring.parse(param);
    if (req.method !== 'GET') {
        res.end(`{"error": "${http.STATUS_CODES[405]}"}`)
    } else {
        if (req.url === '/') {
            //TODO - Display message "<h1>Welcome to Lab Exercise 03</h1>"
            res.end("<h1>Welcome to Lab Exercise 03</h1>");
        }

        if (req.url === '/employee') {
            //TODO - Display all details for employees in JSON format
            res.end(JSON.stringify(employees.employees));
            
        }

        if (req.url === '/employee/names') {
            //TODO - Display only all employees {first name + lastname} in Ascending order in JSON Array
            //e.g. [ "Ash Lee", "Mac Mohan", "Pritesh Patel"]
            let fullNameArr = [];
            employeearr.forEach(element =>{
                fullNameArr.push(element.firstName + " " + element.lastName);
            });            
            res.end(JSON.stringify(fullNameArr));
        }

        if (req.url === '/employee/totalsalary') {
            //TODO - Display Sum of all employees salary in given JSON format 
            //e.g. { "total_salary" : 100 }
            let salarySum = {
                total_salary : 0
            }
            let sum = 0;
            employeearr.forEach(element => {
                sum += element.Salary
            });
            salarySum.total_salary = sum;
            res.end(JSON.stringify(salarySum));

        }  
    }
    res.end(`{"error": "${http.STATUS_CODES[404]}"}`)
})

server.listen(port, () => {
    console.log(`Server listening on port ${port}`);
})