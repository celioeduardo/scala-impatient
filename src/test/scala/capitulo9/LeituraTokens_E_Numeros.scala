package capitulo9

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class LeituraTokens_E_Numeros extends FunSuite{
  
  test("uma forma rápida e grosseira de ler tokens com espaço em branco"){
    val source = Source.fromFile("src/test/resources/tokens.txt","UTF-8")
    
    val tokens = source.mkString.split("\\s+")
    assert(3 == tokens.length)
    assert("10"==tokens(0))
    assert("20"==tokens(1))
    assert("30"==tokens(2))
    
    source.close();
  }
  
  //para converter uma string em um número use o método 
  //toInt ou toDouble. por exemplo, se você tem um arquivo
  //contendo números float, você pode ler todos em uma array
  //por montar uma expressão como abaixo:
  test("converter tokens para double"){
    val source = Source.fromFile("src/test/resources/tokens.txt","UTF-8")
    
    val tokens = source.mkString.split("\\s+")
    val numbers = for (w <- tokens) yield w.toDouble
    
    assert(3 == numbers.length)
    assert(10 == numbers(0))
    assert(20 == numbers(1))
    assert(30 == numbers(2))
    
    //alternativamente pode ser feito:
    val nuns = tokens.map(_.toDouble)
    
    assert(3 == nuns.length)
    assert(10 == nuns(0))
    assert(20 == nuns(1))
    assert(30 == nuns(2))
    
    source.close();
  }
  
}