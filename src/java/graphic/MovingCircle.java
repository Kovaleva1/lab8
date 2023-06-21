package graphic;

import javafx.scene.shape.Circle;

public class MovingCircle {
    private final Circle circle;
    private double dx, dy;

    private Integer id;

    MovingCircle(Integer id, Circle circle, double dx, double dy) {
        this.id = id;
        this.circle = circle;
        this.dx = dx;
        this.dy = dy;
    }

    public Circle getCircle() {
        return circle;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
