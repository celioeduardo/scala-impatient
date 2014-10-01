package capitulo03

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.WrappedArray

@RunWith(classOf[JUnitRunner])
class ArrayTamanhoVariavel extends FunSuite {

  test("ArrayBuffer é usado para array de tamanho variável"){
    //Um array vazio
    val b = ArrayBuffer[Int]() //ou new ArrayBuffer[Int]
    
    //Acrescentar um elemento no fim com +=
    b += 1
    assert(b == ArrayBuffer(1))
    
    //Acrescentar vários elementos no fim por colocá-los entre parênteses
    b += (1, 2, 3, 5)
    assert(b == ArrayBuffer(1, 1, 2, 3, 5))
    
    //Pode ser adicionada qualquer coleção com o operador ++=
    b ++= Array(8, 13, 21)
    assert(b === ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21))
    
    //Remover os últimos 5 elementos
    b.trimEnd(5)
    assert(b == ArrayBuffer(1, 1, 2))
    
    //Inserir elmento antes do índice 2
    b.insert(2, 6)
    assert(b == ArrayBuffer(1, 1, 6, 2))
    
    //É possível inserir vários elementos
    b.insert(2, 7, 8, 9)
    assert(b == ArrayBuffer(1, 1, 7, 8, 9, 6, 2))
    
    //Remover o índice 2
    b.remove(2)
    assert(b == ArrayBuffer(1, 1, 8, 9, 6, 2))
    
    //O segundo parâmetro indica quantos elementos serão removidos
    b.remove(2, 3)
    assert(b == ArrayBuffer(1, 1, 2))
    
    //Converter para Array fixa
    val a = b.toArray
    assert(a === Array(1, 1, 2))
    
    //Converter de volta para ArrayBuffer
    assert(a.toBuffer === ArrayBuffer(1, 1, 2))
  }
  
}