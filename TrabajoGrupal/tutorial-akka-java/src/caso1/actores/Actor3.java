package caso1.actores;


import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Actor3 extends UntypedActor {
    public enum Mensaje {
        OBTENER_INFORMACION
    }

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private static final long TIEMPO_OBTENCION_INFORMACION = 2000;

    @Override
    public void onReceive(Object o) throws InterruptedException {
        log.info("[Actor3] ha recibido el mensaje: \"{}\".", o);

        if (o == Mensaje.OBTENER_INFORMACION) {
            log.info("[Actor3] está obteniendo informacion...");
            obtenerMinerales();
            log.info("[Actor3] ha obtenido informacion.");
        }
    }

    private void obtenerMinerales() throws InterruptedException {
        Thread.sleep(TIEMPO_OBTENCION_INFORMACION);
    }
}
