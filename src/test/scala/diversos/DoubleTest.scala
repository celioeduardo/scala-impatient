package diversos

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class DoubleTest extends FunSuite{
	
  test("falha ao somar tipo Double"){
    var valor = 0.0
    for (i <- 1 to 10)
      valor += 0.1
    assert(10.0 != valor)
  }
  
}