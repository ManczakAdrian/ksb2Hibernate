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
        Car carFiat126 = new Car("Fiat", "126p", Color.RED);
        Car carBMW = new Car("BMW", "A1", Color.RED);

        carRepo.save(carPolonez);
        carRepo.save(carFiat);
        carRepo.save(carBMW);
        carRepo.save(carFiat126);


        carRepo.findAll().forEach(System.out::println);

        System.out.println("=======================================");

        carRepo.findCarsByColor(Color.RED).forEach(System.out::println);

        System.out.println("==========================================");

        carRepo.findCarsByColorAndMark(Color.RED,"Fiat").forEach(System.out::println);


    }
}
