class Pedido(){

    companion object {
        var contPedidos: Int = 0
    }

    init {
        contPedidos++
    }

    val numero = contPedidos

    val platos: MutableList<Plato> = mutableListOf()

    var estado = EstadoPedido.PENDIENTE


    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String){
        if (nombrePlato)
    }
}