package game.enemy.enemymatrix;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

public class CreatEnemyMatrix extends GameObject {
    private int i;
    private FrameCounter frameCounter = new FrameCounter();
    @Override
    public void run() {
        super.run();
        if (this.frameCounter.compare(400)) {
            for(i=0;i<=15;i++) {
                EnemyMatrix enemyMatrix = new EnemyMatrix();
                enemyMatrix.position.set((i%8)*70,(i/8)*40);
                GameObjectManager.instance.add(enemyMatrix);
            }
        }
        this.frameCounter.run();
    }
}
