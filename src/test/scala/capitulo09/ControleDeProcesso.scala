package capitulo09

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import java.net.URL

/**
 * O pacote scala.sys.process fornece utilitários 
 * para interagir com shell. Você pode escrever seus
 * shell scripts em Scala, com todo o poder que a 
 * linguagem Scala coloca à sua disposição
 */
@RunWith(classOf[JUnitRunner])
class ControleDeProcesso extends FunSuite{

  test("execução de comando"){
    // O pacote sys.process contem uma conversão implícita
    // de strings para objetos ProcessBuilder. O operador !
    // executa o objeto ProcessBuilder.
    // O resultado do operador ! é o código de saída do 
    // programa executado: 0 (zero) se o programa executou 
    // com sucesso ou um indicador de falha não zero
    // Se você usar !! o invés de ! a saída será retornada
    // como string
    import sys.process._
    val result = "java -version" !
    
    // ** nota ** tem que deixar pelo menos uma linha em branco
    assert(result == 0)
    
    // Você pode encadear (pipe) a saída de um programa na  
    // entrada de outro usando o operador #|
    //    "ls -la .." #| "grep sec" !
    
    // Para redirecionar o output para um arquivo use o 
    // operador #>
    //    "ls -al .." #> new File("output.txt") !
    // para acrescentar use #>>
    //    "ls -al .." #>> new File("output.txt") !
    // para redirecionar o input de um arquivo use <#
    //    "grep sec" #< new File("output.txt") !
    // você pode também redirecionar o input de uma URL
    //    "grep Scala" #< new URL("http://horstmann.com/index.html") !
    
    // você pode combinar processos com 
    //    p #&& q (executa q se p foi executado com sucesso)  
    //    p #|| q (executa q se p não foi executado com sucesso)
    // para ser franco Scala é melhor em controle de fluxo do que 
    // o shell, então por que não implementar o controle de fluxo
    // em Scala?
    // ** nota **
    // A biblioteca de processos usa os operadores familiares de shell
    // | > >> < && ||, mas prefixa-os com um # de modo que todos eles 
    // tem a mesma precedência
    
    // Se você precisa executar um processo em um diretório diferente, 
    // ou com variáveis de ambiente diferentes, construa um ProcessBuilder
    // com o método aplly do objeto Process.
    // Forneça o comando, o diretório de início e uma sequência 
    // pares de (chave, valor) para configurações de ambiente:
    //     val p = Process(cmd, new File(dirName), ("LANG", "en_US"))
    // Então execute com o operador !
    //     "echo 42" #| p !
    
  }
  
}