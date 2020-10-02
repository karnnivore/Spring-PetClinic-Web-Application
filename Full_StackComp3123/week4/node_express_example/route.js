const express = require("express"); 
const router = express.Router(); 

router.param("userId", (req, res, next, id) => { 
    console.log(`This function will be called first ${req.params.userId}`); 
    if(req.params.userId == '12') {
        res.send("12 not allowed");   
    } else {
        next(); 
    }
}); 

router.get("/user/:userId/hello", (req, res) => { 
    console.log("Then this function will be called"); 
    res.write(`User ID?: ${req.params.userId}`)
    //res.send(`User ID: ${userId}`);
    res.end(); 
}); 

// Export router  
module.exports = router; 