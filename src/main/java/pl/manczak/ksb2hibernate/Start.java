package pl.manczak.ksb2hibernate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private CarRepo carRepo;

    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Car carPolonez = new Car("Polpnez", "Caro", Color.BLACK);
        Car carFiat = new Car("Fiat", "Panda", Color.RED);
        
        carRepo.save(carPolonez);
        carRepo.save(carFiat);



    }
}
