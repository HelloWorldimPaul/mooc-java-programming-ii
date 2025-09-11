package asteroids;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AsteroidsApplication extends Application {

    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage window) {

        Pane pane = new Pane();
        Text text = new Text(10, 20, "Points: 0");
        pane.setPrefSize(WIDTH, HEIGHT);

        AtomicInteger points = new AtomicInteger();

        pane.getChildren().add(text);

        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Asteroid> asteroids = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(100), rnd.nextInt(100));
            asteroids.add(asteroid);
        }
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

        Scene scene = new Scene(pane);

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        List<Projectile> projectiles = new ArrayList<>();

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                projectiles.forEach(projectile -> {
                    asteroids.forEach(asteroid -> {
                        if(projectile.collide(asteroid) && projectile.isAlive() && asteroid.isAlive()) {
                            projectile.setAlive(false);
                            asteroid.setAlive(false);
                            points.addAndGet(1000);   // Add points immediately on hit
                            text.setText("Points: " + points.get());
                        }
                    });
                });

                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                if (pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                    Projectile projectile = new Projectile(
                            (int) ship.getCharacter().getTranslateX(),
                            (int) ship.getCharacter().getTranslateY()
                    );
                    projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                    projectile.accelerate();
                    projectile.setMovement(projectile.getMovement().normalize().multiply(3));
                    projectiles.add(projectile);
                    pane.getChildren().add(projectile.getCharacter());
                }

                ship.move();
                asteroids.forEach(Character::move);
                projectiles.forEach(Character::move);

                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });


                projectiles.removeIf(projectile -> {
                    if (!projectile.isAlive()) {
                        pane.getChildren().remove(projectile.getCharacter());
                        return true;
                    }
                    return false;
                });

                asteroids.removeIf(asteroid -> {
                    if (!asteroid.isAlive()) {
                        pane.getChildren().remove(asteroid.getCharacter());
                        return true;
                    }
                    return false;
                });

                if(Math.random() < 0.005) {
                    Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                    if(!asteroid.collide(ship)) {
                        asteroids.add(asteroid);
                        pane.getChildren().add(asteroid.getCharacter());
                    }
                }



            }
        }.start();

        window.setTitle("Asteroids!");
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {

        System.out.println("Hello, world!");
        launch(AsteroidsApplication.class);

    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
