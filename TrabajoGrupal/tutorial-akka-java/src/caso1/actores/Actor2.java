package caso1.actores;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Actor2 extends UntypedActor {
    public enum Mensaje { // creacion de objeto especifico
        CREAR_TAREA
    }

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private ActorRef actor2;


    @Override
    public void preStart() {
        actor2 = getContext().actorOf(Props.create(Actor3.class), "Actor3");
    }

    @Override
    public void onReceive(Object o) throws InterruptedException {
        log.info("[Actor2] ha recibido el mensaje: \"{}\".", o);

        if (o == Mensaje.CREAR_TAREA) {
            actor2.tell(Actor3.Mensaje.OBTENER_INFORMACION, getSelf());
        }
    }
}
