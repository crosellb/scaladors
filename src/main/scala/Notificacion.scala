class Notificacion {
  def enviar(paquete: Paquete, mensaje: Mensaje): Unit = {
    println(mensaje.generar(paquete))
  }
}
