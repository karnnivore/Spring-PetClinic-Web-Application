//Exercise 1: Capitalize the first letter of each word of a given string.
function capFirstLetter(word) {
    let testArr = word.split(' ');
    let capArr = []
    testArr.forEach(element => capArr += element.charAt(0).toUpperCase() + element.slice(1) + ' ');
    return capArr;
}

console.log(capFirstLetter("the quick brown fox"));
console.log(capFirstLetter("heather went to school and learned a lot"));

//Exercise 2: Find the largest of three given integers
function max(a, b, c) {
    arr = [a, b, c];
    arr.sort(function(a, b){return a-b});
    return arr[2];
}

console.log(max(1, 0, 1));
console.log(max(0, -10, -20));
console.log(max(510, 1000, 400));

//Exercise 3: Move last 3 characters of string to the start - string must be >= 3
function right(word) {
    if (word.length >= 3) {
        let last3 = word.substr(word.length - 3);
        let frontPart = word.substr(0, word.length - 3);
        return last3 + frontPart;
    } else {
        return word;
    }
}

console.log(right('Python'));
console.log(right('JavaScript'));
console.log(right('hi'));

//Exercise 4: Find the type of a given angle
function angle_type(angle) {
    return angle < 90 ? 'Acute angle'
         : angle == 90 ? 'Right angle'
         : angle > 90 & angle < 180 ? 'Obtuse angle'
         : angle == 180 ? 'Straight angle'
         : 'Reflex angle';
}

console.log(angle_type(47));
console.log(angle_type(90));
console.log(angle_type(145));
console.log(angle_type(180));
console.log(angle_type(190));


//Exercise 5: find the maximum possible sum of some of its k consequietive numbers
let array_max_sum = angle => {

};