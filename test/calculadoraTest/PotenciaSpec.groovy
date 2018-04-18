package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class PotenciaSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()

    @Unroll('Con los valores #x ^ #y')
    def 'Se prueba el método potencia'() {

    	expect:
    		resultado == calculadora.potencia(x,y)

    	where:
    		x	|   y       ||  resultado
    		-10	|   2       ||  100
    		-10	|   3       ||  -1000
                
                // Fuente: https://keisan.casio.com/calculator
    		9**9	|   9       ||  196627050475552913618075908526912116283103450944214766927315415537966391196809
    		9**9	|   -9      ||  5.08577023141753460908514490264043675742829371544603182415084434857471333690662948987474096132281084144E-78
    		-9**9	|   -9      ||  -5.08577023141753460908514490264043675742829371544603182415084434857471333690662948987474096132281084144E-78
    		-9**9	|   9       ||  -196627050475552913618075908526912116283103450944214766927315415537966391196809
    }
}
