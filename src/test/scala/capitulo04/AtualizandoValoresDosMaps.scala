package capitulo04

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class AtualizandoValoresDosMaps extends FunSuite{

  test("alterando um valor"){
    val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    scores("Bob") = 10
    assert(10 == scores("Bob"))
  }
  
  test("adicionando um valor"){
    val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    scores("Fred") = 7
    assert(7 == scores("Fred"))
  }
  
  test("pode-se usar o operador += para adicionar multiplas associações"){
    val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    scores += ("Bob" -> 10,"Fred"-> 7)
    assert(scores("Alice") == 10)
    assert(scores("Bob") == 10)
    assert(scores("Cindy") == 8)
    assert(scores("Fred") == 7)
  }
  
  test("para remover um elemento usar o operador -="){
    val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    scores -= "Alice"
    assert(scores.contains("Alice") == false)
    assert(scores("Bob") == 3)
    assert(scores("Cindy") == 8)
  }
  
  test("não é possível alterar um Map imutável, mas pode-se produzir um novo map com a alteração"){
    var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    val newScores = scores + ("Bob" -> 10,"Fred"-> 7)
    assert(newScores("Alice") == 10)
    assert(newScores("Bob") == 10)
    assert(newScores("Cindy") == 8)
    assert(newScores("Fred") == 7)
  }
  
  test("ou em vez de produzir um novo valor, pode-se alterar a variável"){
    var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    scores = scores + ("Bob" -> 10,"Fred"-> 7)
    assert(scores("Alice") == 10)
    assert(scores("Bob") == 10)
    assert(scores("Cindy") == 8)
    assert(scores("Fred") == 7)
  }
  
  test("para remover um elemento de um Map imutável, usar o operador - para obter o novo mapa sem a chave"){
    var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    scores = scores - "Alice"
    assert(scores.contains("Alice") == false)
    assert(scores("Bob") == 3)
    assert(scores("Cindy") == 8)
  }
}