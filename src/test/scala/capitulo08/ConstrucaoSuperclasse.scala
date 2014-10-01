package capitulo08
package _5

/**
 * Somente o construtor pricipal de uma classe
 * pode chamar o construtor de uma superclasse
 */
class Person(val name: String, val age: Int){
}

class Employee(name: String, age: Int, val salary: Double)
  extends Person(name, age){
  
}

/**
 * Um classe Scala pode extender um classe Java
 * Seu construtor primário precisa invocar um
 * dos construtores da superclasse Java. 
 * Exemplo: 
 */
class Square(x: Int, y: Int, width: Int) extends
  java.awt.Rectangle(x, y, width, width){

}