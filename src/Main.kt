

fun main(){
    val cuenta1 = Cuenta(1)
    val cuenta2 = Cuenta(2, 700.0)
    val persona1 = Persona("32939158F", arrayOf(cuenta1,cuenta2))
    persona1.cuentas[0]?.recibirAbono(1100.0)
    persona1.cuentas[1]?.realizarPago(750.0)
    persona1.esMorosa()
    persona1.transferencia(persona1,persona1,0,1,200.0)
    persona1.esMorosa()
}