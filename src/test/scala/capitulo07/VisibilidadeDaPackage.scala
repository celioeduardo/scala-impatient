/**
 * Em Java um membro de classe que não declarado
 * como public, protected ou private está visível
 * na package que contém a classe. Em Scala, você 
 * ter o mesmo efeito com qualificadores. 
 * O método seguinte é visível em usa própria package.
 */
package capitulo7.com.hortsmaan.impatient.people

class Person {
	private[people] def description = "Uma pessoa com nome ..."
}

/**
 * Pode ser extendida a visibilidade para a package
 * mais externa:

class Person{
	private[impatient] def description = "Uma pessoa com nome ..."
}
* 
*/
