/**
 * É possível usar as cláusulas package no
 * topo do arquivo, sem chaves. Por exemplo:
 */
package com.hortsmann.impatient
package people

class Person {
}

/**
 * Essa é a notação preferida se todo o código no 
 * arquivo pertence à mesma package. (que é o caso
 * mais comum)
 * 
 * Note que no exmplo acima tudo no arquivo pertence a
 * com.hortsmann.impatient.people, mas a package
 * com.hortsmaan.impatient também está aberta de modo 
 * que você pode referenciar seu conteúdo. 
 */

/**
 * Isso é equivalente a 
 */
package com.hortsmann.impatient{
	package capitulo07{
		class Person {
			//Até o fim do arquivo
		}
	}
}
