package capitulo8_1
/**
 * Como em Java você pode declarar uma classe
 * como final de modo que ela nao pode ser 
 * extendida. Você também pode declarar métodos
 * ou campos individuais como final então eles
 * não podem ser sobreescritos. Note que isso
 * é diferente do Java, onde um campo final é
 * imutável, similar ao val em Scala
 */

class Person {
}

class Employee extends Person {
	val salary = 0.0
}
