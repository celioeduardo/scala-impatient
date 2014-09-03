package capitulo5

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Em Scala, cada classe tem um construtor primário. 
 * O construtor primário não está definida com um método. 
 * Em vez disso, ela está entrelaçada com a definição de classe.
 */
class PessoaPrimaria(val name: String, val age: Int){
  //println faz parte do construtor primário,
  //será executado sempre que um ojeto é criado
  println("Acabou de construir outra pessoa")
  def description = name + " is "+ age + " years old"
}

@RunWith(classOf[JUnitRunner])
class ConstrutorPrimario extends FunSuite{
	
  test("classe com construtor primário"){
    val p = new PessoaPrimaria("Martin", 45)
    assert("Martin" == p.name)
    assert(45 == p.age)
    assert("Martin is 45 years old" == p.description)
  }
  
}