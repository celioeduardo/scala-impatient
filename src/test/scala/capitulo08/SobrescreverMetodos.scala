package capitulo08

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Em Scala é preciso usar o modificador
 * override quando se sobreescreve um método
 * que não é abstrato.
 */
class Person {
  var name = ""
  override def toString = getClass.getName + "[name="+name+"]"
}

/**
 * Chamar métodos da superclasse em Scala funciona
 * do mesmo jeito que em Java, como a palavra chave
 * super
 */
class Employee extends Person{
  var salary = 0.0
  override def toString = super.toString + "[salary="+salary+"]"
}

@RunWith(classOf[JUnitRunner])
class SobrescreverMetodos extends FunSuite{
  
  test("testando um método sobrescrito"){
    val p = new Person();
    p.name = "Ward"
    assert("capitulo08.Person[name=Ward]"==p.toString)
  }
  
  test("chamando um método da superclasse"){
    val e = new Employee();
    e.name = "Kent"
    e.salary = 30000
    assert("capitulo08.Employee[name=Kent][salary=30000.0]"==e.toString)
  }
}