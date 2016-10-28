export default class Person{
    constructor(name){
        this.name = name;
    }
    say(){
        return 'Hello ,I am '+this.name;
    }
}