package capitulo5

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

//Scala fornece getter e setter para todos os fields.
//Aqui nós definimos um field publico, se o campo
//fosse privado o getter e o setter seriam privados
class Person{
  var age = 0
}

//É possível redefinir o getter e o setter
class Person2{
  private var privateAge = 0
  
  def age = privateAge 
  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue //Não pode ser mai jovem
  }
}

@RunWith(classOf[JUnitRunner])
class GetterSetter extends FunSuite{
	
  test("usando getter e setter defaul"){
    val fred = new Person
    fred.age = 21 //Chama o método fred.age_=(21)
    assert(fred.age == 21) //Chama o método fred.age()
  }
  
  test("usando getter e setter customizados"){
    val fred = new Person2
    fred.age = 21
    assert(fred.age == 21)
    fred.age = 18
    assert(fred.age == 21)
  }
  
}