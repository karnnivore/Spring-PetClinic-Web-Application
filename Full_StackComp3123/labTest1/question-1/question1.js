/**
 * ●	Create a script with a function named lowerCaseWords that takes a mixed array as input. 
The function will do the following.
o	return a promise that is resolved or rejected
o	filter the non-strings and lower case the remaining words

 */
const mixedArray = ['PIZZA', 10, true, 25, false, 'Wings']

function lowerCaseWords(arr){
    
     

    let prom = new Promise((resolve, reject) => {
        arr = arr.filter(element => typeof element === 'string' && element != '');
        arr.forEach(element => {
            arr.push(element.toLowerCase());
        });
        arr.shift()
        arr.shift()
        resolve(arr);
        
    })

    return prom;

    
}

console.log(lowerCaseWords(mixedArray));
