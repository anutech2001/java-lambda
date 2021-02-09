// Higher Order Function
const persons = [
    { name: "John", age: 17 },
    { name: "Jane", age: 10 },
    { name: "Jim", age: 15 }
];

const kids = [];
for (let i = 0; i < persons.length; i++) {
    const person = persons[i];
    if (person.age <= 15) {
        kids.push(person);
    }
}
console.log('Kids: ', kids);

// filter
const persons = [
    { name: "John", age: 17 },
    { name: "Jane", age: 10 },
    { name: "Jim", age: 15 }
];

const kidsFilter = persons.filter(person => person.age <= 15);
console.log(kidsFilter);

// map
const mult = []
for (let i = 0; i < persons.length; i++) {
    const person = persons[i];
    // person.age = person.age * 2;
    // mult.push(person);
    mult.push({
        ...person,
        age: person.age * 2
    });
}
console.log('Multiply Age: ',mult)

const olderPersons = persons.map((person) => {
    return {
        ...person,
        age: person.age * 2
    }
});
console.log('Older persons: ', olderPersons);

// reduce
let totalAge = 0;
for (let i = 0; i < persons.length; i++) {
    const person = persons[i];
    totalAge += person.age;
}
console.log('Total age: ', totalAge);

let totalAgeReduce = persons.reduce((age, person) => {
    return age + person.age;
}, 0);
console.log('Total age(reduce): ', totalAgeReduce);
