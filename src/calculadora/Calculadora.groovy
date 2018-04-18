package calculadora

import static java.lang.Math.*
import static Utils.*

class Calculadora {

    def suma(BigDecimal x1, BigDecimal x2) {
        x1 + x2
    }

    def resta(BigDecimal x1, BigDecimal x2) {
        x1 - x2
    }

    def multiplicacion(BigDecimal x1, BigDecimal x2) {
        x1 * x2
    }

    BigDecimal division(BigDecimal x1, BigDecimal x2) {
        x1.div(x2)
    }

    def divisionEntera(Integer x1, Integer x2) {
        x1.intdiv(x2)
    }

    def potencia(BigDecimal base, Integer exponente) {
        base ** exponente
    }

    BigDecimal raizCuadrada(BigDecimal base) {
        
        if (base < 0) throw new ArithmeticException()
        
        BigDecimal.valueOf(sqrt(base.doubleValue()))
    }
    
    BigDecimal raizCubica(BigDecimal base){
        BigDecimal.valueOf(cbrt(base.doubleValue()))
    }

    def factorial(Integer n) {
        
        // Casos triviales
        if (n < 0 || n > 500) throw new ArithmeticException()
        if (n == 0) return 1
        
        // De esta forma NO se verifican los casos triviales en cada llamada
        def aux = { x -> 
            x == 1 ? 1 : x * call(x - 1) 
        }
        
        // Puede ser un número muy grande
        aux(BigInteger.valueOf(n))
    }
    
    BigDecimal seno(BigDecimal x) {
        BigDecimal.valueOf(sin(x.doubleValue()))
    }
    
    BigDecimal coseno(BigDecimal x) {
        BigDecimal.valueOf(cos(x.doubleValue()))
    }
    
    BigDecimal tangente(BigDecimal x) {
        
        def cos = coseno(x)
        if (esCero(cos)) throw new ArithmeticException()
        
        seno(x) / coseno(x)
    }
}

