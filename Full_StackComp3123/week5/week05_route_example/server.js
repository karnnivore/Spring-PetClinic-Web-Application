const express = require('express');
const fs = require("fs");
var dateFormat = require('dateformat');
let computers = require('./computer');
let books = require('./books');
let sciences = require('./science')

const app = express();
const router = express.Router();

let writeData = (data) => {
    data += "\n"
    fs.appendFile('server_log.txt', data, function (err) {
      if (err) throw err;
      console.log('Log Saved!');
    });
  }

let logger = (req, res, next) => {
    const todays = dateFormat(Date(), "dddd, mmmm dS, yyyy, h:MM:ss TT");
    let data  = `[${todays}] - ${req.originalUrl}`
    writeData(data)
    next()
  }
  

app.use(logger);
/*
  app.get('/book', function (req, res) {
    res.send('GET - Get a random book')
  })

  app.post('/book',function (req, res) {
    res.send('POST - Add a book')
  })

   app.put('/book',function (req, res) {
    res.send('PUT - Update the book')
  })
  */


app.use("/books", books);
app.use("/books/computer", computers);
app.use("/books/science", sciences);
/*
/books/computer/java
/books/computer/python
/books/computer/python/basic
/books/science/heart
/books/science/lungs
*/

app.listen(process.env.port || 8081);

console.log('Web Server is listening at port '+ (process.env.port || 8081));