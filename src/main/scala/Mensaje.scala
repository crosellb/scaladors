trait Mensaje {
  def generar(paquete: Paquete): String
}

class MensajeEntrega extends Mensaje {
  override def generar(paquete: Paquete): String = {
    s"""
      |Notificación de entrega de paquete
      |----------------------------------
      |ID de paquete: ${paquete.id}
      |Peso: ${paquete.peso} kg
      |Código postal: ${paquete.codigoPostal}
      |DNI del cliente: ${paquete.dniCliente}
      |Firma: ${paquete.firma.getOrElse("N/A")}
      |Fecha de entrega: ${paquete.fechaEntrega.getOrElse("N/A")}
      |----------------------------------
      |¡Gracias por usar nuestro servicio!
      """.stripMargin
  }
}

class MensajeEnReparto extends Mensaje {
  override def generar(paquete: Paquete): String = {
    s"""
      |Notificación de paquete en reparto
      |----------------------------------
      |ID de paquete: ${paquete.id}
      |Peso: ${paquete.peso} kg
      |Código postal: ${paquete.codigoPostal}
      |DNI del cliente: ${paquete.dniCliente}
      |----------------------------------
      |Tu paquete está en camino!
      """.stripMargin
  }
}
