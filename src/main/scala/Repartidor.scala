import java.time.LocalDateTime

class Repartidor(val nombre: String, zonas: List[Zona], minPeso: Double, maxPeso: Double) {
  var paquetes: List[Paquete] = List()

  
  def recibirPaquete(paquete: Paquete): Boolean = {
    if (puedeEntregar(paquete)) {
      paquetes = paquete :: paquetes
      true
    } else {
      false
    }
  }

  private def puedeEntregar(paquete: Paquete): Boolean = {
    paquete.peso > minPeso && paquete.peso <= maxPeso && zonas.exists(zona => zona.codigosPostales.contains(paquete.codigoPostal))
  }

  def entregarPaquete(id: String, firma: String): Unit = {
    paquetes = paquetes.map { paquete =>
      if (paquete.id == id && !paquete.esEntregado) {
        paquete.copy(
          esEntregado = true,
          firma = Some(firma),
          fechaEntrega = Some(LocalDateTime.now().toString)
        )
      } else {
        paquete
      }
    }
    val paqueteEntregado = paquetes.find(paquete => paquete.id == id && paquete.esEntregado)
    paqueteEntregado.foreach((new Notificacion).enviar(_, new MensajeEntrega))
  }

  def paquetesNoEntregados: List[Paquete] = {
    paquetes.filter(!_.esEntregado)
  }
}
