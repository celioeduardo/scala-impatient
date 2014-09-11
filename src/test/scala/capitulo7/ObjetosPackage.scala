/**
 * Uma package pode conter classes, objetos e traits, mas 
 * não a definição de funções e variáveis. Esta é uma 
 * infeliz limitação da Java virtual machine.
 * Faria mais sentido adicionar funções utilitárias ou
 * constantes para uma package ao invés de algum objeto Utils.
 * Objetos package resolvem essa limitação.
 * 
 * Cada package pode ter um objeto package. Ele é 
 * definido na package "pai" e tem o mesmo nome que
 * o filho da package. Exemplo:
 */

package com.hortsmaan.impatient
package object people{
  val defaultName = "John Q. Public"
}

package people{
  class Person {
    var name = defaultName //Uma constante da package. 
  }
}

/**
 * É uma boa idéia colocar o objeto package em um arquivo
 * com/hortsmaan/impatient/people/package.scala
 * Dessa forma, quem quiser adcionar funções ou variáveis
 * para a package pode encontrar o objeto package facilmente  
 */

