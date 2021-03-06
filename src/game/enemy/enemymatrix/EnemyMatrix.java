package game.enemy.enemymatrix;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;
import renderer.OvalRenderer;

import java.awt.*;

public class EnemyMatrix extends GameObject {
    public Vector2D velocity;
    private Vector2D temp;
  //  private EnemyShoot enemyShoot;

    public EnemyMatrix() {
        this.velocity = new Vector2D(2.5f,0);
        this.boxCollider = new BoxCollider(50,50);
        this.renderer = new ImageRenderer("image/bird.png", 50, 50);
        this.temp = new Vector2D(this.position.x,this.position.y);
    //    this.enemyShoot = new EnemyAttack();
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 25,this.position.y - 25);
        this.updateVelocity();
      //  this.enemyShoot.run(this);
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
      //  ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
    public void updateVelocity() {
        if (Math.abs(this.position.x - this.temp.x) >= 1250){
            this.velocity.set(0,2.5f);
            this.temp.set(this.position);
        }
        if (this.position.y - this.temp.y>=100)
        if (this.position.x>=1250){
            this.velocity.set(-2.5f, 0);
            this.temp.set(this.position);
        }else{
            this.velocity.set(2.5f,0);
            this.temp.set(this.position);
        }
        if (this.position.y>750){
            this.isAlive = false;
        }
    }
}

