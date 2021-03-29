package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.Round;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RacingGameTest {

    RacingGame racingGame;

    private String[] carNames = {"pobi", "crong"};
    private int roundCount = 2;

    static Stream<Arguments> carList() {
        return Stream.of(
                arguments(Lists.list(new Car("pobi", 0), new Car("crong", 0)))
        );
    }

    @Test
    @DisplayName("생성자 테스트")
    void createRacingGame() {

        racingGame = new RacingGame(Arrays.asList(carNames), roundCount);

        assertNotNull(racingGame);
    }

    @ParameterizedTest
    @DisplayName("모든 차가 모든 라운드에 멈춘 게임 테스트")
    @MethodSource("carList")
    void runRoundAllStop(List<Car> carList) {

        List<Round> expected = new ArrayList<>(roundCount);
        for (int i = 0; i < roundCount; i++) {
            expected.add(new Round(Cars.of(carList)));
        }

        List<Round> actual = new RacingGame(Arrays.asList(carNames), expected.size()).runGame(() -> false);

        assertEquals(expected, actual);
    }
}