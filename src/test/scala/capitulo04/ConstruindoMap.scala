package capitulo04

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import java.util.NoSuchElementException

@RunWith(classOf[JUnitRunner])
class ConstruindoMap extends FunSuite{
  
  val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
  
  test("Construindo um Map imutável"){
    val novoScores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
	assert(novoScores.size == 3)
  }
  
  test("Construindo um Map mutável"){
    val scoresMutavel = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    assert(scoresMutavel.size == 3)
  }
  
  test("Iniciar com um Map em branco"){
    val vazio = scala.collection.mutable.Map[String,Int]()
    assert(vazio.size == 0)
  }
  
  test("Definindo um Par"){
    assert("Alice" -> 10 == ("Alice",10))
  }
  
  test("outra maneira de definir um map"){
    ( ("Alice",10), ("Bob",3), ("Cindy",8) )
  }
  
  test("acessando o valor de um map"){
    assert(3 == scores("Bob"))
  }
  
  test("caso o valor não seja encontrado um exceção é lançada"){
    intercept[NoSuchElementException]{
    	scores("Joe")
    }
  }
  
  test("o ideal é testar o valor antes de acessar"){
    assertResult(3){
      if (scores.contains("Bob")) scores("Bob")
      else 0 
    }
    
    assertResult(0){
      if (scores.contains("Joe")) scores("Joe")
      else 0 
    }
  }
  
  test("como essa combinação é comum, então tem um atalho"){
	assertResult(3){
      scores.getOrElse("Bob",0)
    }
	
	assertResult(0){
      scores.getOrElse("Joe",0)
    }
  }
  
}