package pl.manczak.ksb2hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    List<Car> findCarsByColor(Color color);//nazwa jest podpowiadana jako elestyczna formuła, trzeba z niej korzystac

    List<Car>findCarsByColorAndMark(Color color, String mark);

    //własne zapytania


    @Query(value="SELECT * FROM cars WHERE cars.model=:model",nativeQuery = true)
    List<Car> findCarsByModelMyImpl(@Param("model") String model);

}
