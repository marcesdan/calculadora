package calculadoraTest

import static Utils.*
import static java.util.concurrent.ThreadLocalRandom.*
import static java.lang.Math.*
import spock.lang.*
import calculadora.Calculadora

class CosenoSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll('Con el valor #x')
    def 'Se prueba el método coseno'() {

    	expect:
            resultado == calculadora.coseno(x)

    	where:
            x       ||  resultado  
            0       ||  1
            PI      ||  -1
            2*PI    ||  1
    }
    
    @Unroll('Con el valor #x')
    def 'Se prueba que el método coseno arroja valores aproximados a 0, cuando cos(x) es una raiz'() {

    	expect:
             esCero(calculadora.coseno(x))

    	where:
            // Genera 1000 raices aleatorias de la función coseno
            x << (0..999).collect() {
                
                def k = current().nextInt(-10000, 10001)
                
                // Ecuación generadora de raices de la función cos(x)
                ( (2*k + 1) * PI ) / 2
            }
    }
}
