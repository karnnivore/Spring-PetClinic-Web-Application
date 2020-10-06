const express = require('express');
const app = express();
const router = express.Router();
const user = require('./users.json');

//middleware
router.use(express.static('public'));

//test 
router.get('/test', (req,res) => {
    res.send('This is a test page');
});

//Endpoint /user?uid=? 
router.get('/user\?uid\=:uid\d+', (req,res) => {

    res.send('This works');
});

//Start 
app.use('/', router);

app.listen(process.env.port || 8084);

console.log('Web Server is listening at port ') + (process.env.port || 8084);