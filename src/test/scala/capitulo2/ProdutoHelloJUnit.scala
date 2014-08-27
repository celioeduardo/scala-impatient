package capitulo2

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.internal.runners.JUnit4ClassRunner

@RunWith(classOf[JUnit4ClassRunner])
class ProdutoHelloJUnit {
  
  def prod(s: String) = {
    var res: Long = 1;
    for (ch <- s) res *= ch.toLong
    res
  }
  
  @Test
  def test(){
    assert(prod("Hello") == 9415087488L)
  }
  
}