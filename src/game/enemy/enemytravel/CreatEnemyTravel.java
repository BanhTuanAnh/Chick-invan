package game.enemy.enemytravel;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.enemymatrix.EnemyMatrix;

import java.util.Random;

public class CreatEnemyTravel extends GameObject {
    private int i;
    private Random random = new Random();
//    private Vector2D tempPosition = new Vector2D();
    private Vector2D tempPosition = new Vector2D().set(random.nextInt(2)*1300,0);
    private Vector2D tempVelocity = new Vector2D();
    private FrameCounter frameCounter = new FrameCounter();

//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.compare(400)) {
//            for (i = 0; i <= 9; i++) {
//                if (i == 0) {
//                    EnemyTravel enemyTravel = new EnemyTravel();
//                    enemyTravel.position.set(random.nextInt(2)*600,random.nextInt(100));
//                    GameObjectManager.instance.add(enemyTravel);
//                    this.tempPosition.set(enemyTravel.position);
//                    if(enemyTravel.position.x == 600){
//                        enemyTravel.velocity.set(-2.5f,2.5f);
//                        this.tempVelocity.set(enemyTravel.velocity);
//                    }else{
//                        enemyTravel.velocity.set(2.5f,2.5f);
//                        this.tempVelocity.set(enemyTravel.velocity);
//                    }
//                    GameObjectManager.instance.add(enemyTravel);
//                }else{
//                    EnemyTravel enemyTravel = new EnemyTravel();
//                    enemyTravel.position.set(this.tempPosition.x - this.tempVelocity.x*i*10,this.tempPosition.y - this.tempVelocity.y*i*10);
//                    enemyTravel.velocity.set(this.tempVelocity);
//                    GameObjectManager.instance.add(enemyTravel);
//                }
//            }
//        }
//        this.frameCounter.run();
//    }

    @Override
    public void run() {
        // Initialise value của tempPos vs tempVel trên Attribute luôn không cần phải tạo riêng 1 con enemyTravel đi đàu nữa
        super.run();
        if (this.frameCounter.compare(400)) {
            if(this.tempPosition.x == 1300){
                this.tempVelocity.set(-2.5f,2.5f);
            }else{
                this.tempVelocity.set(2.5f,2.5f);
            }
            for (i = 0; i <= 9; i++) {
                EnemyTravel enemyTravel = new EnemyTravel();
                enemyTravel.position.set(this.tempPosition.x - this.tempVelocity.x*i*25,this.tempPosition.y - this.tempVelocity.y*i*5);
                enemyTravel.velocity.set(this.tempVelocity);
                GameObjectManager.instance.add(enemyTravel);
            }
        }
        this.frameCounter.run();
    }
}