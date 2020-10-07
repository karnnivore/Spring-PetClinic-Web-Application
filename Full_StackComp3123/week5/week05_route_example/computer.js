const express = require('express');
const route = express.Router();

route.route('/java')
    .get((req, res) => {
        res.send('GET ROUTE - /books/computer/java')
    })

route.route('/python')
    .get((req, res) => {
        res.send('GET ROUTE - /books/computer/python')
    })

route.route('/basic')
    .get((req, res) => {
        res.send('GET ROUTE - /books/computer/python')
    })

module.exports = route