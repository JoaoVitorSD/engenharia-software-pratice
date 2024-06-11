import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class Store {
    private final LinkedList<Game> games;

    public Store() {
        games = new LinkedList<>();
    }

    public Game addGame(String name, float price) {
        Game game = new Game(name, price);

        findGame(name).ifPresent(g -> {
            throw new InvalidParameterException(String.format("Game %s already exists", g));
        });

        games.add(game);
        return game;
    }

    public void sell(String name, float discount) {
        Game game = findGame(name)
                .orElseThrow(() -> new InvalidParameterException("Game not found"));
        game.sell(discount);
    }

    public Optional<Game> findGame(String name) {
        return games.stream().filter(game -> game.getName().equals(name)).findFirst();
    }

}
