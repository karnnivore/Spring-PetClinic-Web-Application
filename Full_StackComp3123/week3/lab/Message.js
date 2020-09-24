welcome = "Hello World";
collegeName = "George Brown College"

greeting = name =>
{
    console.log(`Welcome, ${name}`)
}
testFunction = testName => 
{
    console.log(testName)
}

module.exports = {
    greeting,
    welcome,
    collegeName,
    testFunction
}
//exports.say = greeting