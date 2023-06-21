package graphic;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

import java.util.List;

public class AnimationMoveCircles extends AnimationTimer {

    private final double width;
    private final double height;
    private List<MovingCircle> circles;


    public AnimationMoveCircles(List<MovingCircle> circles, double width, double height) {
        this.circles = circles;
        this.width = width;
        this.height = height;
    }

    @Override
    public void handle(long now) {
        for (MovingCircle mc : circles) {
            Circle circle = mc.getCircle();
            circle.setCenterX(circle.getCenterX() + mc.getDx());
            circle.setCenterY(circle.getCenterY() + mc.getDy());

            if (circle.getCenterX() - circle.getRadius() < 0 || circle.getCenterX() + circle.getRadius() > width) {
                mc.setDx(-mc.getDx());
            }
            if (circle.getCenterY() - circle.getRadius() < 0 || circle.getCenterY() + circle.getRadius() > height) {
                mc.setDy(-mc.getDy());
            }
        }
    }

    public void setCircles(List<MovingCircle> circles) {
        this.circles = circles;
    }
}
