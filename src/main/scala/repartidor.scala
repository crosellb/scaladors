import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.util.Random

class Repartidor(val nombre: String, val vehiculo: String) {
  def entregarPaquete(paquete: Paquete): Unit = {
    paquete.estadoEntrega = "Entregado"
    paquete.fechaHoraEntrega = Some(getFechaHoraActual)
    paquete.codigoEnvio = Some(generarCodigoEnvio)
    notificarEntrega(paquete)
  }

  private def getFechaHoraActual: String = {
    val fechaHoraActual = LocalDateTime.now()
    val formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    fechaHoraActual.format(formato)
  }
  
  private def generarCodigoEnvio: String = {
		val caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
		val longitudCodigo = 8
		val random = new Random()
		val codigoEnvio = new StringBuilder

		for (_ <- 1 to longitudCodigo) {
				val indice = random.nextInt(caracteres.length)
				codigoEnvio.append(caracteres.charAt(indice))
		}

		codigoEnvio.toString()
	}

  private def notificarEntrega(paquete: Paquete): Unit = {
    // Enviar notificación al cliente
  }
}