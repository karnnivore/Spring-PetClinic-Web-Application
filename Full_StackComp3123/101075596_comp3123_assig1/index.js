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
router.get('/user', (req,res) => {
    /*console.log(req.query);
    console.log(req.query.uid);*/
    let uid = req.query.uid;
    
    let searchF = o => o.id == uid;
    if (user.find(o => o.id == uid)) {
        var pos = user.findIndex(searchF)
        //string to hold new address string
        var adr = "";
        adr += user[pos].address.street + ", " + user[pos].address.city + ", "
            + user[pos].address.zipcode;
        //object to return needed fields
        retObj = { "id":0, "name": "test", "email": "test@test.com", 
        "address": "street name, city, zipcode", "phone": "1-770-736-8031" };
        retObj.id = user[pos].id;
        retObj.name = user[pos].name;
        retObj.email = user[pos].email;
        retObj.address = adr;
        retObj.phone = user[pos].phone;
        
        //console.log(user[pos]);
        res.send(retObj);
    } else {
        res.send("User not found");
    }
    
});

router.get('/user/all', (req, res) => {
    //sort object by username ascending
    user.sort((a, b) => {
        //comparison function to sort object
        if (a.username.toLowerCase() < b.username.toLowerCase()) {
            return -1;
        }
        if (a.username.toLowerCase() > b.username.toLowerCase()) {
            return 1;
        }
        return 0;
    })
    res.send(JSON.stringify(user));
})

//Start 
app.use('/', router);

app.listen(process.env.port || 8084);

console.log('Web Server is listening at port ') + (process.env.port || 8084);