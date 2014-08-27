package capitulo2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProdutoHelloScalaTest extends FunSuite{
  
  def prod(s: String) = {
    var res: Long = 1;
    for(ch <- s) res *= ch.toLong
    res
  }
  
  test("Produto dos unicodes de Hello é 9415087488L"){
    assert(prod("Hello") == 9415087488L)
  }
  
}