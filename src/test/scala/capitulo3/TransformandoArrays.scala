package capitulo3

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class TransformandoArrays extends FunSuite{
  
  val a = Array(2, 3, 5, 7, 11)
  
  test("Usando um for comprehension para transformar array"){
    //Criar uma nova array pela transformação dos elementos (yield)
    val result = for(elem <- a) yield elem * 2
    assert(Array(4, 6, 10, 14, 22) === result)
  }
  
  test("Processar somente alguns elementos que combinam com a condição"){
	  val result = for(elem <- a if elem % 2 == 0) yield elem * 2
	  assert(Array(4) === result)
	  
	  //Alternativamente poderia usar
	  val result2 = a.filter(_ % 2 == 0).map(2 * _)
	  assert(Array(4) === result2)
	  
	  //Ou ainda
	  val result3 = a filter { _ % 2 == 0 } map { 2 * _}
	  assert(Array(4) === result3)
  }
  
}