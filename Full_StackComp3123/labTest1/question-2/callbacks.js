/*const resolvedPromise = () => {
    setTimeout(() => {
        console.log()
    }, 500)
}
*/
let resolvedPromise = new Promise((resolve, reject) => {
    let timeOut = setTimeout(() => {
        clearTimeout(timeOut);
        let success = { 'message': 'delayed success!'}
        console.log(success)
        resolve(success)
    }, 500)
})

let rejectedPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
        let failure = { 'error': 'delayed exception!'}
        reject(failure)
    }, 500)
}).catch(error => {
    console.log(error);
})
