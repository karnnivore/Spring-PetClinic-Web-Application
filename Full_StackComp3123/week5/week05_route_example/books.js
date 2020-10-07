const express = require('express');
const route = express.Router();

route.route('/books')

.get((req, res) => {
  res.send('GET ROUTE -Get a random book')
})

.post((req, res) => {
  res.send('POST ROUTE - Add a book')
})

.put((req, res) => {
  res.send('PUT ROUTE - Update the book')
})

module.exports = route