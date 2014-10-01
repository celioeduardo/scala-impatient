package capitulo09

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import java.io.FileInputStream
import java.io.File

@RunWith(classOf[JUnitRunner])
class LeituraArquivoBinario extends FunSuite{
  
  //Scala não fornece mecanismo para leitura de arquivos 
  //binários. Você precisará usar a biblioteca Java. 
  //Abaixo está como você pode ler um arquivo em 
  //um array de bytes
  test("leitura de arquivo binário"){
    val file = new File("src/test/resources/scala-logo.png")
    val in = new FileInputStream(file)
    val size = file.length().toInt
    val bytes = new Array[Byte](size)
    assert(3050 == size)
    assert(3050 == bytes.length)
    in.read(bytes)
    in.close()
  }
}