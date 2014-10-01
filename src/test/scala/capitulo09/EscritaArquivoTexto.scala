package capitulo09

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import java.io.PrintWriter
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class EscritaArquivoTexto extends FunSuite{
  
  //Scala não tem suporte nativo para escrever arquivos.
  //Para escrever um arquivo texto use um java.io.PrintWriter
  test("escrita de arquivo texto"){
    val out = new PrintWriter("src/test/resources/numbers.txt")
    for (i <- 1 to 10) out.print(i+" ")
    out.close()
    val source = Source.fromFile("src/test/resources/numbers.txt")
    assert("1 2 3 4 5 6 7 8 9 10 " == source.mkString)
    source.close()
  }
  
  //Quando se usa o método printf o compilador irá reclamar
  //dizendo que você precisa converter para AnyRef
  test("usando printf do PrintWriter"){
    val out = new PrintWriter("src/test/resources/numbers.txt")
    
    val quantity = 3
    val price = 5.82
    
    out.printf("%6d %10.2f", 
    	quantity.asInstanceOf[AnyRef], price.asInstanceOf[AnyRef]) //Eca!!
	
    //nesse caso é melhor usar o método format da classe String
    out.print("%6d %10.2f".format(quantity, price))

    //o método printf do Console não sofre desse problema
    
    out.close()
  }
  
}