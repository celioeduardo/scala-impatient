package capitulo9

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class LendoCaracteresArquivo extends FunSuite{
  
  test("lendo caracteres de um arquivo"){
    //para ler caracteres individuais de um arquivo, você
    //pode usar um objeto Source diretamente como um Iterator
    //porque a classe Source estende de Iterator[Char]
    val source = Source.fromFile("src/test/resources/myfile.txt","UTF-8")
    var s = ""
    for (c <- source) s += c + "."
    assert("L.i.n.h.a. .1.\n.L.i.n.h.a. .2.\n.L.i.n.h.a. .3." == s)
    source.close;
    
  }
}