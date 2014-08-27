package capitulo3

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class PercorrerArrays extends FunSuite{
  
  val a = 0 until 10
  
  test("Percorrer um array com loop for"){
    for (i <- 0 until a.length) // ou 0 to a.length-1
      assert(i == a(i))
  }
  
  test("O método until retorna todos os números até (não incluindo) o limite superior"){
    var s = "" 
    for (i <- 0 until 10) s += i + " "
    assert("0 1 2 3 4 5 6 7 8 9" == s.trim())
  }
  
  test("O método to retorna todos os números até (incluindo) o limite superior"){
	var s = "" 
	for (i <- 0 to 10) s += i + " "
	assert("0 1 2 3 4 5 6 7 8 9 10" == s.trim())
  }
  
  test("Para visitar todo segundo elemento"){
    var s = ""
    for (i <- 0 until (10, 2)) s += i + " "
    assert("0 2 4 6 8" == s.trim())
  }
  
  test("Para visitar elementos partindo do fim do array"){
    var s = ""
    for (i <- (0 until a.length).reverse) s += i + " "
    assert("9 8 7 6 5 4 3 2 1 0" == s.trim())
  }
  
  test("Se não precisar do índice do array no corpo do loop"){
    var s = ""
    for (elemento <- a) s += elemento + " "
    assert("0 1 2 3 4 5 6 7 8 9" == s.trim())
  }
}