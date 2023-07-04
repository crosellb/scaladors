class EmpresaPaqueteria(repartidores: List[Repartidor]) { 
  private var noAsignados: List[Paquete] = List()

  def recibirPaquetes(paquetes: List[Paquete]): Unit = {
    paquetes.foreach { paquete =>
      repartidores.find(_.recibirPaquete(paquete)) match {
        case Some(_) => (new Notificacion).enviar(paquete, new MensajeEnReparto)
        case None => // Ningún repartidor pudo recibir el paquete
          noAsignados = paquete :: noAsignados
      }
    }
  }

  def obtenerPaquetesNoEntregados: Map[String, List[Paquete]] = {
    repartidores.map(repartidor => (repartidor.nombre, repartidor.paquetesNoEntregados)).toMap
  }
}
