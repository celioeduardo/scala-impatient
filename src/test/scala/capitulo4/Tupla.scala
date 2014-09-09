package capitulo4

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
/**
 * Tuplas são agregados de valores de tipos diferentes
 */

@RunWith(classOf[JUnitRunner])
class Tupla extends FunSuite{
	
  val t = (1, 3.14, "Fred") // Tupla do tipo (Int, Double, java.lang.String)
  
  test("acessando uma tupla"){
    assert(t._1 == 1)
    assert(t._2 == 3.14)
    assert(t._3 == "Fred")
  }
  
  test("geralmente é melhor usar pattern matching para obter os componentes de uma tupla"){
    val (primeiro, segundo, terceiro) = t
    assert(primeiro == 1)
    assert(segundo == 3.14)
    assert(terceiro == "Fred")
  }
  
  test("se usar o _ não é preciso todos os componentes"){
    val (primeiro, segundo, _) = t
    assert(primeiro == 1)
    assert(segundo == 3.14)
  }
  
  test("tuplas são úteis para funções que retornam mais de um valor"){
    assert("New York".partition(_.isUpper) == ("NY","ew ork"))
  }
}