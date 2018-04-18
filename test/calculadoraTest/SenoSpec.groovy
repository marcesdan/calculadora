package calculadoraTest

import static Utils.*
import static java.util.concurrent.ThreadLocalRandom.*
import static java.lang.Math.*
import spock.lang.*
import calculadora.Calculadora

class SenoSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll('Con el valor #x')
    def 'Se prueba el método seno con el valor #x'() {

    	expect:
            resultado == calculadora.seno(x)

    	where:
            x       ||  resultado  
            0       ||  0
    }
    
    @Unroll('Con el valor #x')
    def 'Se prueba que el método seno arroja valores aproximados a 0, cuando sen(x) es una raiz'() {

    	expect:
             esCero(calculadora.seno(x))

    	where:
            // Genera 1000 raices aleatorias de la función seno
            x << (0..999).collect() {
                
                def k = current().nextInt(-10000, 10001)
                
                // Ecuación generadora de raices de la función sen(x)
                k.multiply(PI)
            }
    }
}
