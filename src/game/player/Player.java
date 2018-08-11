package game.player;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {
    public Vector2D velocity;
    public int angle;

    public Player() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(50, 50);
//        this.renderer = new PolygonRenderer(Color.RED,
//                new Vector2D(8,0),
//                new Vector2D(0, 20),
//                new Vector2D(16, 20));
        this.renderer=new ImageRenderer("image/spaceship.png",50,50);
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
    }
    @Override
    public void run(){
        super.run();

       // ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 25, this.position.y -25);
    }
    public void render(Graphics graphics) {
        super.render(graphics);
        //  ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

}
