
// Pure Function
function add(a, b) {
    return a + b;
}
console.log(add(1, 2));

// Shared State
let x = 5;

const a1 = () => x += 1;
const m1 = () => x *= 2;

a1();
m1();
console.log(x);

//// reverse calling
let x = 5;

const a1 = () => x += 1;
const m1 = () => x *= 2;
m1();
a1();
console.log(x);

// Side Effect
a = 3;
function add2(x) {
    return x + a;
}
console.log(add2(1));

// First Class function 
//// Assigning a function to a variable
const addAssioning = function (a, b) {
    return a + b;
}
console.log('Assigning: ', addAssioning(1, 6));
//// Returning a function
function addReturning(a, b) {
    return function () {
        return a + b;
    }
}
const addTwoNumber = addReturning(1, 6);
console.log('Returning: ', addTwoNumber);
console.log('Returning: ', addTwoNumber());
//// Acceptiong a function as an argument
function addNumber(a, b) {
    return a + b;
}
function addAccepting(add, a, b) {
    return add(a, b);
}
console.log('Accepting: ', addAccepting(addNumber, 1, 6));