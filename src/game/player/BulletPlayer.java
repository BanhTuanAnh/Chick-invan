package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.enemymatrix.EnemyMatrix;
import game.enemy.enemytravel.EnemyTravel;
import physic.BoxCollider;
import renderer.ImageRenderer;
import renderer.OvalRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("image/bolt.png",30,60);
        this.boxCollider = new BoxCollider(30,60);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x -15,this.position.y - 30f);
        EnemyMatrix enemyMatrix = GameObjectManager.instance.checkCollision2(this);
        if(enemyMatrix != null){
            enemyMatrix.isAlive = false;
            this.isAlive = false;
        }
        EnemyTravel enemyTravel = GameObjectManager.instance.checkCollision1(this);
        if(enemyTravel != null){
            enemyTravel.isAlive = false;
            this.isAlive = false;
        }
    }
}