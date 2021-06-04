package caso1.actores;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Actor1 extends UntypedActor { // UntypedActor -> Libreria de akka
    // registro
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void preStart() { // Pre Inicio
        final ActorRef actor2 = getContext().actorOf(Props.create(Actor2.class), "Actor2");
        actor2.tell(Actor2.Mensaje.CREAR_TAREA, getSelf());
    }

    @Override // Recibir el mensaje
    public void onReceive(Object o) {
        log.info("[Actor1] ha recibido el mensaje: \"{}\".", o);
    }
}
