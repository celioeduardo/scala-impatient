package capitulo9

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import java.nio.file.Path
import scala.collection.mutable.ArrayBuffer


/**
 * Atualmente não existe classes Scala "oficiais" para
 * visitar todos arquivos em um diretório, ou para 
 * percorrer diretórios recursivamente. Aqui serão
 * mostradas algumas alternativas.
 * 
 * Em uma versão anterior de Scala havia as classes
 * File e Directory. Você ainda pode encontrá-las na
 * package scala.tools.nsc.io dentro de scala-compiler.jar
 */
@RunWith(classOf[JUnitRunner])
class VisitarDiretorios extends FunSuite{

  // É fácil escrever uma função que produz um "iterator"
  // através dos subdiretórios de um diretório  
  import java.io.File
  def subdirs(dir:File): Iterator[File] = {
    val children = dir.listFiles.filter(_.isDirectory())
    children.toIterator ++ children.toIterator.flatMap(subdirs _)
  }
  
  test("visitando diretórios com iterator"){
    val dir = new File("src/test/resources/diretorio")
    var diretorios = new ArrayBuffer[String]
    for (f <- subdirs(dir)) diretorios += f.getName()
    assert(diretorios.contains("subdiretorioA"))
    assert(diretorios.contains("subdiretorioB"))
  }
  
  // Alternativamente, se você estiver usando Java 7, 
  // você pode adaptar o método "walkFileTree" da classe
  // java.nio.file.Files. Essa classe faz uso da interface
  // FileVisitor. Em Scala, nós geralmente preferimos usar
  // objetos função, não interfaces. (Embora, nesse caso, 
  // a Interface permite um controle mais fino - veja javadocs
  // para detalhes)
  import java.nio.file._
  implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path]{
    override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
      f(p)
      FileVisitResult.CONTINUE
    }
  }
  test("visitando diretorios usando java.nio.file.Files.walkFileTree"){
    val dir = new File("src/test/resources/diretorio")
    var s = ""
    Files.walkFileTree(dir.toPath(), (f:Path) => s += f + " ")
    //s tem como valor:
    //src\test\resources\diretorio\Arquivo.txt src\test\resources\diretorio\subdiretorioB\ArquivoB.txt
  }
}