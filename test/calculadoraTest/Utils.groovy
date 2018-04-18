package calculadoraTest

/**
 *
 * @author marces
 */
class Utils {
	
    static def esCero(BigDecimal x) {
        x.abs() < 0.000000001
    }
    
    static def esAproximado(BigDecimal x1, BigDecimal x2) {
        
        BigDecimal aux = (x1 - x2).abs()
        esCero(aux)
    }
    
    static def redondear(BigDecimal x1, BigDecimal x2) {
        
    }
}

