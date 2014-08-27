package capitulo3

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class ArrayTamanhoFixoTest extends FunSuite {
	
  test("Array de tamanho fixo de dez inteiros, todos inicializados com zero"){
    val nums = new Array[Int](10) 
    assert(nums.length == 10)
    for (num <- nums) assert(num == 0)
  }
  
  test("Array de tamanho fixo com dez strings, todas inicializadas com null"){
    var a = new Array[String](10)
    assert(a.length == 10)
    for(s <- a) assert(s == null)
  }
  
  test("Uma Array[String] de tamanho 2 - o tipo é deduzido"){
    var s = Array("Hello","World")
    assert(s.length == 2)
    assert(s(0) == "Hello") 
    assert(s(1) == "World") 
    
    s(0) = "Goodbye"
    assert(s(0) == "Goodbye")
  }
  
}