const express = require('express');
const app = express();
const router = express.Router();
const user = require('./user.json');

//middleware
router.use(express.static('public'))
/*
- Create new html file name home.html 
- add <h1> tag with message "Welcome to ExpressJs Tutorial"
- Return home.html page to client
*/
router.get('/home', (req,res) => {
  res.sendFile( __dirname + "/" + "home.html");
  res.send('This is home router');
});

/*
- Return all details from user.json file to client as JSON format
*/
router.get('/profile', (req,res) => {
  res.send('This is profile router<br>' + JSON.stringify(user));
});

/*
- Modify /login router to accept username and password as query string parameter
- Read data from user.json file
- If username and  passsword is valid then send resonse as below 
    {
        status: true,
        message: "User Is valid"
    }
- If username is invalid then send resonse as below 
    {
        status: false,
        message: "User Name is invalid"
    }
- If passsword is invalid then send resonse as below 
    {
        status: false,
        message: "Password is invalid"
    }
*/
router.get('/login/:userName&:password', (req,res) => {
  let userName = req.params.userName;
  let password = req.params.password;
  let status = false;
  let message = "";

  if (userName == user.username && password == user.password) {
    status = true;
    message = "User Is valid";
  } else if (userName != user.username) {
    status = false;
    message = "User Name is invalid";
  } else if (password != user.password) {
    status = false;
    message = "Password is invalid"
  }
  res.send(`This is login router<br>status: ${status}<br>message: ${message}`);
});

/*
- Modify /logout route to accept username as parameter and display message
    in HTML format like <b>${username} successfully logout.<b>
*/
router.get('/logout/:userName', (req,res) => {
  res.send(`This is logout router<br><b>${req.params.userName} successfully logged out.<b>`);
});

app.use('/', router);

app.listen(process.env.port || 8081);

console.log('Web Server is listening at port '+ (process.env.port || 8081));