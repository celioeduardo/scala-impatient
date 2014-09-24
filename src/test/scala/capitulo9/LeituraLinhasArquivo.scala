package capitulo9

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.io.Source
/**
 * Para ler todas as linhas de um arquivo 
 * chame o método getLines de um objeto
 * scala.io.Source
 */
@RunWith(classOf[JUnitRunner])
class LendoLinhasArquivo extends FunSuite{
  
  test("lendo linhas do arquivo myfile.txt"){
    val source = Source.fromFile("src/test/resources/myfile.txt","UTF-8")
    //o primeiro argumento pode ser uma string ou 
    //um java.io.File
    //você pode omitir o encoding se você sabe que
    //o arquivo usa o enconding padrão da plataforma
    
    //o resultado é um Iterator
    val lineIterator = source.getLines;
    
    //você pode processar as linhas uma a por vez
    var s = ""
    for (l <- lineIterator) s += l + " "
    assert(s == "Linha 1 Linha 2 Linha 3 ")
    
    source.close;
    
    val source2 = Source.fromFile("src/test/resources/myfile.txt","UTF-8")

    //ou pode colocar as linhas um array ou array buffer por 
    //aplicar os métodos toArray ou toBuffer no Iterator
    val lines = source2.getLines.toArray
    assert(lines.length == 3)
    
    source2.close;
    
    //em algumas situações você quer apenas ler o
    //arquivo inteiro para uma string
    val source3 = Source.fromFile("src/test/resources/myfile.txt","UTF-8")
    val contents = source3.mkString
    assert("Linha 1\nLinha 2\nLinha 3" == contents)
    source3.close;
  }

}