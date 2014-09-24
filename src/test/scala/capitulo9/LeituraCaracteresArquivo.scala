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
  
  //se você deseja espiar um caracter sem consumi-lo, chame 
  //o método buffered no objeto source. Assim você pode 
  //espiar o próximo caracter de entrada com o método 
  //head sem consumi-lo
  test("espiar caracteres de um arquivo"){
    val source = Source.fromFile("src/test/resources/myfile.txt","UTF-8")
    val iter = source.buffered
    var count = 1
    while (iter.hasNext){
      if (iter.head == 'i') count += 1
      iter.next
    }
    assert(4 == count)
    source.close;
  }
  
  //se seu arquivo não for grande, você pode apenas lê-lo
  //em uma string e processá-lo
  test("ler o conteúdo do arquivo para uma string"){
    val source = Source.fromFile("src/test/resources/myfile.txt","UTF-8")
    val contents = source.mkString
    assert("Linha 1\nLinha 2\nLinha 3" == contents)
	source.close;
  }
}