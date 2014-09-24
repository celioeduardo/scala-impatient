package capitulo9

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.io.Source
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class LeituraUrl_E_OutrosRecursos extends FunSuite{
  //O objeto Source tem métodos para ler de fontes
  //além de arquivos	
  test("leitura de outras fontes"){
    //ler de uma URL - comentado para não apresentar erro quando offline
    //val source1 = Source.fromURL("http://horstmann.com", "UTF-8")
    
    //ler de uma string, útil para debugar
    val source2 = Source.fromString("Hello, World!")
    assert("Hello, World!" == source2.mkString)
    
    //ler de uma entrada padrão
    val source3 = Source.stdin
    
  }
  
}