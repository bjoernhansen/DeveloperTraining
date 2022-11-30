package training.javafx.games.jumping_in_the_forest;


import static training.javafx.games.algebra.Math.random;


import java.util.List;


import training.javafx.games.algebra.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class Boy extends GameObject
{    
    private static final String 
        BOY_IMAGE_PATH = "images/boy.png";
    
    private final Image
        boyImage = new Image(fromUrlOf(BOY_IMAGE_PATH));
       
    private static final double
        SPEED_REDUCTION_FACTOR = 0.3,
        FRICTION = 0.9875,
        SOMERSAULT_PROBABILITY = 0.3,
        GRAVITATIONAL_ACCELERATION = 1.1,
        RUNNING_ACCELERATION = 0.25,
        JUMP_SPEED = -20,
        SOMERSAULT_SPEED = 10;
               
    private static final int 
        RIGHT = 1,
        LEFT = -1,        
        OFFSET_BOY_Y = 561;
    
    private static final Rectangle 
        STARTING_BOUNDS = new Rectangle(524, 577, 84, 111);
          
    private ImageView       
        view;
        
    private final BoyAnimator
        animator;
        
    private final
    Voice voice;
    
    private Point 
        acceleration,
        velocity;
    
    private Plateau 
        floor;
    
    private int 
        runningDirection,
        rotate_direction;
       
    private double 
        rotationSpeed,
        baseLineY;
    
            
    Boy()
    {
        this.prepareView();        
        this.setAndPaintBounds();
        this.setMovementProperties();
        this.setFloor(null);
        this.voice = new Voice();
        this.animator = new BoyAnimator(this.view);
    }
    
    private void prepareView()
    {
        this.view = new ImageView(boyImage);
        this.view.setLayoutX(JumpingInTheForest.SCREEN_SIZE.width/2.0);
        this.view.setLayoutY(OFFSET_BOY_Y);
    }

    private void setAndPaintBounds()
    {
        this.bounds = new Rectangle(  STARTING_BOUNDS.getX(), 
                STARTING_BOUNDS.getY(), 
                STARTING_BOUNDS.getWidth(), 
                STARTING_BOUNDS.getHeight());
        this.bounds.setFill(new Color(0, 0, 0, 0));
    }
    
    private void setMovementProperties()
    {
        this.runningDirection = RIGHT;
        this.velocity = new Point(0, 0);
        this.acceleration = new Point(0, 0);
        this.rotationSpeed = 0;
        this.rotate_direction = this.runningDirection;
    }
    
    void startAccelerating()
    {
        this.acceleration.setX(this.runningDirection * RUNNING_ACCELERATION);       
    }    
    
    void stopAccelerating()
    {
        this.acceleration.setX(-Math.signum(this.velocity.getX()) * 0.02);
    }    

    ImageView getView()
    {
        return this.view;
    }
    
    Point getVelocity()
    {
        return this.velocity;
    }
    
    private void setRotationSpeed(double rotationSpeed)
    {
        this.rotationSpeed = rotationSpeed;
    }

    void updateAndCheck(List<Plateau> plateaus)
    {       
        this.check(plateaus);        
        this.updateAcceleration();
        this.updateVelocity();   
        this.updateCollisionBounds();        
        this.updateView();        
    }
    
    private void check(List<Plateau> plateaus)
    {
        if(this.hasLostFooting())
        {            
            this.startFalling();
        }
        if(this.isFalling())
        {            
            this.selectClosestFloorFrom(plateaus);
        }
    }

    private void updateAcceleration()
    {
        if(this.hasAlmostStopped())
        {
            this.acceleration.setX(0);            
        }
    }

    private boolean hasAlmostStopped()
    {        
        return Math.abs(this.acceleration.getX()) < RUNNING_ACCELERATION
               && Math.signum(this.velocity.getX()) !=  Math.signum(this.velocity.getX() + this.acceleration.getX());
    }

    private void updateVelocity()
    {
        this.velocity.setX(FRICTION*(this.velocity.getX() + this.acceleration.getX()));        
        this.velocity.setY(this.velocity.getY() + this.acceleration.getY());        
        if( this.bounds.getY() + this.velocity.getY() > this.baseLineY)
        {
            this.landOnFloor();
        }
    }

    private void landOnFloor()
    {
        this.acceleration.setY(0);
        this.velocity.setY(this.baseLineY - this.bounds.getY());
        this.view.setRotate(0);     
        this.setRotationSpeed(0);
        this.animator.play();
    }

    private void updateCollisionBounds()
    {
        this.bounds.setX(this.bounds.getX() + this.velocity.getX());
        this.bounds.setY(this.bounds.getY() + this.velocity.getY());
    }

    private void updateView()
    {
        this.view.setLayoutX(this.view.getLayoutX() + this.velocity.getX());
        this.view.setLayoutY(this.view.getLayoutY() + this.velocity.getY());
        this.view.setRotate(this.view.getRotate() + this.rotate_direction * this.rotationSpeed);        
    }
   
    void turnLeft()
    {        
        this.turn(LEFT);
    }
    
    void turnRight()
    {
        this.turn(RIGHT);        
    }

    private void turn(int direction)
    {
        this.velocity.setX(SPEED_REDUCTION_FACTOR * this.velocity.getX());
        this.runningDirection = direction;           
        this.animator.fitTo(direction == RIGHT);    
        this.rotate_direction = direction;
    }
    
    boolean isRunningToTheRight()
    {
        return this.runningDirection == RIGHT;
    }
    
    boolean isRunningToTheLeft()
    {
        return this.runningDirection == LEFT;
    }

    boolean isOnTheGround()
    {
        return this.acceleration.getY() == 0;
    }

    void jump()
    { 
        this.acceleration.setY(GRAVITATIONAL_ACCELERATION);
        this.setFloor(null);
        this.velocity.setY(JUMP_SPEED);        
        if(Math.random() < SOMERSAULT_PROBABILITY)
        {
            this.setRotationSpeed(SOMERSAULT_SPEED);
            if(random.nextBoolean()){this.animator.pause();}
            this.voice.shoutSomersault();
        }  
        else
        {
            this.voice.shoutJump();
        }
    }

    private void selectClosestFloorFrom(List<Plateau> plateaus)
    {
       Plateau closestFloor = null;
       for(Plateau plateau : plateaus)
       {           
           if(plateau.isBelow(this))
           {  
               if(closestFloor == null || (plateau.getMinY() < closestFloor.getMinY()) )
               {
                   closestFloor = plateau;
               }
           }
       }
       if(closestFloor != null)
       {
           this.setFloor(closestFloor); 
       }
       else
       {
           this.resetBaseLineY();           
       }
    }
    
    private void setFloor(Plateau closestFloor)
    {
        this.floor = closestFloor;
        if(this.floor == null)
        {
            this.resetBaseLineY();
        }
        else
        {
            this.baseLineY = this.floor.getMinY() - STARTING_BOUNDS.getHeight();            
        }
    }
    
    private void resetBaseLineY()
    {
        this.baseLineY = STARTING_BOUNDS.getY();
    }
    
    private boolean hasLostFooting()
    {       
        return !this.isFalling() && !this.isStandingSave();
    }

    private boolean isFalling()
    {        
        return this.velocity.getY() > 0;
    }

    private boolean isStandingSave()
    {
        return this.floor == null || this.floor.isBelow(this);
    }

    private void startFalling()
    {
        this.acceleration.setY(GRAVITATIONAL_ACCELERATION);        
        this.setFloor(null);        
    }   
}