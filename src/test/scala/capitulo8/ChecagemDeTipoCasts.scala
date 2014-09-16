package capitulo8

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Para testar se um método pertence a uma
 * dada classe, use o método isInstanceOf. 
 * Se o resultado do método for sucesso, então
 * pode ser usado o método asInstanceOf para 
 * converter uma referência para uma subclasse
 * referência.
 */

class Manager extends Employee{
  
}

@RunWith(classOf[JUnitRunner])
class ChecagemDeTipoCasts extends FunSuite{
  
  test(""){
    val p = new Manager
    assert(p.isInstanceOf[Employee] === true)
    
    if (p.isInstanceOf[Employee]){
      val s = p.asInstanceOf[Employee] //s tem tipo Employee
    }
  }
  /**
   * O p.isInstanceOf[Employee] é sucesso se 
   * p referir a um objeto de uma classe Employee
   * ou suas subclasses (como Manager)
   * 
   * Se p é null, entáo p.isInstanceOf[Employee] retorna
   * false e p.asInstanceOf[Employee] retorna null.
   * 
   * Se p não é um Employee ou uma subclasse de Employee
   * então p.asInstanceOf[Employee] lança uma exceção
   * 
   * Para testar se p se refere a Employee mas não
   * a uma subclasse use:
   */
  test("testar se p se refere a Employee mas não a uma subclasse"){
    val p = new Employee
    assert(p.getClass() == classOf[Employee])
  }
  
  /**
   * Correspondência entre checagem de tipos
   * e casts em Scala e Java
   * ===========================================
   * Scala					| Java
   * ===========================================
   * obj.isInstanceOf(Cl)   | obj instanceof Cl
   * obj.asInstanceOf(Cl)   | (Cl) obj
   * classOf[obj]			| obj.class
   */
  
  /**
   * No entanto pattern matching é geralmente uma
   * alternativa melhor para usar checagem de tipo
   * e casts.
   */
  test("checkagem de tipo com patter matching"){
    
    assertResult(true){
      val p = new Manager
      p match {
        case s: Employee => true
        case _ => false
      }
    }
    
    assertResult(false){
      val p = new Employee
      p match {
        case s: Manager => true
        case _ => false
      }
    }
  }
  
}