//Closures
function outer1() {
    const name = 'Outer1';
    function inner() {
        console.log('Outer name: ', name);
    }
    inner();
}
outer1();

// Closures #2
function outer2() {
    // GC will not delete this constant cause of inner() still using it.
    const name = 'Outer2'; 
     function inner() {
        console.log('Outer name: ', name);
    }
}

const innerFunction = outer2();
innerFunction();

// Use case of using Closures: Data privacy
let counter = 0;
function times() {
    counter += 1;
    console.log('Counter: ', counter);
}
times();
times();

function getCounter() {
    let counter = 0; // no one outside function can direct access
    return function times() {
        counter += 1;
        console.log('Counter: ', counter);
    }
}
let times = getCounter();
times();
times();

//Use case of using Closures: Stateful functions
function addFive(a) {
    return a + 5;
}
function addTen(a) {
    return a + 10;
}
// addFive and AddTen its same logic, make code too long and hard to maintains
console.log('Add five: ', addFive(10));
console.log('Add ten: ', addTen(10));

// use closure to solve that problem
function createAdd(a) { // a was keep then return function that accept b value
    return function (b) { 
        return a + b;
    }
}
const addFiveNew = createAdd(5); // fix state of a to 5
const addTenNew = createAdd(10);// fix state of a to 10
console.log('Add five new: ', addFiveNew(10));
console.log('Add ten new: ', addTenNew(10));


