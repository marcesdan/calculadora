package calculadoraTest

import static java.util.concurrent.ThreadLocalRandom.*
import static java.lang.Math.*
import spock.lang.*
import calculadora.Calculadora

class TangenteSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll
    def 'Se prueba el método tangente con el valor #x'() {

    	expect:
            resultado == calculadora.tangente(x)

    	where:
            x      ||     resultado
            0      ||       0
    }
    
    @Unroll
    def 'Debe lanzar una excepción cuando la función no esta definida, cuando sen(#x) = 0'() {
        
        when:
            calculadora.tangente(x)
        
        then:
            thrown(ArithmeticException)
        
    	where:
            // Genera 1000 raices aleatorias de la función coseno
            x << (0..999).collect() {
                
                def k = current().nextInt(-10000, 10001)
                
                // Ecuación generadora de raices de la función cos(x)
                ( (2*k + 1) * PI ) / 2
            }
    }
}
