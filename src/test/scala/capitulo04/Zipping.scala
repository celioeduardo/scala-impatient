package capitulo04

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class Zipping extends FunSuite{
  
  test("agrupar valores para serem processados juntos"){
    val symbols = Array("<", "-", ">")
    val counts = Array(2,10,2)
    val pairs = symbols.zip(counts)
    
    assert(Array( ("<",2), ("-",10), (">",2) ) === pairs)
    
    //Esses pares de valor podem ser processados juntos
    var v = ""
    for ((s, n) <- pairs) v += s * n
    assert("<<---------->>" == v)
  }
  
  test("uma coleção de chaves e uma coleção paralela de valores podem formar um map"){
    val keys = Array("A", "B", "C")
    val values = Array(1,2,3)
    assert(keys.zip(values).toMap === Map( ("A"->1), ("B"->2), ("C"->3) ))
  }
  
}