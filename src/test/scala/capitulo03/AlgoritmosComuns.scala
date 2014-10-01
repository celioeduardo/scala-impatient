package capitulo03

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

@RunWith(classOf[JUnitRunner])
class AlgoritmosComuns extends FunSuite{
  
  test("Soma de elementos da array"){
    assert(19 == Array(1,7,2,9).sum)
    assert(19 == ArrayBuffer(1,7,2,9).sum)
  }
  
  test("Máximo elemento"){
    assert("little" == Array("Mary", "had", "a", "little", "lamb").max)
    assert("little" == ArrayBuffer("Mary", "had", "a", "little", "lamb").max)
  }
  
  test("Ordenação"){
    assert(Array(1,2,7,9) === Array(1,7,2,9).sorted)
    assert(ArrayBuffer(1,2,7,9) === ArrayBuffer(1,7,2,9).sorted)
  }

  test("É possível fornecer uma função de comparação"){
	assert(Array(9,7,2,1) === Array(1,7,2,9).sortWith(_ > _))
	assert(ArrayBuffer(9,7,2,1) === ArrayBuffer(1,7,2,9).sortWith(_ > _))
  }
  
  test("Quick sort"){
    val a = Array(1,7,2,9)
	Sorting.quickSort(a) //Não funciona para ArrayBuffer
	assert(Array(1,2,7,9) === a)
  }
  
  test("Exibir conteúdo do array"){
    val a = Array(1,7,2,9)
    
    assert("1 and 7 and 2 and 9" == a.mkString(" and "))
    assert("<1,7,2,9>" == a.mkString("<", ",", ">"))
    //método toString é confuso, vindo do Java
    assert("Array(1, 7, 2, 9)" != a.toString)
    //o toString do ArrayBuffer é mais claro
    assert("ArrayBuffer(1, 7, 2, 9)" == ArrayBuffer(1,7,2,9).toString)
  }
  
}