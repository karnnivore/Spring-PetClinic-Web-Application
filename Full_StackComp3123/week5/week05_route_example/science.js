const express = require('express');
const route = express.Router();

route.route('/heart')
    .get((req, res) => {
        res.send('GET ROUTE - /books/science/heart')
    })

route.route('/lungs')
    .get((req, res) => {
        res.send('GET ROUTE - /books/science/lungs')
    })

module.exports = route