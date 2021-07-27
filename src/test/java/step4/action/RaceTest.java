package step4.action;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @DisplayName("우승자 구하기")
    @Test
    void getWinner(){

        Car car1 = new Car("car1",10);
        Car car2 = new Car("car2",10);
        Car car3 = new Car("car3",5);
        Car car4 = new Car("car4",3);
        List<Car> carList = new ArrayList<>();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        Race race = new Race(carList);

        assertThat(race.getWinner()).containsExactly(car1,car2);
    }

}